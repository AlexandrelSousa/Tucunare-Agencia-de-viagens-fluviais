package model.linha;
import model.embarcacao.Embarcacao;

public class Linha {
    
    private int ID = 0;
    private String nome;
    private String origem;
    private String destino;
    private double valorPassagem;
    private Embarcacao embarcacao;

    //Construtor
    public Linha(int ID, String nome, String origem, String destino, double valorPassagem, Embarcacao embarcacao){
        this.ID = ID;
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.valorPassagem = valorPassagem;
        this.embarcacao = embarcacao;
    }

    //Métodos gets e sets
    public int getID(){
        return ID;
    }
    public void setID(int ID){
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

}
