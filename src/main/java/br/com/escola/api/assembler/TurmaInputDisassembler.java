package br.com.escola.api.assembler;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.escola.api.model.dto.TurmaInput;
import br.com.escola.domain.model.entity.Curso;
import br.com.escola.domain.model.entity.Turma;

@Component
public class TurmaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Turma toDomainObject(TurmaInput turmaInput) {
		return modelMapper.map(turmaInput, Turma.class);
	}
	
	public void copyToDomainObject(TurmaInput turmaInput, Turma turmaAtual) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of 
		// com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2

		turmaAtual.setAlunosList(new ArrayList<>());
		turmaAtual.setCurso(new Curso());
//		turmaAtual.setProfessoresList(new ArrayList<>());
		
		modelMapper.map(turmaInput, turmaAtual);
	}
	
}
