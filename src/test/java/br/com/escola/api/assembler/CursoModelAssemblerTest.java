package br.com.escola.api.assembler;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import br.com.escola.core.modelmapper.ModelMapperConfig;

class CursoModelAssemblerTest {

	@InjectMocks
	CursoModelAssembler cursoModelAssembler;

	@Test
	public void toCollectionModel_cursoModelAssemblerTest() {
		cursoModelAssembler.toCollectionModel(null);
	}

	@Test
	public void toModel_cursoModelAssemblerTest() {
		cursoModelAssembler.toModel(null);
	}
}