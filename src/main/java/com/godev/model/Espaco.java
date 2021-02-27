package com.godev.model;

public class Espaco {
	private String nome;
	private int lotacao;

	public Espaco() {

	}
	
	

	public Espaco(String nome, int lotacao) {
		
		this.nome = nome;
		this.lotacao = lotacao;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}



	@Override
	public String toString() {
		return "Espaco [nome=" + nome + ", lotacao=" + lotacao + "]";
	}

}
