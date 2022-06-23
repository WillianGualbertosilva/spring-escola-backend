package br.com.escola.api.model;

import br.com.escola.api.model.dto.EnderecoInput;
import br.com.escola.domain.model.enums.StatusAlunoEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlunoModel {
	private Long id;
	private String nome;
	private StatusAlunoEnum status;
	private EnderecoInput endereco;
}
