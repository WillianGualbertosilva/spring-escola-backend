package br.com.escola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.escola.api.model.ProfessorModel;
import br.com.escola.domain.model.entity.Professor;

@Component
public class ProfessorModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProfessorModel toModel(Professor professor) {
		return modelMapper.map(professor, ProfessorModel.class);
	}

	public List<ProfessorModel> toCollectionModel(List<Professor> professores) {
		return professores.stream().map(professor -> toModel(professor)).collect(Collectors.toList());
	}
}
