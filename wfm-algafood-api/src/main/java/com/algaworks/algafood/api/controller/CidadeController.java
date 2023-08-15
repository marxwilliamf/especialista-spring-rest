package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.execption.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroCidadeService cadastroCidade;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
			Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
			
			if(cidade.isPresent()) {
				return ResponseEntity.ok(cidade.get());
			}
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
		if(cidade.getEstado() != null && cidade.getEstado().getId() != null) {
			try {
				cidade = cadastroCidade.salvar(cidade);
				return ResponseEntity.ok(cidade);
			} catch(EntidadeNaoEncontradaException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			} 
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nessesário inserir um estado existente");
		}
	}
	
	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
		Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
		Long estadoId = null;
		if(cidade.getEstado() != null && cidade.getEstado().getId() != null) {
			estadoId = cidade.getEstado().getId();
			Optional<Estado> estado = estadoRepository.findById(estadoId);
			if(estado.isPresent()) {
				cidade.setEstado(estado.get());
				if(cidadeAtual.isPresent() || estadoId == null) {
					System.out.println("estado id = " + estadoId);
					
					BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
					Cidade cidadeSalva = cadastroCidade.salvar(cidadeAtual.get());
					return ResponseEntity.ok(cidadeSalva);
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						String.format("Não encontrado cidade de código %d", cidadeId));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						String.format("Não encontrado estado de código %d", estadoId));
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nessesário inserir um estado existente");
		}
	}
	
	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> remover(@PathVariable Long cidadeId) {		
		try {
			cadastroCidade.excluir(cidadeId);
			return ResponseEntity.noContent().build();
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		//return ResponseEntity.notFound().build();
	}
}




















