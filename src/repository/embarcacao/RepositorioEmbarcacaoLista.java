package repository.embarcacao;

import model.embarcacao.Embarcacao;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEmbarcacaoLista implements RepositorioEmbarcacao {
    
    List <Embarcacao> embarcacoes;

    RepositorioEmbarcacaoLista(){
        embarcacoes = new ArrayList<>();
    }

    @Override
    public void inserirEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoJaCadastradaException{
        try{
            buscarEmbarcacao(embarcacao.getId());
            throw new EmbarcacaoJaCadastradaException();
        }catch (EmbarcacaoNaoCadastradaException ex){
            embarcacoes.add(embarcacao);
        }
    }

    @Override
    public void alterarEmbarcacao(Embarcacao embarcacao) {
        // Em memória, não há necessidade de atualizar objeto
    }
    
    @Override
    public void deletarEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoNaoCadastradaException {
        if (! embarcacoes.remove(embarcacao)) {
            throw new EmbarcacaoNaoCadastradaException();
        }
    }
    

    @Override
    public Embarcacao buscarEmbarcacao(int ID) throws EmbarcacaoNaoCadastradaException{
        for(Embarcacao embarcacao : embarcacoes){
            if(embarcacao.getId() == ID){
                return embarcacao;
            }
        }
        throw new EmbarcacaoNaoCadastradaException();
    }

    @Override
    public List<Embarcacao> getAll() {
        return new ArrayList<>(embarcacoes);
    }

}
