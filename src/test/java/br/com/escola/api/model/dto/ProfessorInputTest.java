package br.com.escola.api.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ProfessorInputTest {

	@Test
	public void getAndSetTest() {
		ProfessorIdInput professorIdInput = new ProfessorIdInput();
		professorIdInput.setId(1l);
		professorIdInput.getId();
		
		ProfessorInput professorInput = new ProfessorInput();
		professorInput.setNome("Alberto");
		professorInput.setEndereco(new EnderecoIdInput());
		professorInput.getNome();
		professorInput.getEndereco();
	}
}