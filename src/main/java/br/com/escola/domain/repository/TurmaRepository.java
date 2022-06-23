package br.com.escola.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.domain.model.entity.Turma;

public interface TurmaRepository  extends JpaRepository<Turma, Long> {

}
