package br.com.escola.api.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CursoIdInput {

	@NotNull
	private Long id;
}