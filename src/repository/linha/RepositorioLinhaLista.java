package repository.linha;

import model.linha.Linha;
import java.util.ArrayList;
import java.util.List;

public class RepositorioLinhaLista implements RepositorioLinha {
    
    List <Linha> linhas;

    public RepositorioLinhaLista(){
        linhas = new ArrayList<>();
    }

    @Override
    public Linha inserirLinha(Linha linha) throws LinhaJaCadastradaException{
        try{
            buscarLinha(linha.getID());
            throw new LinhaJaCadastradaException();
        }catch (LinhaNaoCadastradaException ex){
            linhas.add(linha);
        }
		return linha;
    }

    @Override
    public void alterarLinha(Linha linha) {
        // Em memória, não há necessidade de atualizar objeto
    }
    
    @Override
    public void deletarLinha(Linha linha) throws LinhaNaoCadastradaException {
        if (! linhas.remove(linha)) {
            throw new LinhaNaoCadastradaException();
        }
    }
    

    @Override
    public Linha buscarLinha(String ID) throws LinhaNaoCadastradaException{
        for(Linha linha : linhas){
            if(linha.getID().equals(ID)){
                return linha;
            }
        }
        throw new LinhaNaoCadastradaException();
    }

    @Override
    public List<Linha> getAll() {
        return new ArrayList<>(linhas);
    }

}
