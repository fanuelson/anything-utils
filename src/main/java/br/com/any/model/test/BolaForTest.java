package br.com.any.model.test;

public class BolaForTest {

	private String nomeBola ;

	public String getNomeBola() {
		return nomeBola;
	}

	public void setNomeBola(String nomeBola) {
		this.nomeBola = nomeBola;
	}

	@Override
	public String toString() {
		return "Bola [nomeBola=" + nomeBola + "]";
	}
	
}