package model.embarcacao;

import model.empresa.Empresa;

public class Embarcacao {
	
	private int id;
	private String nome;
	private int lotacao;
	private Empresa propritário;
	
	//Construtor
	public Embarcacao(int id, String nome, int lotacao, Empresa propritário) {
		this.id = id;
		this.nome = nome;
		this.lotacao = lotacao;
		this.propritário = propritário;
	}
    
	//Métodos gets e sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Empresa getPropritário() {
		return propritário;
	}

	public void setPropritário(Empresa propritário) {
		this.propritário = propritário;
	}
	
	
    
}
