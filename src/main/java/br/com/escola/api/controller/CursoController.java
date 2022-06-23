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

import br.com.escola.api.assembler.CursoInputDisassembler;
import br.com.escola.api.assembler.CursoModelAssembler;
import br.com.escola.api.model.CursoModel;
import br.com.escola.api.model.dto.CursoInput;
import br.com.escola.api.service.CursoService;
import br.com.escola.domain.exception.CursoNaoEncontradoException;
import br.com.escola.domain.exception.EnderecoNaoEncontradoException;
import br.com.escola.domain.exception.NegocioException;
import br.com.escola.domain.model.entity.Curso;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private CursoModelAssembler cursoModelAssembler;

	@Autowired
	private CursoInputDisassembler cursoInputDisassembler;

	@GetMapping
	public List<CursoModel> findAllCursos() {
		return cursoModelAssembler.toCollectionModel(cursoService.findAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CursoModel saveCurso(@RequestBody @Valid CursoInput cursoInput) {
		try {
			Curso curso = cursoInputDisassembler.toDomainObject(cursoInput);
			return cursoModelAssembler.toModel(cursoService.save(curso));
		} catch (EnderecoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{cursoId}")
	public CursoModel buscar(@PathVariable Long cursoId) {
		Curso curso = cursoService.findById(cursoId);

		return cursoModelAssembler.toModel(curso);
	}

	@PutMapping("/{cursoId}")
	public CursoModel atualizar(@PathVariable Long cursoId, @RequestBody @Valid CursoInput cursoInput) {
		try {
			Curso cursoAtual = cursoService.findById(cursoId);

			cursoInputDisassembler.copyToDomainObject(cursoInput, cursoAtual);

			cursoAtual = cursoService.save(cursoAtual);

			return cursoModelAssembler.toModel(cursoAtual);
		} catch (CursoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{cursoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cursoId) {
		cursoService.delete(cursoId);
	}
}
