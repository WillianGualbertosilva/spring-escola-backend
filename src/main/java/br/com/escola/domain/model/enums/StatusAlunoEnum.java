package br.com.escola.domain.model.enums;

import lombok.Getter;

@Getter
public enum StatusAlunoEnum {
	INICIADO(1,"INICIADO"), CONCLUIDO(2,"CONCLUIDO"),INTERROMPIDO(3,"INTERROMPIDO");
	
	private Integer id;
	private String description;
	
	StatusAlunoEnum(Integer id, String description) {
		this.id=id;
		this.description=description;
	}
}
