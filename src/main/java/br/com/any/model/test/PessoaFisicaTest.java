package br.com.any.model.test;

public class PessoaFisicaTest extends Pessoa {
	
	private String cpf;

	public PessoaFisicaTest(String nome){
		super(nome);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
