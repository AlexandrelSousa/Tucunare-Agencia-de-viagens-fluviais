package repository.linha;

import model.linha.Linha;
import java.util.List;

public interface RepositorioLinha {
    
    void inserirLinha(Linha linha) throws LinhaJaCadastradaException;

    void alterarLinha(Linha linha) throws LinhaNaoCadastradaException;

    void deletarLinha(Linha linha) throws LinhaNaoCadastradaException;

    Linha buscarLinha(int ID) throws LinhaNaoCadastradaException;

    List <Linha> getAll();  

}
