package br.com.escola.api.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ProfessorModelTest {

	@Test
	public void getAndSetTest() {
		ProfessorModel professorModel = new ProfessorModel();
		professorModel.setNome("Direito");
		professorModel.setId(1l);
		professorModel.setEndereco(new EnderecoModel());
		professorModel.getNome();
		professorModel.getId();
		professorModel.getEndereco();
	}
}