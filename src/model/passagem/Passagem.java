package model.passagem;
import model.viagem.Viagem;

public class Passagem {

    //Atributos
    private int ID=0;
    private String RG;
    private String nome;
    private Viagem viagem;
    
    //Construtor
    public Passagem(int ID, String RG, String nome, Viagem viagem){
        this.ID = ID;
        this.RG = RG;
        this.nome = nome;
        this.viagem = viagem;
    }
    //Gets e Sets
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getRG(){
        return RG;
    }
    public void setRG(String RG){
        this.RG = RG;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

}
