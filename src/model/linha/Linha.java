package model.linha;
import model.embarcacao.Embarcacao;

public class Linha {
    
	private static int prox_ID= 1000;
	
    private String ID;
    private String nome;
    private String origem;
    private String destino;
    private double valorPassagem;
    private Embarcacao embarcacao;

    //Construtor
    public Linha(String nome, String origem, String destino, double valorPassagem, Embarcacao embarcacao){
        this.ID = String.valueOf(Linha.prox_ID);
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.valorPassagem = valorPassagem;
        this.setEmbarcacao(embarcacao);
        
        // Incremento do id da Linha
        prox_ID ++;
        
    }

    //Métodos gets e sets
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getOrigem(){
        return origem;
    }
    public void setOrigem(String origem){
        this.origem = origem;
    }
    public String getDestino(){
        return destino;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public double getValorPassagem(){
        return valorPassagem;
    }
    public void setValorPassagem(double valorPassagem){
        this.valorPassagem = valorPassagem;
    }

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}
    
}
