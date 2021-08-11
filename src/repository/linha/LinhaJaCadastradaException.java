package repository.linha;

public class LinhaJaCadastradaException extends Exception{
    
    public LinhaJaCadastradaException(){
        super("Linha já cadastrada!");
    }

}
