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

import br.com.escola.api.assembler.AlunoInputDisassembler;
import br.com.escola.api.assembler.AlunoModelAssembler;
import br.com.escola.api.model.AlunoModel;
import br.com.escola.api.model.dto.AlunoInput;
import br.com.escola.api.service.AlunoService;
import br.com.escola.domain.exception.AlunoNaoEncontradoException;
import br.com.escola.domain.exception.EnderecoNaoEncontradoException;
import br.com.escola.domain.exception.NegocioException;
import br.com.escola.domain.model.entity.Aluno;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AlunoModelAssembler alunoModelAssembler;
	
	@Autowired
	private AlunoInputDisassembler alunoInputDisassembler;

	@GetMapping
	public List<AlunoModel> findAll() {
		return alunoModelAssembler.toCollectionModel(alunoService.findAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AlunoModel save(@RequestBody @Valid AlunoInput alunoInput) {
		try {
			Aluno aluno = alunoInputDisassembler.toDomainObject(alunoInput);
			return alunoModelAssembler.toModel(alunoService.save(aluno));
		} catch (EnderecoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{alunoId}")
	public AlunoModel buscar(@PathVariable Long alunoId) {
		Aluno aluno = alunoService.findById(alunoId);

		return alunoModelAssembler.toModel(aluno);
	}

	@PutMapping("/{alunoId}")
	public AlunoModel atualizar(@PathVariable Long alunoId, @RequestBody @Valid AlunoInput alunoInput) {
		try {
			Aluno alunoAtual = alunoService.findById(alunoId);

			alunoInputDisassembler.copyToDomainObject(alunoInput, alunoAtual);

			alunoAtual = alunoService.save(alunoAtual);

			return alunoModelAssembler.toModel(alunoAtual);
		} catch (AlunoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{alunoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long alunoId) {
		alunoService.delete(alunoId);
	}
}
