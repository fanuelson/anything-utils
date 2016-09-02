package br.com.any.model.test;

import br.com.any.anotacao.Atributo;

public class Pessoa {

	private static Long ID_CONT = 1L;
	
	private Long id ;
	
	@Atributo
	private String nome;
	
	private Bola bola = new Bola();
	
	public Pessoa(){
		
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa save(){
		this.id = ID_CONT;
		ID_CONT++;
		return this;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", bola=" + bola + "]";
	}

}
