package com.algaworks.algafood.api.controller;

import java.util.List;

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

import com.algaworks.algafood.domain.execption.EntidadeEmUsoException;
import com.algaworks.algafood.domain.execption.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@GetMapping
	public List<Estado> listar() {
		return estadoRepository.listar();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
		Estado estado = estadoRepository.buscar(estadoId);
		
		if(estado != null) {
			return ResponseEntity.ok(estado);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado) {
			return estadoRepository.salvar(estado);		
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<?> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {
		
		Estado estadoAtual = estadoRepository.buscar(estadoId);
	
		BeanUtils.copyProperties(estado, estadoAtual, "id");
		estadoAtual = cadastroEstado.salvar(estadoAtual);
		
		if(estadoAtual != null) {
			return ResponseEntity.ok(estadoAtual);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> exluir(@PathVariable Long estadoId) {
		try {
			cadastroEstado.excluir(estadoId);
			return ResponseEntity.noContent().build();
		} catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage()); 	 
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
