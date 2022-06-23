package br.com.escola.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.escola.api.model.dto.ProfessorInput;
import br.com.escola.domain.model.entity.Professor;

@Component
public class ProfessorInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Professor toDomainObject(ProfessorInput professorInput) {
		return modelMapper.map(professorInput, Professor.class);
	}
	
	public void copyToDomainObject(ProfessorInput professorInput, Professor professorAtual) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of 
		// com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2

		
		
		//		restaurante.setCozinha(new Cozinha());
		
		modelMapper.map(professorInput, professorAtual);
	}
	
}
