package model.passagem;
import model.viagem.Viagem;

public class Passagem {

    //Atributos
	
	private static int prox_ID= 1;
	
    private String ID;
    private String RG;
    private String nome;
    private Viagem viagem;
    
    //Construtor
    public Passagem(String RG, String nome, Viagem viagem){
        this.ID = String.valueOf(Passagem.prox_ID);
        this.RG = RG;
        this.nome = nome;
        this.setViagem(viagem);
        
        // Incremento do id da Passagem
        prox_ID ++; 
    }
    //Gets e Sets
    public String getID(){
        return ID;
    }
    public void setID(String ID){
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
	public Viagem getViagem() {
		return viagem;
	}
	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

}
