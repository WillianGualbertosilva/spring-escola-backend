package br.com.escola.api.model.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurmaInput {

	private Long semestre;
	@NotBlank
	private String ano;

	@Valid
	private List<AlunoIdInput> alunosList;

	@Valid
	private List<ProfessorIdInput> professoresList;

	@Valid
	@NotNull
	private CursoIdInput curso;
}