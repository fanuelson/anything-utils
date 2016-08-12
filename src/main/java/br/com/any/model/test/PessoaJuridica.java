package br.com.any.model.test;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	
	public PessoaJuridica(String nome){
		super(nome);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
