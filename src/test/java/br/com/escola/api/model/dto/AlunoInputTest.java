package br.com.escola.api.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class AlunoInputTest {

	@Test
	public void getAndSetTest() {
		AlunoIdInput alunoIdInput = new AlunoIdInput();
		alunoIdInput.setId(1l);
		alunoIdInput.getId();
		
		AlunoInput alunoImput = new AlunoInput();
		alunoImput = new AlunoInput("", null, new EnderecoIdInput());
		alunoImput.setNome("");
		alunoImput.setEndereco(new EnderecoIdInput());
		alunoImput.getNome();
		alunoImput.getEndereco();
	}
}