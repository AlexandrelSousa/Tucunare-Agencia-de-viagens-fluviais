package repository.viagem;

import java.util.List;

import model.viagem.Viagem;

public interface RepositorioViagem {
	
	void inserirViagem(Viagem viagem) throws ViagemJaCadastradaException;
	
	void alterarViagem(Viagem viagem) throws ViagemNaoCadastradaException;
	
	void deletarViagem(Viagem viagem) throws ViagemNaoCadastradaException;
	
	Viagem buscarViagem(int Id) throws ViagemNaoCadastradaException;
	
	List<Viagem> getAll();    
}
