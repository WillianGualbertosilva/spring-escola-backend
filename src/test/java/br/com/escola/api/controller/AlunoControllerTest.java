package br.com.escola.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoControllerTest {

	@GetMapping
	public String teste() {
		return "teste aluno";
	}
}
