package repository.linha;

import model.linha.Linha;
import java.util.List;

public interface RepositorioLinha {
    
    Linha inserirLinha(Linha linha) throws LinhaJaCadastradaException;

    void alterarLinha(Linha linha) throws LinhaNaoCadastradaException;

    void deletarLinha(Linha linha) throws LinhaNaoCadastradaException;

    Linha buscarLinha(String ID) throws LinhaNaoCadastradaException;

    List <Linha> getAll();  

}
