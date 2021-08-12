package repository.passagem;

import java.util.ArrayList;
import java.util.List;

import model.empresa.Empresa;
import model.passagem.Passagem;
import repository.empresa.EmpresaJaCadastradaException;
import repository.empresa.EmpresaNaoCadastradaException;

public class RepositorioPassagemLista implements RepositorioPassagem{
	
	List <Passagem> passagens;

    RepositorioPassagemLista(){
        passagens = new ArrayList<>();
    }
	@Override
	public void criarPassagem(Passagem passagem) throws PassagemJaCadastradaException {
		try{
            buscarPassagem(passagem.getID());
            throw new PassagemJaCadastradaException();
        }catch (PassagemNaoCadastradaException ex){
            passagens.add(passagem);
        }
		
	}

	@Override
	public void alterarPassagem(Passagem passagem) throws PassagemNaoCadastradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleterPassagem(Passagem passagem) throws PassagemNaoCadastradaException {
		 if (! passagens.remove(passagem)) {
	            throw new PassagemNaoCadastradaException();
	        }
		
	}

	@Override
	public Passagem buscarPassagem(int ID) throws PassagemNaoCadastradaException {
		for(Passagem passagem : passagens){
            if(passagem.getID() == ID){
                return passagem;
            }
        }
        throw new PassagemNaoCadastradaException();
	}

	@Override
	public List<Passagem> getAll() {
		return new ArrayList<>(passagens);
	}
	
	

}
