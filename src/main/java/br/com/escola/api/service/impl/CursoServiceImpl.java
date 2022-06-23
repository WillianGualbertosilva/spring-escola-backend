package br.com.escola.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.api.service.CursoService;
import br.com.escola.domain.exception.CursoNaoEncontradoException;
import br.com.escola.domain.exception.EntidadeEmUsoException;
import br.com.escola.domain.model.entity.Curso;
import br.com.escola.domain.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	
	private static final String MSG_CURSO_EM_USO = "Curso de código %d não pode ser removido, pois está em uso";

	@Autowired
	CursoRepository cursoRepository;

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();

	}

	@Override
	public Curso findById(Long cursoId) {
		return cursoRepository.findById(cursoId).orElseThrow(() -> new CursoNaoEncontradoException(cursoId));
	}

	@Override
	public Curso save(Curso cursoAtual) {
		return cursoRepository.save(cursoAtual);
	}

	@Override
	public void delete(Long cursoId) {
		try {
			cursoRepository.deleteById(cursoId);
			cursoRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new CursoNaoEncontradoException(cursoId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_CURSO_EM_USO, cursoId));
		}
	}

}
