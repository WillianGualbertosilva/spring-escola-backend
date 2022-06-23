package br.com.escola.api.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class CursoInputTest {

	@Test
	public void getAndSetTest() {
		CursoIdInput cursoIdInput = new CursoIdInput();
		cursoIdInput.setId(1l);
		cursoIdInput.getId();
		
		CursoInput cursoImput = new CursoInput();
		cursoImput = new CursoInput("","");
		cursoImput.setNome("");
		cursoImput.setSigla("");
		cursoImput.getNome();
		cursoImput.getSigla();
	}
}