package br.com.escola.api.service;

import java.util.List;

import br.com.escola.domain.model.entity.Curso;

public interface CursoService {

	List<Curso> findAll();

	Curso findById(Long cursoId);

	Curso save(Curso curso);

	void delete(Long cursoId);

}
