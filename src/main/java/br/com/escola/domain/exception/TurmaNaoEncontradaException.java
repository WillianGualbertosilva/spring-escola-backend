package br.com.escola.domain.exception;

public class TurmaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public TurmaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TurmaNaoEncontradaException(Long turmaId) {
		this(String.format("Não existe um cadastro de turma com código %d", turmaId));
	}
	
}
