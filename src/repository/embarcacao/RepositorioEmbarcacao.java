package repository.embarcacao;

import model.embarcacao.Embarcacao;
import java.util.List;

public interface RepositorioEmbarcacao {
    
    void inserirEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoJaCadastradaException;

    void alterarEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoNaoCadastradaException;

    void deletarEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoNaoCadastradaException;

    Embarcacao buscarEmbarcacao(int ID) throws EmbarcacaoNaoCadastradaException;

    List <Embarcacao> getAll(); 
}
