package main;

import controler.ControladorTucunare;
import model.embarcacao.Embarcacao;
import model.empresa.Empresa;
import model.linha.Linha;
import model.passagem.Passagem;
import model.viagem.Viagem;
import repository.embarcacao.EmbarcacaoJaCadastradaException;
import repository.embarcacao.EmbarcacaoNaoCadastradaException;
import repository.empresa.EmpresaJaCadastradaException;
import repository.empresa.EmpresaNaoCadastradaException;
import repository.linha.LinhaJaCadastradaException;
import repository.viagem.ViagemJaCadastradaException;
import repository.viagem.ViagemNaoCadastradaException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AgenciaTucunare{

    static ControladorTucunare controlador;
    static Scanner scanner = new Scanner(System.in);

    //                     !! Menu principal / homepage  !!
    public static void main (String[] args) throws Exception{
    	
    	controlador = new ControladorTucunare();
    	
    	insereDadosTeste();
    	
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("==================================================");
        	System.out.println("==             AGÊNCIA TUCUNARÉ                 ==        ");
            System.out.println("==================================================");
            System.out.println("  1. EMPRESAS                    =================");
            System.out.println("  2. EMBACAÇÕES                ===================");
            System.out.println("  3. VIAGENS                      ================");
            System.out.println("  4. LINHAS                        ===============");
            System.out.println("  5. PASSAGEM                    =================");
            System.out.println("  0. SAIR                            =============");
            System.out.println("                               ===================");
            System.out.println("==================================================");
            System.out.print("Escolha uma opção: ");
            //Lendo e interpretando a opção fornecida
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }
            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    menuEmpresas();
                    break;
                case 2:
                    menuEmbarcacoes();
                    break;
                case 3:
                    menuViagens();
                    break;
                case 4:
                    menuLinhas();
                    break;
                case 5:
                    menuPassagem();
                    break;
            }
        } while (opcao != 0);

        controlador.exit();
        System.out.println("Programa terminado");

    }
    
    private static void insereDadosTeste() {
    	try {
    		// cria empresas
            Empresa empresa01 = new Empresa("1", "Jarlison Neves");
            controlador.inserirEmpresa(empresa01);
            Empresa empresa02 = new Empresa("2", "Alexandre");
            controlador.inserirEmpresa(empresa02);
            
            //cria embarcações
            Embarcacao e1 = new Embarcacao("Golfinho do Mar",2, empresa01);
            controlador.inserirEmbarcacao(e1);
            Embarcacao e2 = new Embarcacao("Barcarena",10, empresa02);
            controlador.inserirEmbarcacao(e2);
            Embarcacao e3 = new Embarcacao("Bajara", 6, empresa01);
            controlador.inserirEmbarcacao(e3);
            
            //cria linha
            Linha l1 =  new Linha("Santarém/Manaus", "Santarém","Manaus", 150.00, e1);
            controlador.inserirLinha(l1);
            Linha l2 =  new Linha("Santarém/Belém", "Santarém","Belém", 170.00, e2);
            controlador.inserirLinha(l2);
            Linha l3 =  new Linha("Santarém/Óbidos", "Santarém","Óbidos", 120.00, e3);
            controlador.inserirLinha(l3);
            
            //cria Viagem
            Date data = new Date();
            Viagem v1 =  new Viagem(data, l1);
            controlador.inserirViagem(v1);
            Viagem v2 =  new Viagem(data, l2);
            controlador.inserirViagem(v2);
            Viagem v3 =  new Viagem(data, l3);
            controlador.inserirViagem(v3);
            
            //cria Passagem
            Passagem p1 = new Passagem("1234","Enoque Calvino",v1);
            controlador.criarPassagem(p1);
            Passagem p2 = new Passagem("5678","Rodrigo Alves",v1);
            controlador.criarPassagem(p2);
            Passagem p3 = new Passagem("9102","Barcus Bentes",v2);
            controlador.criarPassagem(p3);

        } catch (Exception ex) {
        
		}

		
	}

	private static void limpaTela(){
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    //              M E N U   E M P R E S A S

    private static void menuEmpresas(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("===================================================");
            System.out.println("==                  EMPRESAS                     ==");
            System.out.println("===================================================");
            System.out.println("                                    ===============");
            System.out.println("  1. CADASTRAR UMA NOVA EMPRESA          ==========");
            System.out.println("  2. EXCLUIR UMA EMPRESA            ===============");
            System.out.println("  3. ALTERAR UMA EMPRESA          =================");
            System.out.println("  4. LISTAR EMPRESAS         ======================");
            System.out.println("  5. BUSCAR EMPRESA              ==================");
            System.out.println("  0. MENU PRINCIPAL              ==================");
            System.out.println("                                ===================");
            System.out.println("===================================================");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }
            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    criarEmpresa();
                    break;
                case 2:
                    excluirEmpresa();
                    break;
                case 3:
                    alterarEmpresa();
                    break;
                case 4:
                    listarEmpresas();
                    break;
                case 5:
                    buscarEmpresa();
                    break;
            }
        }while(opcao != 0);

    }
    private static void criarEmpresa(){
        limpaTela();      
        System.out.println("==============================================================");
        System.out.println("==              CADASTRAR UMA NOVA EMPRESA                  ==");
        System.out.println("==============================================================");
        
        try{
            System.out.println("  1. QUAL O CNPJ DA EMPRESA?                     =============");
            System.out.print("     CNPJ: ");
            String cnpj = scanner.nextLine();
            System.out.println("Qual o nome da empresa?");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("==============================================================");
            Empresa empresa = new Empresa(cnpj, nome);
            if(empresa.getNome() == "") {
            	System.out.println("Empresa com nome em branco não pode ser cadastrada!");
            } else {
            	controlador.inserirEmpresa(empresa);
                System.out.println("Cadastro feito com sucesso!");
            }
           
        }catch(EmpresaJaCadastradaException ex ){
            System.err.println(ex.getMessage());
        }
        System.out.println("\ntecle <enter> para voltar");
        scanner.nextLine();
        System.out.println("                               ===================");
        System.out.println("=================================================="); 
    }
    private static void excluirEmpresa(){
        limpaTela();
        System.out.println("===============================================");
        System.out.println("==             EXCLUIR EMPRESA               ==");
        System.out.println("===============================================");
        System.out.println("1. Qual o CNPJ da empresa?       ==============");
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        try {
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println();
            System.out.println("Empresa: " + empresa.getNome() + "           =============");
            System.out.println("CNPJ: " + empresa.getCnpj() + "                           =============");
            System.out.println();

            System.out.println("Exclui essa empresa? (s/n)?       =============");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                controlador.deletarEmpresa(empresa);
                System.out.println("Empresa excluida!");
            }
            else {
            	System.out.println("Empresa não excluída!");
            }
        } catch (EmpresaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("                            ===================");
        System.out.println("tecle <enter> para voltar   ===================");
        System.out.println("                            ===================");
        System.out.println("===============================================");
        scanner.nextLine();
    }
    private static void alterarEmpresa(){
        limpaTela();
        System.out.println("===============================================");
        System.out.println("==               ALTERAR NOME                ==");
        System.out.println("===============================================");
        System.out.println("1. Qual o CNPJ da empresa?      ===============");
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        try {
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println();
            System.out.println("Empresa: " + empresa.getNome() + "     ===================");
            System.out.println("CNPJ: " + empresa.getCnpj() + "                     ===================");
            System.out.println();

            System.out.println("Qual o novo nome da empresa? ===================");
            System.out.print("Nome (<enter> = Não alterar): ");
            String nome = scanner.nextLine();
            empresa.setNome(nome);
            if (!nome.equals("")) {
                empresa.setNome(nome);
            }
            controlador.AlterarEmpresa(empresa);
            System.out.println("Nome atualizado!");

        } catch (EmpresaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("                            ===================");
        System.out.println("tecle <enter> para voltar   ===================");
        System.out.println("                            ===================");
        System.out.println("===============================================");
        scanner.nextLine();
    }
    private static void listarEmpresas(){
        limpaTela();
        List<Empresa> empresas = controlador.getAllEmpresa();
        System.out.println("==================================================");
        System.out.println("==               LISTAR EMPRESAS                ==");
        System.out.println("==================================================");
        System.out.println("EMPRESA           CNPJ                       =====");
        System.out.println("================= =================          =====");
        for (Empresa empresa : empresas){
            System.out.printf("%-17s ", empresa.getNome());
            System.out.printf("%-14s ", empresa.getCnpj());
            System.out.println("");
        }
        
        System.out.println("                                             =====");
        System.out.println("tecle <enter> para voltar                    =====");
        System.out.println("                                             =====");
        System.out.println("==================================================");
        scanner.nextLine();
    }
    private static void buscarEmpresa(){
        limpaTela();
        List<Embarcacao> embarcacoes;
        System.out.println("==============================================");
        System.out.println("==              BUSCAR EMPRESA              ==");
        System.out.println("==============================================");
        System.out.println("                                         =====");
        System.out.println("Qual o CNPJ da empresa?                 ======");
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        
        try{
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println("                                         =====");
            System.out.println("EMPRESA           CNPJ EMBARCAÇÕES       =====");
            System.out.println("================= ==== =======================");
            System.out.printf("%-17s ", empresa.getNome());
            System.out.printf("%-4s ", empresa.getCnpj());
            embarcacoes = controlador.getAll(empresa.getCnpj());
            for(Embarcacao embarcacao : embarcacoes){
            	System.out.printf("%-37s ", embarcacao.getNome() + "\n");
            	System.out.print(" ");
            	
            }
            if (embarcacoes.isEmpty()) {
            	System.out.println("Não Possui Embarcação");
            }
        }catch(EmpresaNaoCadastradaException ex){
            System.err.println(ex.getMessage());
        }
        System.out.println("");
        System.out.println("tecle <enter> para voltar                =====");
        System.out.println("                                         =====");
        System.out.println("==============================================");
        scanner.nextLine();
    }

    //                  M E N U   E M B A R C A Ç Õ E S

    private static void menuEmbarcacoes(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("==================================================");
            System.out.println("==                EMBARCAÇÕES                   ==  ");
            System.out.println("==================================================");
            System.out.println("                               ===================");
            System.out.println("  1. CRIAR UMA NOVA EMBARCAÇÃO     ===============  ");
            System.out.println("  2. EXCLUIR UMA EMBARCAÇÃO            ===========  ");
            System.out.println("  3. ALTERAR UMA EMBARCAÇÃO           ============  ");
            System.out.println("  4. LISTAR EMBARCAÇÕES                   ========  ");
            System.out.println("  5. BUSCAR EMBARCAÇÃO              ==============  ");
            System.out.println("  0. MENU PRINCIPAL                    ===========");
            System.out.println("                               ===================");
            System.out.println("==================================================");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }
            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    criarEmbarcacao();
                    break;
                case 2:
                    excluirEmbarcacao();
                    break;
                case 3:
                    alterarEmbarcacao();
                    break;
                case 4:
                    listarEmbarcacoes();
                    break;
                case 5:
                    buscarEmbarcacao();
                    break;
            }
        }while(opcao != 0);
    }
    
    private static void criarEmbarcacao() {
    	limpaTela();
        System.out.println("==============================================================");
    	System.out.println("==            CADASTRAR UMA NOVA EMBARCAÇÃO                 ==  ");
    	System.out.println("==============================================================");
        
        try {
            System.out.print("CNPJ da Empresa a qual a embarcação irá pertencer:       ");
            String cnpj = scanner.nextLine();
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println("                                                      ========  ");
            
            System.out.print("Nome da Embarcação:   ");
            String nome = scanner.nextLine();
            System.out.print("Lotação da Embarcação:    ");
            int lotacao = scanner.nextInt();
			Embarcacao embarcacao = new Embarcacao(nome, lotacao, empresa);
			if(embarcacao.getNome() == "") {
            	System.out.println("Embarcação com nome em branco não pode ser cadastrada!");
            } else {
            	controlador.inserirEmbarcacao(embarcacao);
            	System.out.println("                                                ==============");
                System.out.println("Embarcacão " + embarcacao.getNome() + " Cadastrada! ");
                System.out.println("                                              ================");
            }
            	
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
      
        System.out.println("                                                ==============");
        System.out.println("tecle <enter> para voltar                            =========");
        System.out.println("==============================================================");
        scanner.nextLine();
        scanner.nextLine();
        

    } 
    
    private static void excluirEmbarcacao(){
    	limpaTela();
        System.out.println("===================================================");
        System.out.println("==             Excluir Embarcação                ==  ");
        System.out.println("===================================================");
        System.out.println();
        System.out.print("ID da Embarcação: ");
        String Id = scanner.nextLine();

        try {
            Embarcacao embarcacao = controlador.buscarEmbarcacao(Id);
            System.out.println();
            System.out.println("Id      nome                                     ==");
            System.out.println("======= ===========================================");
            System.out.printf("%-8s", embarcacao.getId());
            System.out.print(embarcacao.getNome());

            System.out.println("\nExcluir essa Embarcação? (s/n)?                  ==  ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
            	controlador.deletarEmbarcacao(embarcacao);
            	System.out.println("Embarcação excluída!                             ==   ");
            }else {
            	System.out.println("Embarcação não excluída!                         ==   ");
            }
            
        } catch (EmbarcacaoNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar                        ==");
        System.out.println("===================================================");
        scanner.nextLine();
    }
    private static void alterarEmbarcacao(){
    	
    	limpaTela();
        System.out.println("====================================================   ");
        System.out.println("==           Alterar Nome da Embarcação           ==   ");
        System.out.println("====================================================   ");
        System.out.print("ID: ");
        String id = scanner.nextLine();

        try {
            Embarcacao embarcacao = controlador.buscarEmbarcacao(id);

            System.out.println();
            System.out.println("Nome: " + embarcacao.getNome());
            System.out.print("Nome (<enter> = Não alterar): ");
            String nome = scanner.nextLine();
            if (!nome.equals("")) {
                embarcacao.setNome(nome);
            }
            
            System.out.println();

            controlador.alterarEmbarcacao(embarcacao);
            System.out.println("Nome da Embarcação Atualizado!                    ==   ");
            
        } catch (EmbarcacaoNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        } 
        System.out.println("                                               =====");
        System.out.println("tecle <enter> para voltar                         ==");
        System.out.println("====================================================");
        scanner.nextLine();

    }
    private static void listarEmbarcacoes(){
    	 limpaTela();
         System.out.println("====================================================");
         System.out.println("==              Lista de Embarcações              ==   ");
         System.out.println("====================================================");
         List<Embarcacao> embarcacoes = controlador.getAllEmbarcacao();
             System.out.printf("Id     Nome                Empresa                == \n");
             System.out.printf("====== ==================  =========================\n");
             for (Embarcacao embarcacao: embarcacoes) {
                 System.out.printf("%6s ", embarcacao.getId());
                 System.out.printf("%-19s ", embarcacao.getNome());
                 System.out.printf("%-11s \n", embarcacao.getProprietário().getNome());
        
             }
             System.out.println("====================================================");
             System.out.println("tecle <enter> para voltar                         ==");
             System.out.println("====================================================");
             scanner.nextLine();
    }

    private static void buscarEmbarcacao(){
    	limpaTela();
        System.out.println("====================================================");
        System.out.println("==             Consultar Embarcação               ==  ");
        System.out.println("====================================================");
        System.out.print("Id da Embarcação:    ");
        String id = scanner.nextLine();
        try {
        	System.out.println("Informações da Embarcação                         ==     ");
            System.out.println("====================================================");
            Embarcacao embarcacao = controlador.buscarEmbarcacao(id);
            System.out.println("Id     nome                   Lotação Empresa     ==   ");
            System.out.println("====== ====================== ======= ==============");
            System.out.printf("%-7s", embarcacao.getId());
            System.out.printf("%-23s",embarcacao.getNome());
            System.out.printf("%-8s", embarcacao.getLotacao());
            System.out.print(embarcacao.getProprietário().getNome());

        } catch (EmbarcacaoNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("\n                                                  ==");
        System.out.println("====================================================");
        System.out.println("tecle <enter> para voltar                         ==");
        System.out.println("====================================================");
        scanner.nextLine();

    }

    //                  M E N U   V I A G E N S
    
    private static void menuViagens(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("====================================================");
            System.out.println("==                   VIAGENS                      ==");
            System.out.println("====================================================");
            System.out.println("                                 ===================");
            System.out.println("  1. CADASTRAR UMA NOVA VIAGEM          ============");
            System.out.println("  2. CANCELAR UMA VIAGEM               =============");
            System.out.println("  3. ALTERAR UMA VIAGEM               ==============");
            System.out.println("  4. LISTAR VIAGENS                           ======");
            System.out.println("  5. BUSCAR VIAGEM                   ===============");
            System.out.println("  6. LISTAR PASSAGEIROS                     ========");
            System.out.println("  0. MENU PRINCIPAL                       ==========");
            System.out.println("                                 ===================");
            System.out.println("====================================================");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }
            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    cadastrarViagem();
                    break;
                case 2:
                    cancelarViagem();
                    break;
                case 3:
                    alterarViagem();
                    break;
                case 4:
                    listarViagens();
                    break;
                case 5:
                    buscarViagem();
                    break;
                case 6:
                    listarPassageiros();
                    break;
            }
        }while(opcao != 0);
    }

	private static void cadastrarViagem(){
    	limpaTela();
        System.out.println("====================================================");
    	System.out.println("==            CADASTRAR UMA NOVA VIAGEM           ==");
        System.out.println("====================================================");
        System.out.println("                                                  ==");
        try {
            System.out.print("ID da linha a qual a viagem irá acontecer: ");
            String id = scanner.nextLine();
            Linha linha = controlador.buscarLinha(id);
            
            Date data = new Date();
			Viagem viagem = new Viagem(data, linha);
        	controlador.inserirViagem(viagem);
        	System.out.println("                                                  ==");
            System.out.println("Viagem para " + viagem.getLinha().getNome() + " Cadastrada!");
            System.out.println("                                                  ==");	
            	
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
      
        System.out.println("====================================================");
        System.out.println("tecle <enter> para voltar                         ==");
        System.out.println("====================================================");
        scanner.nextLine();

    }
    private static void cancelarViagem(){
    	
    	limpaTela();
        System.out.println("====================================================");
        System.out.println("==              CANCELAR VIAGEM                   ==");
        System.out.println("====================================================");
        System.out.println("1. Qual o id da viagem?                           ==");
        System.out.print("id: ");
        String id = scanner.nextLine();

        try {
            Viagem viagem = controlador.buscarViagem(id);
            System.out.println("                                                  ==");
            System.out.println("Viagem                 Data");
            System.out.println("====================== =============================");
            System.out.printf("%-22s", viagem.getLinha().getNome());
            System.out.print(viagem.getData());
            System.out.println("                                                  ==");
            System.out.println("\nCancelar essa Viagem? (s/n)?                      ==");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                controlador.deletarViagem(viagem);
                System.out.println("Viagem Cancelada!                                 ==");
            }else {
            	System.out.println("Viagem Não Cancelada!                             ==");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("====================================================");
        System.out.println("tecle <enter> para voltar                         ==");
        System.out.println("====================================================");
        scanner.nextLine();
    }

    @SuppressWarnings("unlikely-arg-type")
	private static void alterarViagem(){
    	
    	limpaTela();
        System.out.println("====================================================");
        System.out.println("==                ALTERAR VIAGEM                  ==");
        System.out.println("====================================================");
        System.out.print("ID: ");
        String id = scanner.nextLine();

        try {
            Viagem viagem = controlador.buscarViagem(id);

            System.out.println();
            System.out.printf("%-50s", "Data: " + viagem.getData());
            System.out.print("==");
            System.out.println("\nData (<enter> = Não alterar): ");
            String dataNova = scanner.nextLine();
            DateFormat df = new SimpleDateFormat("dd,MM,YYYY");
            Date data = df.parse(dataNova);
            if (!data.equals("")) {
                viagem.setData(data);
            }
            
            
            System.out.println();
            controlador.alterarViagem(viagem);
            System.out.println("Viagem Atualizada!");
            System.out.println();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        
        System.out.println("====================================================");
        System.out.println("tecle <enter> para voltar                         ==");
        System.out.println("====================================================");
        scanner.nextLine();

    }
    
    private static void listarViagens(){
    	
    	limpaTela();
        System.out.println("========================================================");
        System.out.println("==                  LISTA DE VIAGENS                  ==");
        System.out.println("========================================================");
        
        List<Viagem> viagens = controlador.getAllViagem();
            System.out.printf("Id     Linha              Data        \n");
            System.out.printf("====== ================== ==============================\n");
            for (Viagem viagem: viagens) {
                System.out.printf("%6s ", viagem.getId());
                System.out.printf("%-18s ", viagem.getLinha().getNome());
                String formato = "dd/MM/yyyy"; 
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                String sdata = sdf.format(viagem.getData());
                System.out.printf("%10s \n", sdata);
       
            }
            System.out.println("========================================================");
            System.out.println("tecle <enter> para voltar                             ==");
            System.out.println("========================================================");
            scanner.nextLine();

    }
    
    private static void buscarViagem(){
    	limpaTela();
        System.out.println("=============================================================================================");
        System.out.println("==                                    CONSULTAR VIAGEM                                     ==");
        System.out.println("=============================================================================================");
        System.out.print("Id da Viagem: ");
        String id = scanner.nextLine();
        
        try {
            Viagem viagem = controlador.buscarViagem(id);
            System.out.println("=============================================================================================");
            System.out.println("Id    Linha             Embarcação      Empresa           Data    ");
            System.out.println("===== ================= =============== ================= ===================================");
            System.out.printf("%-6s", viagem.getId());
            System.out.printf("%-18s", viagem.getLinha().getNome());
            System.out.printf("%-16s", viagem.getLinha().getEmbarcacao().getNome());
            System.out.printf("%-18s", viagem.getLinha().getEmbarcacao().getProprietário().getNome());
            String formato = "dd/MM/yyyy"; 
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String sdata = sdf.format(viagem.getData());    
            System.out.printf("%-17s", sdata);

        } catch (ViagemNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("\n===== ================= =============== ================= ===================================");
        System.out.println("\n=============================================================================================");
        System.out.println("tecle <enter> para voltar                                                                  ==");
        System.out.println("=============================================================================================");
        scanner.nextLine();
    }
    
    private static void listarPassageiros() {
    	limpaTela();
    	try {
            System.out.println("========================================================");
            System.out.println("==         Listar passsageiros de uma viagem          ==");
            System.out.println("========================================================");
    		System.out.print("Id da Viagem: ");
            String id = scanner.nextLine();
            Viagem viagem = controlador.buscarViagem(id);
            limpaTela();

            System.out.println("========================================================");
            System.out.println("==               Lista de Passageiros                 ==");
            System.out.println("========================================================");
            
            List<Passagem> passagens = controlador.getAllPassagem(id);
            
            if (passagens.isEmpty()) {
            	System.out.println("A viagem Não Possui Passageiros ");
            } else {
            	System.out.printf("ID (Viagem) RG        Nome               \n");
                System.out.printf("=========== ========= ================================== \n");
                	for (Passagem passagem: passagens) {
                		System.out.printf("%8s    ", passagem.getViagem().getId());
                		System.out.printf("%-9s ", passagem.getRG());
                        System.out.printf(passagem.getNome() + "\n");
                    }
            	
            }

               
    	} catch ( Exception ex) {
    		System.err.println(ex.getMessage());
    		
        }
    	
    	System.out.println("========================================================");
        System.out.println("tecle <enter> para voltar                             ==");
        System.out.println("========================================================");
        scanner.nextLine();
	
	}

    //                  M E N U   L I N H A S

    private static void menuLinhas(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("========================================================");
            System.out.println("==                   MENU LINHAS                      ==");
            System.out.println("========================================================");
            System.out.println("                                                      ==");
            System.out.println("  1. CADASTRAR UMA NOVA LINHA             ==============");
            System.out.println("  2. EXCLUIR UMA LINHA               ===================");
            System.out.println("  3. ALTERAR UMA LINHA                 =================");
            System.out.println("  4. LISTAR LINHAS                 =====================");
            System.out.println("  5. BUSCAR LINHA                       ================");
            System.out.println("  0. MENU PRINCIPAL                  ===================");
            System.out.println("                                     ===================");
            System.out.println("========================================================");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }
            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    cadastrarLinha();
                    break;
                case 2:
                    excluirLinha();
                    break;
                case 3:
                    alterarLinha();
                    break;
                case 4:
                    listarLinhas();
                    break;
                case 5:
                    buscarLinha();
                    break;
            }
        }while(opcao != 0);
    }
    private static void cadastrarLinha(){
    	limpaTela();
        System.out.println("========================================================");
    	System.out.println("==            CADASTRAR UMA NOVA LINHA                ==");
        System.out.println("========================================================");
        
        try {
            System.out.print("ID da embarcação a qual a linha irá ser criada: ");
            String id = scanner.nextLine();
            Embarcacao embarcacao = controlador.buscarEmbarcacao(id);
            System.out.println();
            
            System.out.print("Nome da Linha: ");
            String nome = scanner.nextLine();
            System.out.print("Origem da Linha: ");
            String origem = scanner.nextLine();
            System.out.print("Destino da Linha: ");
            String destino = scanner.nextLine();
            System.out.print("Valor da Passagem: ");
            String valorPassagem = scanner.nextLine();
            double valorPassagem1 = Double.valueOf(valorPassagem).doubleValue();
            
			Linha linha = new Linha(nome,origem,destino,valorPassagem1,embarcacao);
        	controlador.inserirLinha(linha);
        	System.out.println("");
            System.out.println("Linha " + linha.getNome() + " Cadastrada!\n");
            	
            	
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("========================================================");
        System.out.println("tecle <enter> para voltar                             ==");
        System.out.println("========================================================");
        scanner.nextLine();

    }
    private static void excluirLinha(){
    	limpaTela();
        System.out.println("================================================================");
        System.out.println("==                       EXCLUIR LINHA                        ==");
        System.out.println("================================================================");
        System.out.println("1. Qual o id da LINHA?                                        ==");
        System.out.print("id: ");
        String id = scanner.nextLine();

        try {
            Linha linha = controlador.buscarLinha(id);
            System.out.println();
            System.out.println("ID    Nome                Origem     Destino     Embarcação    ");
            System.out.println("===== =================== ========== =========== ===============");
            System.out.printf("%-6s", linha.getID());
            System.out.printf("%-19s", linha.getNome());
            System.out.printf("%-10s", linha.getOrigem());
            System.out.printf("%-12s", linha.getDestino());
            System.out.print(linha.getEmbarcacao().getNome() + "\n");
            System.out.println("===== =================== ========== =========== ===============\n");

            System.out.println("Excluir essa Linha? (s/n)?                                    ==");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                controlador.deletarLinha(linha);
                System.out.println("Linha Excluída!                                               ==   ");
            }else {
            	System.out.println("Linha Não Excluída!                                           ==   ");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("================================================================");
        System.out.println("tecle <enter> para voltar                                     ==");
        System.out.println("================================================================");
        scanner.nextLine();

    }
    private static void alterarLinha(){
    	limpaTela();
        System.out.println("========================================================");
        System.out.println("==                 Alterar Linha                      ==");
        System.out.println("========================================================");
        System.out.println("                                                      ==");
        System.out.print("ID da Linha: ");
        String id = scanner.nextLine();

        try {
            Linha linha = controlador.buscarLinha(id);
            System.out.println("Nome: " + linha.getNome() + "                                 ==  ");
            System.out.print("Novo nome (<enter> = Não alterar): ");
            String nome = scanner.nextLine();
            if (!nome.equals("")) {
                linha.setNome(nome);
            }
            
            System.out.println();
            System.out.println("Origem: " + linha.getOrigem() + "                                      ==   ");
            System.out.print("Nova origem (<enter> = Não alterar): ");
            String origem = scanner.nextLine();
            if (!origem.equals("")) {
                linha.setOrigem(origem);
            }
            
            System.out.println();
            System.out.println("Destino: " + linha.getDestino() + "                                       ==");
            System.out.print("Origem (<enter> = Não alterar): ");
            String destino = scanner.nextLine();
            if (!destino.equals("")) {
                linha.setDestino(destino);
            }
            
            System.out.println();
            System.out.println("Valor da Passagem: " + linha.getValorPassagem() + "                              ==");
            System.out.print("Valor da Passagem (<enter> = Não alterar): ");
            String valorPassagem = scanner.nextLine();
            double valorPassagem1 = Double.valueOf(valorPassagem).doubleValue();
            if (valorPassagem1 != linha.getValorPassagem()) {
                linha.setValorPassagem(valorPassagem1);
            }
            
            System.out.println();
            controlador.alterarLinha(linha);
            System.out.println("Linha Atualizada!");
            System.out.println();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("========================================================");
        System.out.println("tecle <enter> para voltar                             ==");
        System.out.println("========================================================");
        scanner.nextLine();


    }
    private static void listarLinhas(){
    	limpaTela();
        System.out.println("=========================================================================================");
        System.out.println("==                               Lista de Linhas                                       ==");
        System.out.println("=========================================================================================");
        
        List<Linha> linhas = controlador.getAllLinha();
            System.out.println("Id     Linha                 Origem      Destino     Embarcação         Valor da Passagem   ");
            System.out.println("====== ===================== =========== =========== ================== =================");
            for (Linha linha: linhas) {
                System.out.printf("%-6s ", linha.getID());
                System.out.printf("%-21s ", linha.getNome());
                System.out.printf("%-11s ", linha.getOrigem());
                System.out.printf("%-11s ", linha.getDestino());
                System.out.printf("%-18s ", linha.getEmbarcacao().getNome());
                System.out.printf("R$ %14.2f \n", linha.getValorPassagem());
            }
            
            System.out.println("====== ===================== =========== =========== ================== =================");
            System.out.println("\n=========================================================================================");
            System.out.println("tecle <enter> para voltar                                                              ==");
            System.out.println("=========================================================================================");
            scanner.nextLine();


    }
    private static void buscarLinha(){
    	limpaTela();
        System.out.println("=========================================================================================");
        System.out.println("==                                 Consultar Linha                                     ==");
        System.out.println("=========================================================================================");
        System.out.println("                                                                                       ==");
        System.out.print("Id da Linha: ");
        String id = scanner.nextLine();
        limpaTela();
        
        try {
        	Linha linha = controlador.buscarLinha(id);
            System.out.println("=================================================================================================");
        	System.out.println("==                                Informações da Linha                                         ==   ");
            System.out.println("=================================================================================================");
            System.out.println("Id    Nome               Origem     Destino     Embarcação      Empresa            Valor/passagem");
            System.out.println("===== ================== ========== =========== =============== ================== ==============");
            System.out.printf("%-6s", linha.getID());
            System.out.printf("%-19s", linha.getNome());
            System.out.printf("%-11s", linha.getOrigem());
            System.out.printf("%-12s", linha.getDestino());
            System.out.printf("%-16s", linha.getEmbarcacao().getNome());
            System.out.printf("%-19s", linha.getEmbarcacao().getProprietário().getNome());
            System.out.printf("R$ %11.2f ", linha.getValorPassagem());
            System.out.println("\n===== ================== ========== =========== =============== ================== ==============");
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println("=================================================================================================");
        System.out.println("tecle <enter> para voltar                                                                      ==");
        System.out.println("=================================================================================================");
        scanner.nextLine();

    }

    //                  M E N U    P A S S A G E M

    private static void menuPassagem(){
        
        int opcao;
        do{
        	limpaTela();
            System.out.println("==================================================");
            System.out.println("==             COMPRAR PASSAGEM                 ==");
            System.out.println("==================================================");
            System.out.println("                               ===================");
            System.out.println("  1. COMPRAR PASSAGEM       ======================");
            System.out.println("  2. CANCELAR PASSAGEM          ==================");
            System.out.println("  3. ALTERAR PASSAGEM          ===================");
            System.out.println("  4. LISTAR PASSAGENS         ====================");
            System.out.println("  5. BUSCAR PASSAGENS             ================");
            System.out.println("  6. TIRAR SEGUNDA VIA           =================");
            System.out.println("  0. MENU PRINCIPAL                  =============");
            System.out.println("                               ===================");
            System.out.println("==================================================");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }
            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    comprarPassagem();
                    break;
                case 2:
                    cancelarPassagem();
                    break;
                case 3:
                    alterarPassagem();
                    break;
                case 4:
                    listarPassagens();
                    break;
                case 5:
                    consultarPassagens();
                    break;
                case 6:
                    retirarSegundaVia();
                    break;
            }
        }while(opcao != 0);
    }
       
	
	private static void comprarPassagem(){
    	limpaTela();
        System.out.println("===============================================");
    	System.out.println("==             COMPRAR PASSAGEM              ==");
        System.out.println("===============================================");
        
        try {
            System.out.print("ID da viagem: ");
            String id = scanner.nextLine();
            Viagem viagem = controlador.buscarViagem(id);
            System.out.println();
            
            System.out.print("RG do Passageiro: ");
            String RG = scanner.nextLine();
            String nome = null;
			List<Passagem> passagens = controlador.getAllpassagem(RG);
			if(passagens.isEmpty()) {
				System.out.print("Nome do Passageiro: ");
                nome = scanner.nextLine();	
			
	        } else {
	            for (Passagem passagem : passagens) {
	            	nome = passagem.getNome();
	            }
			}
			String novonome = nome;
			Passagem passagem = new Passagem(RG, novonome, viagem);
        	controlador.criarPassagem(passagem);
        	System.out.println("                                             ==");
            System.out.println("Passagem para " + passagem.getViagem().getLinha().getNome() + " Cadastrada! ");
            System.out.println("                                             ==");	
            	
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
      
        System.out.println("===============================================");
        System.out.println("tecle <enter> para voltar                    ==");
        System.out.println("===============================================");
        scanner.nextLine();


    }
    private static void cancelarPassagem(){
    	limpaTela();
        System.out.println("===============================================");
        System.out.println("==             CANCELAR PASSAGEM             ==");
        System.out.println("===============================================");
        System.out.println("1. Qual o id da Passagem?                    ==");
        System.out.print("id: ");
        String id = scanner.nextLine();

        try {
            Passagem passagem = controlador.buscarPassagem(id);
            System.out.println("ID   RG          Nome           Viagem");
            System.out.println("==== =========== ============== ====================    ");
            System.out.printf("%-5s", passagem.getID());
            System.out.printf("%-12s", passagem.getRG());
            System.out.printf("%-14s ", passagem.getNome());
            System.out.printf("%-10s", passagem.getViagem().getLinha().getNome());
            System.out.println("\n==== =========== ============== ====================");

            System.out.println("Cancelar essa Passagem? (s/n)?               ==");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                controlador.deletarPassagem(passagem);
                
                System.out.println("Passagem Cancelada!                          ==");
            }else {
            	System.out.println("Passagem Não Cancelada!                      ==");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("===============================================");
        System.out.println("tecle <enter> para voltar                    ==");
        System.out.println("===============================================");
        scanner.nextLine();

    }
    private static void alterarPassagem(){
    	
    	limpaTela();
        System.out.println("========================================================");
        System.out.println("==                Alterar Passagem                    ==");
        System.out.println("========================================================");
        System.out.print("ID da Passagem: ");
        String id = scanner.nextLine();

        try {
            Passagem passagem = controlador.buscarPassagem(id);
            System.out.println("========================================================");
            System.out.println("Nome: " + passagem.getNome() + "                                           ==   ");
            System.out.print("Novo nome (<enter> = Não alterar): ");
            String nome = scanner.nextLine();
            if (!nome.equals("")) {
                passagem.setNome(nome);
            }
            
            controlador.alterarPassagem(passagem);
            System.out.println("Passagem Atualizada!                                  ==");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println("========================================================");
        System.out.println("tecle <enter> para voltar                             ==");
        System.out.println("========================================================");
        scanner.nextLine();

    }
    private static void listarPassagens(){
    	limpaTela();
        System.out.println("=============================================================");
        System.out.println("==                  Lista de Passagens                     ==");
        System.out.println("=============================================================");
        
        List<Passagem> passagens = controlador.getAllpassagem();
            System.out.println("Id     Nome               Viagem              Embarcação");
            System.out.println("====== ================== =================== ===============");
            for (Passagem passagem: passagens) {
                System.out.printf("%-6s ", passagem.getID());
                System.out.printf("%-18s ", passagem.getNome());
                System.out.printf("%-19s ", passagem.getViagem().getLinha().getNome());
                System.out.print(passagem.getViagem().getLinha().getEmbarcacao().getNome() + "\n");
       
            }
            System.out.println("====== ================== =================== ===============\n");
            System.out.println("=============================================================");
            System.out.println("tecle <enter> para voltar");
            System.out.println("=============================================================");
            scanner.nextLine();


    }
    
    private static void consultarPassagens() {
    	
    	limpaTela();
        System.out.println("===========================================================");
        System.out.println("==                 Consultar Passagem                    ==   ");
        System.out.println("===========================================================");
        System.out.print("Id da Passagem: ");
        String id = scanner.nextLine();
        limpaTela();
        
        try {
            System.out.println("================================================================================================");
        	System.out.println("==                                Informações da Passagem                                     ==   ");
            System.out.println("================================================================================================");
            Passagem passagem = controlador.buscarPassagem(id);
            System.out.println("ID    RG   Nome           Viagem           Embarcação          Empresa           Valor/Passagem ");
            System.out.println("===== ==== ============== ================ =================== ================= ===============");
            System.out.printf("%5s ", passagem.getID());
            System.out.printf("%-5s", passagem.getRG());
            System.out.printf("%-15s", passagem.getNome());
            System.out.printf("%-17s", passagem.getViagem().getLinha().getNome());
            System.out.printf("%-20s", passagem.getViagem().getLinha().getEmbarcacao().getNome());
            System.out.printf("%-18s", passagem.getViagem().getLinha().getEmbarcacao().getProprietário().getNome() + "");
            System.out.printf("R$ %12.2f \n", passagem.getViagem().getLinha().getValorPassagem());
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("================================================================================================");
        System.out.println("tecle <enter> para voltar                                                                     ==");
        System.out.println("================================================================================================");
        scanner.nextLine();
		
	}
    
    private static void retirarSegundaVia(){
    	
    	limpaTela();
        System.out.println("=====================================================================================");
        System.out.println("==                             Retirar Segunda Via                                 ==");
        System.out.println("=====================================================================================");
        System.out.print("RG: ");
        String RG = scanner.nextLine();
        limpaTela();
        
        try {
        	
        	Passagem passagemRG = controlador.buscarPassagemRG(RG);
            System.out.println("======================================");
        	System.out.println("Passagens de " + passagemRG.getRG() + ": ");
        	System.out.println("======================================");
        	System.out.println("                                    ==");
        	System.out.println("Rota              Embarcação      ID   ");
        	System.out.println("================= =============== ====");
        	List<Passagem> passagens = controlador.getAllpassagem(RG);

        	for (Passagem passagem : passagens) {
                System.out.printf("%-18s", passagem.getViagem().getLinha().getNome());
                System.out.printf("%-15s ", passagem.getViagem().getLinha().getEmbarcacao().getNome());
                System.out.print(passagem.getID()  + "\n");
                
				
			}	
        	System.out.println("======================================");
        	System.out.println();
        	System.out.println("ID da segunda via desejada:         ==");
        	System.out.print("ID: ");
    		String id =  scanner.nextLine();
    		Passagem passagem = controlador.buscarPassagem(id);
            limpaTela();
            if(passagens.contains(passagem)){
                	System.out.println("Segunda via retirada com sucesso!");
                    System.out.println("Aguarde enquanto é imprimida sua passagem...");
                    Thread.sleep(5000);
                    limpaTela();
            		System.out.println("================= PASSAGEIRO ==================");
                    Thread.sleep(250);
                    System.out.printf("%-19s", passagem.getNome());
                    System.out.printf("%-22s", "RG: " + passagem.getRG());
                    System.out.print("ID [" + passagem.getID() + "]\n");
                    Thread.sleep(250);
                    System.out.println("=================== VIAGEM ====================");
                    Thread.sleep(250);
                    System.out.print("Origem/Destino:");
                    System.out.printf("%32s", passagem.getViagem().getLinha().getNome() + "  "); 
                    Thread.sleep(250);
                    System.out.print("\nEmbarcação:");
                    System.out.printf("%36s", passagem.getViagem().getLinha().getEmbarcacao().getNome() + "  ");
                    Thread.sleep(250);
                    System.out.print("\nEmpresa:");
                    System.out.printf("%36s", passagem.getViagem().getLinha().getEmbarcacao().getProprietário().getNome());
                    Thread.sleep(250);
                    System.out.printf("%-31s", "\nValor da Passagem:");
                    Thread.sleep(250);
                    System.out.printf("R$ %.2f \n", passagem.getViagem().getLinha().getValorPassagem());
                    Thread.sleep(2000);
                } else {
                	System.out.println("Id não consta no RG de " + passagemRG.getNome());
    		}
			
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("===============================================");
        System.out.println("tecle <enter> para voltar                    ==");
        System.out.println("===============================================");
        scanner.nextLine();
  
    }
    

}
