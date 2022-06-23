package br.com.escola.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.escola.api.model.dto.AlunoInput;
import br.com.escola.domain.model.entity.Aluno;

@Component
public class AlunoInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Aluno toDomainObject(AlunoInput alunoInput) {
		return modelMapper.map(alunoInput, Aluno.class);
	}
	
	public void copyToDomainObject(AlunoInput alunoInput, Aluno aluno) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of 
		// com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2

		
		
		//		restaurante.setCozinha(new Cozinha());
		
		modelMapper.map(alunoInput, aluno);
	}
	
}
