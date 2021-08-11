package model.viagem;

import java.util.*;
import model.linha.Linha;

public class Viagem {
	
	private int id;
	private Date data;
	private Linha linha;
	
	//Construtor
	public Viagem(int id, Date data, Linha linha) {
		this.id = id;
		this.data = data;
		this.linha = linha;
	}
    
	//Métodos gets e sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
