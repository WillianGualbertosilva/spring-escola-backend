package br.com.escola.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.escola.domain.model.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
