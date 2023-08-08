package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.execption.EntidadeEmUsoException;
import com.algaworks.algafood.domain.execption.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {		
		return estadoRepository.salvar(estado);
	}
	
	public void excluir(Long cidadeId) {
		try {
			estadoRepository.remover(cidadeId);
		}  catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException (
					String.format("Não é possivel deletar estado de código %d por que ela está em uso", cidadeId)
				);
		} catch(EmptyResultDataAccessException e) {
				throw new EntidadeNaoEncontradaException(
							String.format("Não existe estado com código %d", cidadeId)
						);
		}
	}
}
