package br.com.escola.api.service;

import java.util.List;

import br.com.escola.domain.model.entity.Turma;

public interface TurmaService {

	List<Turma> findAll();

	Turma findById(Long turmaId);

	Turma save(Turma turma);

	void delete(Long turmaId);

}
