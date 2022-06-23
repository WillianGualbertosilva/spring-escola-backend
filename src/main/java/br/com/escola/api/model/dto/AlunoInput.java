package br.com.escola.api.model.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.escola.domain.model.enums.StatusAlunoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoInput {

	@NotBlank
	private String nome;
	@Enumerated(EnumType.STRING)
	private StatusAlunoEnum status;

	@Valid
	@NotNull
	private EnderecoIdInput endereco;
}