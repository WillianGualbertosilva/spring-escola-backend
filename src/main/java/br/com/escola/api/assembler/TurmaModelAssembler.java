package br.com.escola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.escola.api.model.TurmaModel;
import br.com.escola.domain.model.entity.Turma;

@Component
public class TurmaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public TurmaModel toModel(Turma turma) {
		return modelMapper.map(turma, TurmaModel.class);
	}

	public List<TurmaModel> toCollectionModel(List<Turma> turmas) {
		return turmas.stream().map(turma -> toModel(turma)).collect(Collectors.toList());
	}
}
