package br.com.escola.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.api.service.AlunoService;
import br.com.escola.domain.exception.AlunoNaoEncontradoException;
import br.com.escola.domain.exception.EntidadeEmUsoException;
import br.com.escola.domain.model.entity.Aluno;
import br.com.escola.domain.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	private static final String MSG_ALUNO_EM_USO = "Aluno de código %d não pode ser removido, pois está em uso";

	@Autowired
	AlunoRepository alunoRepository;

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();

	}

	@Override
	public Aluno findById(Long alunoId) {
		return alunoRepository.findById(alunoId).orElseThrow(() -> new AlunoNaoEncontradoException(alunoId));
	}

	@Override
	public Aluno save(Aluno alunoAtual) {
		return alunoRepository.save(alunoAtual);
	}

	@Override
	public void delete(Long alunoId) {
		try {
			alunoRepository.deleteById(alunoId);
			alunoRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new AlunoNaoEncontradoException(alunoId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_ALUNO_EM_USO, alunoId));
		}
	}

}
