package br.com.escola.api.service;

import java.util.List;

import br.com.escola.domain.model.entity.Aluno;

public interface AlunoService {

	List<Aluno> findAll();

	Aluno findById(Long alunoId);

	Aluno save(Aluno aluno);

	void delete(Long alunoId);

}
