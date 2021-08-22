package controler;

import repository.embarcacao.EmbarcacaoJaCadastradaException;
import repository.embarcacao.EmbarcacaoNaoCadastradaException;
import repository.embarcacao.RepositorioEmbarcacao;
import repository.empresa.EmpresaJaCadastradaException;
import repository.empresa.EmpresaNaoCadastradaException;
import repository.empresa.RepositorioEmpresa;
import repository.linha.LinhaJaCadastradaException;
import repository.linha.LinhaNaoCadastradaException;
import repository.linha.RepositorioLinha;
import repository.passagem.PassagemJaCadastradaException;
import repository.passagem.PassagemNaoCadastradaException;
import repository.passagem.RepositorioPassagem;
import repository.viagem.RepositorioViagem;
import repository.embarcacao.RepositorioEmbarcacaoLista;
import repository.empresa.RepositorioEmpresaLista;
import repository.linha.RepositorioLinhaLista;
import repository.passagem.RepositorioPassagemLista;
import repository.viagem.RepositorioViagemLista;
import repository.viagem.ViagemJaCadastradaException;
import repository.viagem.ViagemNaoCadastradaException;

import java.util.List;

import model.embarcacao.Embarcacao;
import model.empresa.Empresa;
import model.linha.Linha;
import model.passagem.Passagem;
import model.viagem.Viagem;

public class ControladorTucunare {
        private RepositorioEmbarcacao repositorioEmbarcacao;
        private RepositorioEmpresa repositorioEmpresa;
        private RepositorioLinha repositorioLinha;
        private RepositorioPassagem repositorioPassagem;
        private RepositorioViagem repositorioViagem;

        public ControladorTucunare() {
            repositorioEmbarcacao = new RepositorioEmbarcacaoLista();
            repositorioEmpresa = new RepositorioEmpresaLista();
            repositorioLinha = new RepositorioLinhaLista();
            repositorioPassagem = new RepositorioPassagemLista();
            repositorioViagem = new RepositorioViagemLista();
        }
        
        //                     E M B A R C A Ç Ã O
        public Embarcacao inserirEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoJaCadastradaException {
            return repositorioEmbarcacao.inserirEmbarcacao(embarcacao);
        }
        
        public void alterarEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoNaoCadastradaException {
        	repositorioEmbarcacao.alterarEmbarcacao(embarcacao);
        }
        
        public Embarcacao buscarEmbarcacao(String ID) throws EmbarcacaoNaoCadastradaException{
        	return repositorioEmbarcacao.buscarEmbarcacao(ID);
        }
        
        public void deletarEmbarcacao(Embarcacao embarcacao) throws EmbarcacaoNaoCadastradaException {
        	repositorioEmbarcacao.deletarEmbarcacao(embarcacao);
        	
        }
        
        public List<Embarcacao> getAllEmbarcacao() {
        	return repositorioEmbarcacao.getAll();
        	
        }
        
        public List<Embarcacao> getAll(String cnpj) {
        	return repositorioEmbarcacao.getAll(cnpj);
        }
        
        //                     E M P R E S A

        public void inserirEmpresa(Empresa empresa) throws EmpresaJaCadastradaException {
            repositorioEmpresa.inserirEmpresa(empresa);
        }
        
        public void AlterarEmpresa(Empresa empresa) throws EmpresaNaoCadastradaException {
        	repositorioEmpresa.alterarEmpresa(empresa);
        }
        
        public Empresa buscarEmpresa(String cnpj) throws EmpresaNaoCadastradaException {
        	return repositorioEmpresa.buscarEmpresa(cnpj);
        }
        
        public void deletarEmpresa(Empresa empresa) throws EmpresaNaoCadastradaException {
        	repositorioEmpresa.deletarEmpresa(empresa);
        	
        }
        
        public List<Empresa> getAllEmpresa() {
        	return repositorioEmpresa.getAll();
        	
        }
        
        //                     V I A G E M
        
        public void inserirViagem(Viagem viagem) throws ViagemJaCadastradaException {
        	repositorioViagem.inserirViagem(viagem);
        }
        
        public void alterarViagem(Viagem viagem) throws ViagemNaoCadastradaException {
        	repositorioViagem.alterarViagem(viagem);
        }
        
        public void deletarViagem(Viagem viagem) throws ViagemNaoCadastradaException {
        	repositorioViagem.deletarViagem(viagem);
        }
        
        public Viagem buscarViagem(String id) throws ViagemNaoCadastradaException {
        	return repositorioViagem.buscarViagem(id);
        }
        
        public List<Viagem> getAllViagem() {
        	return repositorioViagem.getAll();
        }
        
        
        //                    L I N H A
        
        public Linha inserirLinha(Linha linha) throws LinhaJaCadastradaException{
        	return repositorioLinha.inserirLinha(linha);
        }
        
        public void alterarLinha(Linha linha) throws LinhaNaoCadastradaException {
        	repositorioLinha.alterarLinha(linha);
        }
        
        public void deletarLinha(Linha linha) throws LinhaNaoCadastradaException {
        	repositorioLinha.deletarLinha(linha);
        }
        
        public Linha buscarLinha(String id) throws LinhaNaoCadastradaException{
        	return repositorioLinha.buscarLinha(id);
        }
        
        public List<Linha> getAllLinha() {
        	return repositorioLinha.getAll();
        }
        
        //                   P A S S A G E M
        
        public void criarPassagem(Passagem passagem) throws PassagemJaCadastradaException, ControladorException {
        	List<Passagem> numeroPassagem = this.getAllPassagem(passagem.getID());
        	int i = 0;
        	for (Passagem passagem2 : numeroPassagem) {
				i++;
			}
        	if (i <= passagem.getViagem().getLinha().getEmbarcacao().getLotacao()) {
        		repositorioPassagem.criarPassagem(passagem);
        	}else {
        		throw new ControladorException("Passagem não criada por ultrapassar a lotação do barco");
        	}
        }
        
        public void alterarPassagem(Passagem passagem) throws PassagemNaoCadastradaException {
        	repositorioPassagem.alterarPassagem(passagem);
        }
        
        public void deleterPassagem(Passagem passagem) throws PassagemNaoCadastradaException {
        	repositorioPassagem.deleterPassagem(passagem);
        }
        
        public Passagem buscarPassagem(String id) throws PassagemNaoCadastradaException {
        	return repositorioPassagem.buscarPassagem(id);
        }
        
        public List<Passagem> getAllPassagem(String id) {
        	return repositorioPassagem.getAll(id);
        }
        
        public void exit() {
            // Não faz nada
        }
}
