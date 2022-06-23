package br.com.escola.api.model.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProfessorInput {

	private String nome;
	
	@Valid
	@NotNull
	private EnderecoIdInput endereco;
}
