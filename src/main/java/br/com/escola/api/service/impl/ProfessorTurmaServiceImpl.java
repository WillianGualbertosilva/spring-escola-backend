//package br.com.escola.api.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import br.com.escola.api.service.ProfessorService;
//import br.com.escola.api.service.ProfessorTurmaService;
//import br.com.escola.domain.model.entity.Professor;
//import br.com.escola.domain.model.entity.ProfessorTurma;
//import br.com.escola.domain.model.entity.ProfessorTurmaId;
//import br.com.escola.domain.model.entity.Turma;
//import br.com.escola.domain.repository.ProfessorTurmaRepository;
//
//@Service
//public class ProfessorTurmaServiceImpl implements ProfessorTurmaService {
//
//	private static final String MSG_TURMA_EM_USO = "Turma de código %d não pode ser removida, pois está em uso";
//
//	@Autowired
//	private ProfessorTurmaRepository professorTurmaRepository;
//
//	@Autowired
//	private ProfessorService professorService;
//
////	public List<Turma> findAll() {
////		return turmaRepository.findAll();
////	}
////
////	@Override
////	public Turma findById(Long turmaId) {
////		return turmaRepository.findById(turmaId).orElseThrow(() -> new TurmaNaoEncontradaException(turmaId));
////	}
//
//	@Override
//	@Transactional
//	public ProfessorTurma save(ProfessorTurma professorTurma) {
//
////		turma.get
////		
////		
////		Long estadoId = turma.getEstado().getId();
////
////		Estado estado = cadastroEstado.buscarOuFalhar(estadoId);
//
////		turma.setEstado(estado);
//		Professor professor = professorService.findById(professorTurma.getProfessor().getId());
//		professorTurma.setProfessor(professor);
//		
////		ProfessorTurmaId professorTurmaId = new ProfessorTurmaId(professor.getId(), professorTurma.getTurma().getId());
////		professorTurmaId.set
//		
////		professorTurma.setId(1l);
//		return professorTurmaRepository.save(professorTurma);
//	}
//
////	@Override
////	@Transactional
////	public void delete(Long turmaId) {
////		try {
////			turmaRepository.deleteById(turmaId);
////			turmaRepository.flush();
////
////		} catch (EmptyResultDataAccessException e) {
////			throw new TurmaNaoEncontradaException(turmaId);
////
////		} catch (DataIntegrityViolationException e) {
////			throw new EntidadeEmUsoException(String.format(MSG_TURMA_EM_USO, turmaId));
////		}
////	}
//}
