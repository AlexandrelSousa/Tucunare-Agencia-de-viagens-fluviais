package controler;

import repository.embarcacao.EmbarcacaoJaCadastradaException;
import repository.embarcacao.EmbarcacaoNaoCadastradaException;
import repository.embarcacao.RepositorioEmbarcacao;
import repository.empresa.EmpresaJaCadastradaException;
import repository.empresa.EmpresaNaoCadastradaException;
import repository.empresa.RepositorioEmpresa;
import repository.linha.RepositorioLinha;
import repository.passagem.RepositorioPassagem;
import repository.viagem.RepositorioViagem;
import repository.embarcacao.RepositorioEmbarcacaoLista;
import repository.empresa.RepositorioEmpresaLista;
import repository.linha.RepositorioLinhaLista;
import repository.passagem.RepositorioPassagemLista;
import repository.viagem.RepositorioViagemLista;
import java.util.List;

import model.embarcacao.Embarcacao;
import model.empresa.Empresa;

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
        
        public void exit() {
            // Não faz nada
        }
}
