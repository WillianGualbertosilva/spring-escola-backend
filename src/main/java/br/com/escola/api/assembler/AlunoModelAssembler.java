package br.com.escola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.escola.api.model.AlunoModel;
import br.com.escola.domain.model.entity.Aluno;

@Component
public class AlunoModelAssembler {
	@Autowired
	private ModelMapper modelMapper;

	public AlunoModel toModel(Aluno aluno) {
		return modelMapper.map(aluno, AlunoModel.class);
	}

	public List<AlunoModel> toCollectionModel(List<Aluno> alunos) {
		return alunos.stream().map(aluno -> toModel(aluno)).collect(Collectors.toList());
	}
}
