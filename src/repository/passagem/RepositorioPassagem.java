package repository.passagem;

import java.util.List;

import model.passagem.Passagem;
import model.viagem.Viagem;

public interface RepositorioPassagem {
	
	Passagem criarPassagem(Passagem passagem) throws PassagemJaCadastradaException;
	
	void alterarPassagem(Passagem passagem) throws PassagemNaoCadastradaException;
	
	void deleterPassagem(Passagem passagem) throws PassagemNaoCadastradaException;
	
	Passagem buscarPassagem(String ID) throws PassagemNaoCadastradaException;
	
	Passagem buscarPassagemRG(String RG) throws PassagemNaoCadastradaException;
	
	List<Passagem> getAll(String id);
	
	List<Passagem> getAll();
	
	List<Passagem> getAllPassageiro(String RG);
    
}
