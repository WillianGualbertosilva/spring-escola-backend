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

import br.com.escola.api.assembler.ProfessorInputDisassembler;
import br.com.escola.api.assembler.ProfessorModelAssembler;
import br.com.escola.api.model.ProfessorModel;
import br.com.escola.api.model.dto.ProfessorInput;
import br.com.escola.api.service.ProfessorService;
import br.com.escola.domain.exception.EnderecoNaoEncontradoException;
import br.com.escola.domain.exception.NegocioException;
import br.com.escola.domain.model.entity.Professor;


@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private ProfessorModelAssembler professorModelAssembler;
	
	@Autowired
	private ProfessorInputDisassembler professorInputDisassembler;

	@GetMapping
	public List<ProfessorModel> findAll() {
		return professorModelAssembler.toCollectionModel(professorService.findAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProfessorModel save(@RequestBody @Valid ProfessorInput professorInput) {
		try {
			Professor professor = professorInputDisassembler.toDomainObject(professorInput);
			return professorModelAssembler.toModel(professorService.save(professor));
		} catch (EnderecoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{professorId}")
	public ProfessorModel buscar(@PathVariable Long professorId) {
		Professor professor = professorService.findById(professorId);

		return professorModelAssembler.toModel(professor);
	}

	@PutMapping("/{professorId}")
	public ProfessorModel atualizar(@PathVariable Long professorId, @RequestBody @Valid ProfessorInput professorInput) {
		try {
			Professor professorAtual = professorService.findById(professorId);

			professorInputDisassembler.copyToDomainObject(professorInput, professorAtual);

			professorAtual = professorService.save(professorAtual);

			return professorModelAssembler.toModel(professorAtual);
		} catch (EnderecoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{professorId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long professorId) {
		professorService.delete(professorId);
	}
}