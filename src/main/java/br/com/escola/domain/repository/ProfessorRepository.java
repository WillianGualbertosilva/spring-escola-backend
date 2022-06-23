package br.com.escola.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.domain.model.entity.Professor;

public interface ProfessorRepository  extends JpaRepository<Professor, Long> {

}
