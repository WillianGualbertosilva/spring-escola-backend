package br.com.escola.domain.model.entity;

import org.junit.jupiter.api.Test;

class EnderecoTest {

	@Test
	public void enderecoTest() {
		Endereco endereco = new Endereco();
		endereco = new Endereco(1l);
		endereco.setId(1l);
		endereco.getId();
	}
}