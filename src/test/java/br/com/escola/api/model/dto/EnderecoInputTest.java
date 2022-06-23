package br.com.escola.api.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EnderecoInputTest {

	@Test
	public void getAndSetTest() {
		EnderecoIdInput enderecoIdInput = new EnderecoIdInput();
		enderecoIdInput.setId(1l);
		enderecoIdInput.getId();
		
		EnderecoInput enderecoInput = new EnderecoInput();
		enderecoInput.setId(1l);
		enderecoInput.getId();
	}
}