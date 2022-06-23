//package br.com.escola.domain.model.entity;
//
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "professor_turma")
//public class ProfessorTurma {
//
//	@EmbeddedId
//	ProfessorTurmaId id;
//
//	@ManyToOne
//	@MapsId("professorId")
//	@JoinColumn(name = "professor_id")
//	Professor professor;
//
//	@ManyToOne
//	@MapsId("turmaId")
//	@JoinColumn(name = "turma_id")
//	Turma turma;
//}