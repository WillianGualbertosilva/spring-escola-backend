package br.com.escola.api.model;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.escola.domain.model.entity.Curso;

@RunWith(MockitoJUnitRunner.class)
class TurmaModelTest {

	@Test
	public void getAndSetTest() {
		TurmaModel TurmaModel = new TurmaModel();
		TurmaModel.setId(1l);
		TurmaModel.setAno("");
		TurmaModel.setSemestre("");
		TurmaModel.setCurso(new Curso());
		TurmaModel.setAlunosList(new ArrayList<>());
		TurmaModel.setProfessoresList(new ArrayList<>());
		
		TurmaModel.getId();
		TurmaModel.getAno();
		TurmaModel.getSemestre();
		TurmaModel.getCurso();
		TurmaModel.getAlunosList();
		TurmaModel.getProfessoresList();
	}
}