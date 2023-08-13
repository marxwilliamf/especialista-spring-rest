package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.execption.EntidadeEmUsoException;
import com.algaworks.algafood.domain.execption.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
						String.format("Eroo ao salvar cidade por que o estado de código %d não existe", estadoId)
					);
		}
		cidade.setEstado(estado);

		return cidadeRepository.save(cidade);
}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
		} catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
						String.format("Não existe cidade com código %d", cidadeId)
					);
		} catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
						String.format("Cidade de código %d não pode ser excluida pois está em uso", cidadeId)
					);
		}
	}
	
}
