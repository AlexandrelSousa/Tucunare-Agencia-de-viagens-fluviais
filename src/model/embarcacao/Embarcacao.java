package model.embarcacao;

import model.empresa.Empresa;

public class Embarcacao {
	
	private static int prox_id= 17500;
	
	private String id;
	private String nome;
	private int lotacao;
	private Empresa proprietário;
	
	//Construtor
	public Embarcacao(String nome, int lotacao, Empresa proprietário) {
		this.id =  String.valueOf(Embarcacao.prox_id);
		this.nome = nome;
		this.lotacao = lotacao;
		this.proprietário = proprietário;
		
		// incrementar o id da Embarcação
		prox_id++;
	}
    
	//Métodos gets e sets
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Empresa getProprietário() {
		return proprietário;
	}

	public void setProprietário(Empresa proprietário) {
		this.proprietário = proprietário;
	}
	    
}
