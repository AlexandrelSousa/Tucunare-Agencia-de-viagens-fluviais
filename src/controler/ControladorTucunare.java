package controler;

import repository.embarcacao.RepositorioEmbarcacao;
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
        public void exit() {
            // Não faz nada
        }
}
