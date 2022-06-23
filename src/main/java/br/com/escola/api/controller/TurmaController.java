package br.com.escola.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.escola.api.assembler.TurmaInputDisassembler;
import br.com.escola.api.assembler.TurmaModelAssembler;
import br.com.escola.api.model.TurmaModel;
import br.com.escola.api.model.dto.TurmaInput;
import br.com.escola.api.service.TurmaService;
import br.com.escola.domain.exception.CursoNaoEncontradoException;
import br.com.escola.domain.exception.NegocioException;
import br.com.escola.domain.exception.ProfessorNaoEncontradoException;
import br.com.escola.domain.model.entity.Turma;
import br.com.escola.domain.repository.TurmaRepository;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {


	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private TurmaModelAssembler turmaModelAssembler;
	
	@Autowired
	private TurmaInputDisassembler turmaInputDisassembler;
	
	@GetMapping
	public List<TurmaModel> listar() {
		List<Turma> todasTurmas = turmaRepository.findAll();
		
		return turmaModelAssembler.toCollectionModel(todasTurmas);
	}
	
	@GetMapping("/{turmaId}")
	public TurmaModel buscar(@PathVariable Long turmaId) {
		Turma turma = turmaService.findById(turmaId);
		
		return turmaModelAssembler.toModel(turma);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TurmaModel adicionar(@RequestBody @Valid TurmaInput turmaInput) {
		try {
			Turma turma = turmaInputDisassembler.toDomainObject(turmaInput);
			turma       = turmaService.save(turma);

			
//			for (int i = 0; i < turma.getAlunosList().size(); i++) {
//				Aluno alunoPreenchido = alunoService.findById(turma.getAlunosList().get(i).getId());
//				alunoPreenchido.getTurma().setAlunosList(.setId(turma.getId());
//				turma.getAlunosList().set(i, alunoPreenchido);
//			}
			
			
			
			return turmaModelAssembler.toModel(turma);
		} catch (CursoNaoEncontradoException | ProfessorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	@PutMapping("/{turmaId}")
	public TurmaModel atualizar(@PathVariable Long turmaId,
			@RequestBody @Valid TurmaInput turmaInput) {
		try {
			Turma turmaAtual = turmaService.findById(turmaId);
			
			turmaInputDisassembler.copyToDomainObject(turmaInput, turmaAtual);
			
			turmaAtual = turmaService.save(turmaAtual);
			
			return turmaModelAssembler.toModel(turmaAtual);
		} catch (CursoNaoEncontradoException | ProfessorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	@DeleteMapping("/{turmaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long turmaId) {
		turmaService.delete(turmaId);	
	}
}
