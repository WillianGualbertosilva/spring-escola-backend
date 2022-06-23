package br.com.escola.domain.model.entity;

import org.junit.jupiter.api.Test;

class TurmaTest {

	@Test
	public void alunoTest() {
		Turma turma = new Turma();
		turma = new Turma(1l, "", "", null, null, null);
		turma.setId(1l);
		turma.setAno("");
		turma.setSemestre("");
		turma.setAlunosList(null);
		turma.setCurso(null);
		
		turma.getId();
		turma.getSemestre();
		turma.getAlunosList();
		turma.getAno();
		turma.getCurso();
	}
}