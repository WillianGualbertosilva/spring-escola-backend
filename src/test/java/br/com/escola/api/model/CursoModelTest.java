package br.com.escola.api.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class CursoModelTest {

	@Test
	public void getAndSetTest() {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setNome("Direito");
		cursoModel.setSigla("DIR");
		cursoModel.getNome();
		cursoModel.getSigla();
	}
}