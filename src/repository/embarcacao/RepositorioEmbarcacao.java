package repository.embarcacao;

import model.embarcacao.Embarcacao;
import java.util.List;

public interface RepositorioEmbarcacao {
    
    Embarcacao inserirEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoJaCadastradaException;

    void alterarEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoNaoCadastradaException;

    void deletarEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoNaoCadastradaException;

    Embarcacao buscarEmbarcacao(String ID) throws EmbarcacaoNaoCadastradaException;

    List <Embarcacao> getAll(); 
    List <Embarcacao> getAll(String cnpj);
}
