package br.com.escola.domain.model.entity;

import org.junit.jupiter.api.Test;

class CursoTest {

	@Test
	public void cursoTest() {
		Curso curso = new Curso();
		curso = new Curso(1l, "", "");
		curso.setId(1l);
		curso.setNome("");
		curso.setSigla("");

		curso.getId();
		curso.getNome();
		curso.getSigla();
	}
}