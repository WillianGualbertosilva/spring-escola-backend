package br.com.escola.api.service;

import java.util.List;

import br.com.escola.domain.model.entity.Professor;

public interface ProfessorService {

	List<Professor> findAll();

	Professor findById(Long professorId);

	Professor save(Professor professor);

	void delete(Long professorId);

}
