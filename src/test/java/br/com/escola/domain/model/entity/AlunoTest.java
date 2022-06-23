package br.com.escola.domain.model.entity;

import org.junit.jupiter.api.Test;

class AlunoTest {

	@Test
	public void alunoTest() {
		Aluno aluno = new Aluno();
		aluno = new Aluno(1l, "", null, new Endereco(), null);
		aluno.setId(1l);
		aluno.setNome("");
		aluno.setEndereco(new Endereco());

		aluno.getId();
		aluno.getNome();
		aluno.getEndereco();
	}
}