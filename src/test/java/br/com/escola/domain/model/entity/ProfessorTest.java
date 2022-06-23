package br.com.escola.domain.model.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ProfessorTest {

	@Test
	public void alunoTest() {
		Professor professor = new Professor();
		professor = new Professor(1l, "", OffsetDateTime.now(), new Endereco(), new ArrayList<>());
		
		professor.setId(1l);
		professor.setNome("");
		professor.setEndereco(new Endereco());
		professor.setTurmaList(new ArrayList<>());
		professor.getId();
		professor.getNome();
		professor.getEndereco();
		professor.getTurmaList();
		
		
	}
}