package br.com.escola.api.model;

import java.util.List;

import br.com.escola.domain.model.entity.Aluno;
import br.com.escola.domain.model.entity.Curso;
import br.com.escola.domain.model.entity.Professor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TurmaModel {

	private Long id;
	private String semestre;
	private String ano;

	private List<Aluno> alunosList;

	private List<Professor> professoresList;

	private Curso curso;
}
