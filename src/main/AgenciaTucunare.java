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
        	System.out.println("============= AGÊNCIA TUCUNARÉ ===================");
        	System.out.println();
            System.out.println("=============  MENU PRINCIPAL  ===================");
            System.out.println("                               ===================");
            System.out.println("  1. EMPRESAS                  ===================");
            System.out.println("  2. EMBACAÇÕES                ===================");
            System.out.println("  3. VIAGENS                   ===================");
            System.out.println("  4. LINHAS                    ===================");
            System.out.println("  5. COMPRAR PASSAGEM          ===================");
            System.out.println("  0. SAIR                      ===================");
            System.out.println("                               ===================");
            System.out.println("==================================================");    
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
            Embarcacao e1 = new Embarcacao("Boto",2, empresa01);
            controlador.inserirEmbarcacao(e1);
            Embarcacao e2 = new Embarcacao("Barcarena",70, empresa02);
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
            Passagem p1 = new Passagem("1234","Fábio",v1);
            controlador.criarPassagem(p1);
            Passagem p2 = new Passagem("5678","Rodrigo",v1);
            controlador.criarPassagem(p2);
            Passagem p3 = new Passagem("9102","Barcus",v2);
            controlador.criarPassagem(p3);

        } catch (Exception ex) {
        
		}

		
	}

	public static void limpaTela(){
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    //              M E N U   E M P R E S A S

    public static void menuEmpresas(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("=================»  EMPRESAS  «====================");
            System.out.println("                                ===================");
            System.out.println("  1. CADASTRAR UMA NOVA EMPRESA ===================");
            System.out.println("  2. EXCLUIR UMA EMPRESA        ===================");
            System.out.println("  3. ALTERAR UMA EMPRESA        ===================");
            System.out.println("  4. LISTAR EMPRESAS            ===================");
            System.out.println("  5. BUSCAR EMPRESA             ===================");
            System.out.println("  0. MENU PRINCIPAL             ===================");
            System.out.println("                                ===================");
            System.out.println("===================================================");  
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
            }
        }while(opcao != 0);

    }
    public static void criarEmpresa(){
        limpaTela();      
        System.out.println("=============== CADASTRAR UMA NOVA EMPRESA ===================");
        System.out.println("                                           ===================");
        
        try{
            System.out.println("  1. QUAL O CNPJ DA EMPRESA? ===================");
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            System.out.println("Qual o nome da empresa?");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            Empresa empresa = new Empresa(cnpj, nome);
            controlador.inserirEmpresa(empresa);
            System.out.println("Cadastro feito com sucesso!");
        }catch(EmpresaJaCadastradaException ex ){
            System.err.println(ex.getMessage());
        }
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
        System.out.println("                               ===================");
        System.out.println("=================================================="); 
    }
    public static void excluirEmpresa(){
        limpaTela();
        System.out.println("=========== EXCLUIR EMPRESA ===================");
        System.out.println("1. Qual o CNPJ da empresa?  ===================");
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        try {
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println();
            System.out.println("Empresa: " + empresa.getNome() + "     ===================");
            System.out.println("CNPJ: " + empresa.getCnpj() + "        ===================");
            System.out.println();

            System.out.println("Exclui essa empresa? (s/n)? ===================");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                controlador.deletarEmpresa(empresa);
                System.out.println("Empresa excluida!");
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
    public static void alterarEmpresa(){
        limpaTela();
        System.out.println("=========== ALTERAR NOME ===================");
        System.out.println("1. Qual o CNPJ da empresa?  ===================");
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        try {
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println();
            System.out.println("Empresa: " + empresa.getNome() + "     ===================");
            System.out.println("CNPJ: " + empresa.getCnpj() + "                     ===================");
            System.out.println();

            System.out.println("Qual o novo nome da empresa? ===================");
            String nome = scanner.nextLine();
            empresa.setNome(nome);
            controlador.AlterarEmpresa(empresa);
            System.out.println("Nome alterado!");

        } catch (EmpresaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("                            ===================");
        System.out.println("tecle <enter> para voltar   ===================");
        System.out.println("                            ===================");
        System.out.println("===============================================");
        scanner.nextLine();
    }
    public static void listarEmpresas(){
        limpaTela();
        List<Empresa> empresas = controlador.getAllEmpresa();
        System.out.println("================ LISTAR EMPRESAS =================");
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
    public static void buscarEmpresa(){
        limpaTela();
        List<Embarcacao> embarcacoes;
        System.out.println("================ BUSCAR EMPRESA ========================");
        System.out.println("Qual o CNPJ da empresa?");
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        
        try{
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println("                                                   =====");
            System.out.println("EMPRESA           CNPJ           EMBARCAÇÕES       =====");
            System.out.println("================= ============== =======================");
            System.out.printf("%-17s ", empresa.getNome());
            System.out.printf("%-14s ", empresa.getCnpj());
            int i = 0;
            embarcacoes = controlador.getAll(empresa.getCnpj());
            for(Embarcacao embarcacao : embarcacoes){
            	i ++;
            	System.out.printf("%-36s ", embarcacao.getNome() + "\n");
            	System.out.print(" ");
            }
            if (i == 0) {
            	System.out.println("Não Possui Embarcação");
            }
        }catch(EmpresaNaoCadastradaException ex){
            System.err.println(ex.getMessage());
        }
        System.out.println("");
        System.out.println("tecle <enter> para voltar                          =====");
        System.out.println("                                                   =====");
        System.out.println("========================================================");
        scanner.nextLine();
    }

    //                  M E N U   E M B A R C A Ç Õ E S

    public static void menuEmbarcacoes(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("================  EMBARCAÇÕES  ===================");
            System.out.println("                               ===================");
            System.out.println("  1. CRIAR UMA NOVA EMBARCAÇÃO ===================");
            System.out.println("  2. EXCLUIR UMA EMBARCAÇÃO    ===================");
            System.out.println("  3. ALTERAR UMA EMBARCAÇÃO    ===================");
            System.out.println("  4. LISTAR EMBARCAÇÕES        ===================");
            System.out.println("  5. BUSCAR EMBARCAÇÃO         ===================");
            System.out.println("  0. MENU PRINCIPAL            ===================");
            System.out.println("                               ===================");
            System.out.println("==================================================");  
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
            }
        }while(opcao != 0);
    }
    public static void criarEmbarcacao() {
    	limpaTela();
    	System.out.println("============= CADASTRAR UMA NOVA EMBARCAÇÃO ==================");
    	System.out.println("                                                ==============");
        
        try {
            System.out.print("CNPJ da Empresa a qual a embarcação irá pertencer: ");
            String cnpj = scanner.nextLine();
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println();
            
            System.out.print("Nome da Embarcação: ");
            String nome = scanner.nextLine();
            System.out.print("Lotação da Embarcação: ");
            int lotacao = scanner.nextInt();
			Embarcacao embarcacao = new Embarcacao(nome, lotacao, empresa);
        	controlador.inserirEmbarcacao(embarcacao);
        	System.out.println("                                                ==============");
            System.out.println("Embarcacão " + embarcacao.getNome() + " Cadastrada! ");
            System.out.println("                                                ==============");	
            	
        } catch (EmbarcacaoJaCadastradaException|EmpresaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
      
        System.out.println("                                                ==============");
        System.out.println("tecle <enter> para voltar                       ==============");
        scanner.nextLine();
        System.out.println("==============================================================");
        scanner.nextLine();
        

    } 
    
    public static void excluirEmbarcacao(){
    	limpaTela();
        System.out.println("Excluir Embarcação");
        System.out.println("==================");
        System.out.println();
        System.out.print("ID da Embarcação: ");
        String Id = scanner.nextLine();

        try {
            Embarcacao embarcacao = controlador.buscarEmbarcacao(Id);
            System.out.println();
            System.out.println("Id..........: " + embarcacao.getId());
            System.out.println("Nome........: " + embarcacao.getNome());
            System.out.println();

            System.out.print("Exclui essa Embarcação? (s/n)?\n");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
            	controlador.deletarEmbarcacao(embarcacao);
            	System.out.println("Embarcação excluída!");
            }
            
        } catch (EmbarcacaoNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }
    public static void alterarEmbarcacao(){
    	
    	limpaTela();
        System.out.println("Alterar Nome da Embarcação");
        System.out.println("==========================");
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
            System.out.println("Nome da Embarcação Alterado!");
            System.out.println();

        } catch (EmbarcacaoNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }
    public static void listarEmbarcacoes(){
    	 limpaTela();
    	 
         System.out.println("======>> Lista de Embarcações <<========");
         System.out.println("========================================");
         List<Embarcacao> embarcacoes = controlador.getAllEmbarcacao();
             System.out.printf("Id     Empresa             Nome       \n");
             System.out.printf("====== ==================  =============\n");
             for (Embarcacao embarcacao: embarcacoes) {
                 System.out.printf("%6s ", embarcacao.getId());
                 System.out.printf("%-19s ", embarcacao.getProprietário().getNome());
                 System.out.printf("%-11s \n", embarcacao.getNome());
        
             }
             System.out.println("========================================");
             System.out.println();
             System.out.println("tecle <enter> para voltar");
             scanner.nextLine();
    }

    public static void buscarEmbarcacao(){
    	limpaTela();
        System.out.println("Consultar Embarcação");
        System.out.println("====================");
        System.out.println();
        System.out.print("Id da Embarcação: ");
        String id = scanner.nextLine();
        limpaTela();
        
        try {
        	System.out.println("Informações da Embarcação");
            System.out.println("=========================");
            Embarcacao embarcacao = controlador.buscarEmbarcacao(id);
            System.out.println();
            System.out.println("Id..........: " + embarcacao.getId());
            System.out.println("Nome........: " + embarcacao.getNome());
            System.out.println("Lotação.....: " + embarcacao.getLotacao());
            System.out.println("Proprietário: " + embarcacao.getProprietário().getNome());
            System.out.println();

        } catch (EmbarcacaoNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }

    //                  M E N U   V I A G E N S
    
    public static void menuViagens(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("==============  VIAGENS   ===================");
            System.out.println("                               ===================");
            System.out.println("  1. CADASTRAR UMA NOVA VIAGEM ===================");
            System.out.println("  2. CANCELAR UMA VIAGEM       ===================");
            System.out.println("  3. ALTERAR UMA VIAGEM        ===================");
            System.out.println("  4. LISTAR VIAGENS            ===================");
            System.out.println("  5. BUSCAR VIAGEM             ===================");
            System.out.println("  0. MENU PRINCIPAL            ===================");
            System.out.println("                               ===================");
            System.out.println("==================================================");  
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
            }
        }while(opcao != 0);
    }
    public static void cadastrarViagem(){
    	limpaTela();
    	System.out.println("============= CADASTRAR UMA NOVA VIAGEM ==================");
    	System.out.println("                                            ==============");
        
        try {
            System.out.print("ID da linha a qual a viagem irá acontecer: ");
            String id = scanner.nextLine();
            Linha linha = controlador.buscarLinha(id);
            System.out.println();
            
            
            Date data = new Date();
			Viagem viagem = new Viagem(data, linha);
        	controlador.inserirViagem(viagem);
        	System.out.println("                                                ==============");
            System.out.println("Viagem para " + viagem.getLinha().getNome() + " Cadastrada! ");
            System.out.println("                                                ==============");	
            	
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
      
        System.out.println("                                                ==============");
        System.out.println("tecle <enter> para voltar                       ==============");
        System.out.println("==============================================================");
        scanner.nextLine();

    }
    public static void cancelarViagem(){
    	
    	limpaTela();
        System.out.println("=========== CANCELAR VIAGEM ===================");
        System.out.println("1. Qual o id da viagem?  ===================");
        System.out.print("id: ");
        String id = scanner.nextLine();

        try {
            Viagem viagem = controlador.buscarViagem(id);
            System.out.println();
            System.out.println("Viagem..: " + viagem.getLinha().getNome());
            System.out.println("Data....: " + viagem.getData());
            System.out.println();

            System.out.println("Cancelar essa Viagem? (s/n)? ===================");
            String resposta = scanner.nextLine();
            System.out.println();

            if (resposta.equalsIgnoreCase("s")) {
                controlador.deletarViagem(viagem);
                System.out.println("Viagem Cancelada!");
            }else {
            	System.out.println("Viagem Não Cancelada!");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("                            ===================");
        System.out.println("tecle <enter> para voltar   ===================");
        System.out.println("                            ===================");
        System.out.println("===============================================");
        scanner.nextLine();
    }

    @SuppressWarnings("unlikely-arg-type")
	public static void alterarViagem(){
    	
    	limpaTela();
        System.out.println("      Alterar Viagem      ");
        System.out.println("==========================");
        System.out.print("ID: ");
        String id = scanner.nextLine();

        try {
            Viagem viagem = controlador.buscarViagem(id);

            System.out.println();
            System.out.println("Data: " + viagem.getData());
            System.out.print("Data (<enter> = Não alterar): ");
            String dataNova = scanner.nextLine();
            DateFormat df = new SimpleDateFormat("dd,MM,YYYY");
            Date data = df.parse(dataNova);
            if (!data.equals("")) {
                viagem.setData(data);
            }
            
            
            System.out.println();
            controlador.alterarViagem(viagem);
            System.out.println("Viagem Alterada!");
            System.out.println();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }
    
    public static void listarViagens(){
    	
    	limpaTela();
        System.out.println("======>> Lista de Viagens <<========");
        System.out.println("========================================");
        
        List<Viagem> viagens = controlador.getAllViagem();
            System.out.printf("Id     Linha              Data        \n");
            System.out.printf("====== ================== ============================\n");
            for (Viagem viagem: viagens) {
                System.out.printf("%6s ", viagem.getId());
                System.out.printf("%-18s ", viagem.getLinha().getNome());
                System.out.printf("%10s \n", viagem.getData());
       
            }
            System.out.println("======================================================");
            System.out.println();
            System.out.println("tecle <enter> para voltar");
            scanner.nextLine();

    }
    
    public static void buscarViagem(){
    	limpaTela();
        System.out.println("Consultar Viagem");
        System.out.println("================");
        System.out.println();
        System.out.print("Id da Viagem: ");
        String id = scanner.nextLine();
        limpaTela();
        
        try {
        	System.out.println("  Informações da Viagem ");
            System.out.println("=========================");
            Viagem viagem = controlador.buscarViagem(id);
            System.out.println();
            System.out.println("Id..........: " + viagem.getId());
            System.out.println("Data........: " + viagem.getData());
            System.out.println("Linha.......: " + viagem.getLinha().getNome());
            System.out.println("Embarcação..: " + viagem.getLinha().getEmbarcacao().getNome());
            System.out.println("Empresa.....: " + viagem.getLinha().getEmbarcacao().getProprietário().getNome());
            System.out.println();

        } catch (ViagemNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }

    //                  M E N U   L I N H A S

    public static void menuLinhas(){
    	
        int opcao;
        do{
        	limpaTela();
            System.out.println("==============   LINHAS   ===================");
            System.out.println("                               ===================");
            System.out.println("  1. CRIAR UMA NOVA LINHA      ===================");
            System.out.println("  2. EXCLUIR UMA LINHA         ===================");
            System.out.println("  3. ALTERAR UMA LINHA         ===================");
            System.out.println("  4. LISTAR LINHAS             ===================");
            System.out.println("  5. BUSCAR LINHA              ===================");
            System.out.println("  0. MENU PRINCIPAL            ===================");
            System.out.println("                               ===================");
            System.out.println("==================================================");  
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
                    criarLinha();
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
            }
        }while(opcao != 0);
    }
    public static void criarLinha(){

    }
    public static void excluirLinha(){

    }
    public static void alterarLinha(){

    }
    public static void listarLinhas(){

    }
    public static void buscarLinha(){

    }

    //                  C O M P R A R    P A S S A G E M

    public static void menuPassagem(){
        
        int opcao;
        do{
        	limpaTela();
            System.out.println("============= COMPRAR PASSAGEM ===================");
            System.out.println("                               ===================");
            System.out.println("  1. COMPRAR PASSAGEM          ===================");
            System.out.println("  2. CANCELAR PASSAGEM         ===================");
            System.out.println("  3. ALTERAR PASSAGEM          ===================");
            System.out.println("  4. LISTAR PASSAGENS          ===================");
            System.out.println("  5. TIRAR SEGUNDA VIA         ===================");
            System.out.println("  0. MENU PRINCIPAL            ===================");
            System.out.println("                               ===================");
            System.out.println("==================================================");  
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
                    tirarSegundaVia();
                    break;
            }
        }while(opcao != 0);
    }
    public static void comprarPassagem(){

    }
    public static void cancelarPassagem(){

    }
    public static void alterarPassagem(){

    }
    public static void listarPassagens(){

    }
    public static void tirarSegundaVia(){
        
    }

}
