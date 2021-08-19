package repository.passagem;

import java.util.List;

import model.passagem.Passagem;

public interface RepositorioPassagem {
	
	void criarPassagem(Passagem passagem) throws PassagemJaCadastradaException;
	
	void alterarPassagem(Passagem passagem) throws PassagemNaoCadastradaException;
	
	void deleterPassagem(Passagem passagem) throws PassagemNaoCadastradaException;
	
	Passagem buscarPassagem(int ID) throws PassagemNaoCadastradaException;
	
	List<Passagem> getAll(int id);
    
}
