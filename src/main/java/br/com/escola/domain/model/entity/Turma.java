package br.com.escola.domain.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String semestre;
	private String ano;

//	@OneToMany(mappedBy = "turma")
	@ManyToMany
	private List<Aluno> alunosList;

	@ManyToMany
	List<Professor> professoresList;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
}

//Produto.java
//
//@ManyToOne(cascade=CascadeType.ALL) 
//@JoinColumn(name="venda_id", referencedColumnName="id",nullable=false) 
//private Venda venda;
// 
//
//Venda.java
//
//@OneToMany(mappedBy="venda") 
//private Set<Produto> produto;