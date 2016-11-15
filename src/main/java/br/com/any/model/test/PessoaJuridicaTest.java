package br.com.any.model.test;

public class PessoaJuridicaTest extends Pessoa {

	private String cnpj;
	
	public PessoaJuridicaTest(String nome){
		super(nome);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
