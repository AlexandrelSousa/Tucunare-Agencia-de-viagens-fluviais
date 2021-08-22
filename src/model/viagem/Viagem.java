package model.viagem;

import java.util.*;
import model.linha.Linha;

public class Viagem {
	
	private static int prox_ID = 2000;
	
	private String id;
	private Date data;
	private Linha linha;
	
	//Construtor
	public Viagem(Date data, Linha linha) {
		this.id = String.valueOf(Viagem.prox_ID);
		this.data = data;
		this.linha = linha;
		
		//  Incremento do id da Viagem
		prox_ID ++;
	}
    
	//Métodos gets e sets
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}
	   
}
