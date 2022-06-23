package br.com.escola.api.model.dto;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class TurmaInputTest {

	@Test
	public void getAndSetTest() {
		TurmaInput turmaInput = new TurmaInput();
		turmaInput = new TurmaInput(1l, "", new ArrayList<>(), new ArrayList<>(), new CursoIdInput());
		turmaInput.setSemestre(1l);
		turmaInput.setAno("");
		turmaInput.setAlunosList(new ArrayList<>());
		turmaInput.setProfessoresList(new ArrayList<>());
		turmaInput.setCurso(new CursoIdInput());

		turmaInput.getSemestre();
		turmaInput.getAno();
		turmaInput.getAlunosList();
		turmaInput.getCurso();
		turmaInput.getProfessoresList();
	}
}