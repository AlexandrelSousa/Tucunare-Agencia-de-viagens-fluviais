package repository.viagem;

import java.util.List;

import model.viagem.Viagem;

public interface RepositorioViagem {
	
	Viagem inserirViagem(Viagem viagem) throws ViagemJaCadastradaException;
	
	void alterarViagem(Viagem viagem) throws ViagemNaoCadastradaException;
	
	void deletarViagem(Viagem viagem) throws ViagemNaoCadastradaException;
	
	Viagem buscarViagem(String Id) throws ViagemNaoCadastradaException;
	
	List<Viagem> getAll();
    
}
