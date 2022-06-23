package br.com.escola.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.api.service.ProfessorService;
import br.com.escola.domain.exception.EntidadeEmUsoException;
import br.com.escola.domain.exception.ProfessorNaoEncontradoException;
import br.com.escola.domain.model.entity.Professor;
import br.com.escola.domain.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	private static final String MSG_PROFESSOR_EM_USO = "Professor de código %d não pode ser removido, pois está em uso";

	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public List<Professor> findAll() {
		return professorRepository.findAll();

	}

	@Override
	public Professor findById(Long professorId) {
		return professorRepository.findById(professorId).orElseThrow(() -> new ProfessorNaoEncontradoException(professorId));
	}

	@Override
	public Professor save(Professor professorAtual) {
		return professorRepository.save(professorAtual);
	}

	@Override
	public void delete(Long professorId) {
		try {
			professorRepository.deleteById(professorId);
			professorRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ProfessorNaoEncontradoException(professorId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_PROFESSOR_EM_USO, professorId));
		}
	}

}
