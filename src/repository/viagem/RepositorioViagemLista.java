package repository.viagem;

import java.util.ArrayList;
import java.util.List;

import model.passagem.Passagem;
import model.viagem.Viagem;
import repository.passagem.PassagemNaoCadastradaException;

public class RepositorioViagemLista implements RepositorioViagem {
	
	List <Viagem> viagens;

    public RepositorioViagemLista(){
        viagens = new ArrayList<>();
    }

	@Override
	public Viagem inserirViagem(Viagem viagem) throws ViagemJaCadastradaException {
		try{
            buscarViagem(viagem.getId());
            throw new ViagemJaCadastradaException();
        }catch (ViagemNaoCadastradaException ex){
            viagens.add(viagem);
        }
		return viagem;
		
	}

	@Override
	public void alterarViagem(Viagem viagem) throws ViagemNaoCadastradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarViagem(Viagem viagem) throws ViagemNaoCadastradaException {
		 if (! viagens.remove(viagem)) {
	            throw new ViagemNaoCadastradaException();
	        }
		
	}

	@Override
	public Viagem buscarViagem(String Id) throws ViagemNaoCadastradaException {
		for(Viagem viagem : viagens){
            if(viagem.getId().equals(Id)){
                return viagem;
            }
        }
        throw new 	ViagemNaoCadastradaException();
	}

	@Override
	public List<Viagem> getAll() {
		return new ArrayList<>(viagens);
	}

}
