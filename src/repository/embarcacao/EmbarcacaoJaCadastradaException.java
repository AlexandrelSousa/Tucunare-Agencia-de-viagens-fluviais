package repository.embarcacao;

public class EmbarcacaoJaCadastradaException extends Exception {
    
    public EmbarcacaoJaCadastradaException(){
        super("Embarcacao ja cadastrada");
    }

}
