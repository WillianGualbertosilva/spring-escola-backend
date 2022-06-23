package br.com.escola.api.assembler;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class CursoInputDisassemblerTest {

	@InjectMocks
	CursoInputDisassembler cursoInputDisassembler;

	@Test
	public void cursoInputDisassemblerTest() {
//		CursoInput cursoInput = new CursoInput();
//		Curso curso = new Curso(1l, "Direito", "DIR");
//		cursoInputDisassembler.copyToDomainObject(cursoInput, curso);
//		cursoInputDisassembler.toDomainObject(cursoInput);
		
		System.out.println(cursoInputDisassembler);
	}
}