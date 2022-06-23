package br.com.escola.api.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.escola.api.model.dto.EnderecoInput;

@RunWith(MockitoJUnitRunner.class)
class AlunoModelTest {

	@Test
	public void getAndSetTest() {
		AlunoModel alunoModel = new AlunoModel();
		alunoModel.setNome("Direito");
		alunoModel.setId(1l);
		alunoModel.setEndereco(new EnderecoInput());
		alunoModel.getNome();
		alunoModel.getId();
		alunoModel.getEndereco();
	}
}