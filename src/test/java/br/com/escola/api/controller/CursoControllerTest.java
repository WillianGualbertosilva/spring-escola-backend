package br.com.escola.api.controller;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.escola.api.assembler.CursoModelAssembler;
import br.com.escola.api.model.CursoModel;
import br.com.escola.domain.model.entity.Curso;

@RunWith(MockitoJUnitRunner.class)
class CursoControllerTest {

	@InjectMocks
	CursoController cursoController;

	@Mock
	CursoModelAssembler cursoModelAssembler;
	
	@Mock
	List<CursoModel> cursoModelList;
	
	@Test
	public void findAllCursos_cursoControllerTest() {
		List<Curso> cursoList = new ArrayList<>();
		Curso curso = new Curso(1l, "Direito", "DIR");
		cursoList.add(curso);
//		when(cursoModelAssembler.toCollectionModel(cursoList)).thenReturn(anyList());
		when(cursoModelAssembler.toCollectionModel(cursoList)).thenReturn(anyList());
		cursoController.findAllCursos();
		
	}
	
//	@Test
//	public void saveCurso_cursoControllerTest() {
//		
//		CursoModel saveCurso = cursoController.saveCurso(null);
//		assertNotNull(saveCurso);
//		
//	}
}