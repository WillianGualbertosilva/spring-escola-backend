package br.com.escola.api.assembler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.escola.api.model.dto.CursoInput;
import br.com.escola.domain.model.entity.Curso;

@Component
public class CursoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Curso toDomainObject(CursoInput cursoInput) {
		return modelMapper.map(cursoInput, Curso.class);
	}
	
	public void copyToDomainObject(CursoInput cursoInput, Curso curso) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of 
		// com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2

		
		
		//		restaurante.setCozinha(new Cozinha());
		
		modelMapper.map(cursoInput, curso);
	}
	
}
