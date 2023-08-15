package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.execption.EntidadeEmUsoException;
import com.algaworks.algafood.domain.execption.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteControler {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
	@GetMapping("{restauranteId}")
	public ResponseEntity<Restaurante> listar(@PathVariable Long restauranteId) {
		
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
	
		if(restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {
		if(restaurante.getCozinha() != null && restaurante.getCozinha().getId() != null) {
			try {
				restaurante = cadastroRestaurante.salvar(restaurante);
				return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
			} catch(EntidadeNaoEncontradaException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}	
		} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						"Necessario passar um código de cozinha existente");
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
		if(restaurante.getCozinha() != null && restaurante.getCozinha().getId() != null) {
			try {
				
				if(restauranteAtual.isPresent()) {
					BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id");
					restaurante = cadastroRestaurante.salvar(restauranteAtual.get());
					return ResponseEntity.ok(restaurante);
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						String.format("Não encontrado Restaurante de código %d", restauranteId)
						);
			} catch(EntidadeNaoEncontradaException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
							String.format("Não encontrado Cozinha de id %d", restaurante.getCozinha().getId())
						);
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					"Necessario passar um código de cozinha existente");
		}
	}
	
	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos) {
		Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
		if(restauranteAtual.isEmpty()) {
				return ResponseEntity.notFound().build();
		}
		
		Restaurante restaurante = restauranteAtual.get();
		merge(campos, restaurante);

		
		return atualizar(restauranteId, restaurante);
	}

	private void merge(Map<String, Object> dadosOrigem, Restaurante restaurantaAtual) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
	
//			System.out.println(nomePropriedade + " = " +  valorPropriedade);
			
			ReflectionUtils.setField(field, restaurantaAtual, novoValor);
		});
	}
	
	@DeleteMapping("/{restauranteId}")
	public void remover(@PathVariable Long restauranteId) {
		try {
			cadastroRestaurante.remover(restauranteId);
		} catch(EntidadeNaoEncontradaException e) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch(EntidadeEmUsoException e) {
			ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
