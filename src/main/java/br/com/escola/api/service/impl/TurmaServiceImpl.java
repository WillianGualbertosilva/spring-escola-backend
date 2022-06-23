package br.com.escola.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.escola.api.service.AlunoService;
import br.com.escola.api.service.ProfessorService;
import br.com.escola.api.service.TurmaService;
import br.com.escola.domain.exception.EntidadeEmUsoException;
import br.com.escola.domain.exception.TurmaNaoEncontradaException;
import br.com.escola.domain.model.entity.Aluno;
import br.com.escola.domain.model.entity.Professor;
import br.com.escola.domain.model.entity.Turma;
import br.com.escola.domain.repository.TurmaRepository;

@Service
public class TurmaServiceImpl implements TurmaService {

	private static final String MSG_TURMA_EM_USO = "Turma de código %d não pode ser removida, pois está em uso";

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;

//	@Autowired
//	private ProfessorTurmaService professorTurmaService;

	@Override
	public List<Turma> findAll() {
		return turmaRepository.findAll();
	}

	@Override
	public Turma findById(Long turmaId) {
		return turmaRepository.findById(turmaId).orElseThrow(() -> new TurmaNaoEncontradaException(turmaId));
	}

	@Override
	@Transactional
	public Turma save(Turma turma) {

//		turma.getAlunosList().
//		
//		
//		Long estadoId = turma.getEstado().getId();
//
//		Estado estado = cadastroEstado.buscarOuFalhar(estadoId);

//		turma.setEstado(estado);

		for (int i = 0; i < turma.getAlunosList().size(); i++) {
			Aluno alunoExisteNoBanco = alunoService.findById(turma.getAlunosList().get(i).getId());
			turma.getAlunosList().set(i, alunoExisteNoBanco);
		}

//		turma.getProfessoresList().forEach(professor -> {
//			Professor professorExisteNoBanco = professorService.findById(professor.getId());
//			professor = professorExisteNoBanco;
////			turma.getAlunosList().set(i, professorExisteNoBanco);
//		});

		Turma turmaSaved = turmaRepository.save(turma);

//		for (ProfessorTurma professorTurma : turma.getProfessoresList()) {
//			professorTurma.setTurma(turmaSaved);
//			
//			Professor professor = professorService.findById(professorTurma.getProfessor().getId());
//			professorTurma.setProfessor(professor);
//
//			ProfessorTurmaId professorTurmaId = new ProfessorTurmaId(professor.getId(), turmaSaved.getId());
//			professorTurmaService.save(professorTurma);
//		}
		return turmaSaved;
	}

	@Override
	@Transactional
	public void delete(Long turmaId) {
		try {
			turmaRepository.deleteById(turmaId);
			turmaRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new TurmaNaoEncontradaException(turmaId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_TURMA_EM_USO, turmaId));
		}
	}
}
