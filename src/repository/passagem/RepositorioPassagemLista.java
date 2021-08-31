package repository.passagem;

import java.util.ArrayList;
import java.util.List;

import model.embarcacao.Embarcacao;
import model.empresa.Empresa;
import model.passagem.Passagem;
import model.viagem.Viagem;
import repository.empresa.EmpresaJaCadastradaException;
import repository.empresa.EmpresaNaoCadastradaException;

public class RepositorioPassagemLista implements RepositorioPassagem{
	
	List <Passagem> passagens;

    public RepositorioPassagemLista(){
        passagens = new ArrayList<>();
    }
	@Override
	public Passagem criarPassagem(Passagem passagem) {
		try{
            buscarPassagem(passagem.getID());
            buscarPassagemRG(passagem.getRG());
        }catch (PassagemNaoCadastradaException ex){
            passagens.add(passagem);
        }
		return passagem;
		
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
	@Override
	public List<Passagem> getAll() {
		return new ArrayList<>(passagens);
	}
	@Override
	public Passagem buscarPassagemRG(String RG) throws PassagemNaoCadastradaException {
		for(Passagem passagem : passagens){
            if(passagem.getRG().equals(RG)){
                return passagem;
            }
        }
        throw new PassagemNaoCadastradaException();
	}
	@Override
	public List<Passagem> getAllPassageiro(String RG) {
		List<Passagem> lista = new ArrayList<>();
        for (Passagem passagem : passagens) {
            if (passagem.getRG().equals(RG)) {
                lista.add(passagem);
            }
        }
        return lista;
		
	}
	
}
    
