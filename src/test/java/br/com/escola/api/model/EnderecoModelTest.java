package br.com.escola.api.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EnderecoModelTest {

	@Test
	public void getAndSetTest() {
		EnderecoModel enderecoModel = new EnderecoModel();
		enderecoModel = new EnderecoModel(1l);
		enderecoModel.setId(1l);
		enderecoModel.getId();
	}
}