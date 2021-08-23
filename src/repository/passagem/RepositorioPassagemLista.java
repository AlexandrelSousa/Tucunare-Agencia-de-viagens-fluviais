package repository.passagem;

import java.util.ArrayList;
import java.util.List;

import model.empresa.Empresa;
import model.passagem.Passagem;
import repository.empresa.EmpresaJaCadastradaException;
import repository.empresa.EmpresaNaoCadastradaException;

public class RepositorioPassagemLista implements RepositorioPassagem{
	
	List <Passagem> passagens;

    public RepositorioPassagemLista(){
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
	public Passagem buscarPassagem(String ID) throws PassagemNaoCadastradaException {
		for(Passagem passagem : passagens){
            if(passagem.getID().equals(ID)){
                return passagem;
            }
        }
        throw new PassagemNaoCadastradaException();
	}
	@Override
	public List<Passagem> getAll(String id) {
		List<Passagem> lista = new ArrayList<>();
        for (Passagem passagem : passagens) {
            if (passagem.getViagem().getId().equals(id)) {
                lista.add(passagem);
            }
        }
        return lista;
	}
    
	
	

}
