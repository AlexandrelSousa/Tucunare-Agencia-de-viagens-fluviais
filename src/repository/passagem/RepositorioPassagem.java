package repository.passagem;

import java.util.List;

import model.passagem.Passagem;

public interface RepositorioPassagem {
	
	void criarPassagem(Passagem passagem) throws PassagemJaCadastradaException;
	
	void alterarPassagem(Passagem passagem) throws PassagemNaoCadastradaException;
	
	void deleterPassagem(Passagem passagem) throws PassagemNaoCadastradaException;
	
	Passagem buscarPassagem(String ID) throws PassagemNaoCadastradaException;
	
	List<Passagem> getAll(String id);
    
}
