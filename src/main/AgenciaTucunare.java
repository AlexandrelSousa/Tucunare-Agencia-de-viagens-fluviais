package main;

import controler.ControladorTucunare;
import model.embarcacao.Embarcacao;
import model.empresa.Empresa;
import repository.embarcacao.EmbarcacaoJaCadastradaException;
import repository.embarcacao.EmbarcacaoNaoCadastradaException;
import repository.empresa.EmpresaJaCadastradaException;
import repository.empresa.EmpresaNaoCadastradaException;

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
        	System.out.println("=============»  AGÊNCIA TUCUNARÉ  «=============");
            System.out.println("=============»   MENU PRINCIPAL  «==============");
            System.out.println("                             ===================");
            System.out.println("  1. EMPRESAS                ===================");
            System.out.println("  2. EMBACAÇÕES              ===================");
            System.out.println("  3. VIAGENS                 ===================");
            System.out.println("  4. LINHAS                  ===================");
            System.out.println("  5. COMPRAR PASSAGEM        ===================");
            System.out.println("  0. SAIR                    ===================");
            System.out.println("                             ===================");
            System.out.println("================================================");    
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

            Empresa empresa01 = new Empresa("1", "Jarlison Neves");
            controlador.inserirEmpresa(empresa01);
            Empresa empresa02 = new Empresa("2", "Alexandre");
            controlador.inserirEmpresa(empresa02);

            Embarcacao e1 = new Embarcacao("Boto",100, empresa01);
            controlador.inserirEmbarcacao(e1);
            Embarcacao e2 = new Embarcacao("Barcarena",70, empresa02);
            controlador.inserirEmbarcacao(e2);

        } catch (EmbarcacaoJaCadastradaException | EmpresaJaCadastradaException ex) {
        }

		
	}

	public static void limpaTela(){
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    //              M E N U   E M P R E S A S

    public static void menuEmpresas(){
        limpaTela();
        int opcao;
        do{
            System.out.println("=============»  EMPRESAS  «=============");
            System.out.println("                             ===================");
            System.out.println("  1. CRIAR UMA NOVA EMPRESA  ===================");
            System.out.println("  2. EXCLUIR UMA EMPRESA     ===================");
            System.out.println("  3. ALTERAR UMA EMPRESA     ===================");
            System.out.println("  4. LISTAR EMPRESAS         ===================");
            System.out.println("  5. BUSCAR EMPRESA          ===================");
            System.out.println("  0. SAIR                    ===================");
            System.out.println("                             ===================");
            System.out.println("================================================");  
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

    }
    public static void excluirEmpresa(){

    }
    public static void alterarEmpresa(){

    }
    public static void listarEmpresas(){

    }
    public static void buscarEmpresa(){

    }

    //                  M E N U   E M B A R C A Ç Õ E S

    public static void menuEmbarcacoes(){
        limpaTela();
        int opcao;
        do{
            System.out.println("===========  EMBARCAÇÕES  ===================");
            System.out.println("                               ===================");
            System.out.println("  1. CRIAR UMA NOVA EMBARCAÇÃO ===================");
            System.out.println("  2. EXCLUIR UMA EMBARCAÇÃO    ===================");
            System.out.println("  3. ALTERAR UMA EMBARCAÇÃO    ===================");
            System.out.println("  4. LISTAR EMBARCAÇÕES        ===================");
            System.out.println("  5. BUSCAR EMBARCAÇÃO         ===================");
            System.out.println("  0. SAIR                      ===================");
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
        System.out.println("Cadastro de Embarcação");
        System.out.println("======================");
        
        try {
            System.out.print("CNPJ da Empresa: ");
            String cnpj = scanner.nextLine();
            Empresa empresa = controlador.buscarEmpresa(cnpj);
            System.out.println();
            
            System.out.print("Nome da Embarcação: ");
            String nome = scanner.nextLine();
            System.out.print("Lotação da Embarcação: ");
            int lotacao = scanner.nextInt();
			Embarcacao embarcacao = new Embarcacao(nome, lotacao, empresa);
        	embarcacao = controlador.inserirEmbarcacao(embarcacao);
        	System.out.println("=============================");
            System.out.println("Embarcacão " + embarcacao.getNome() + " criada!");
            System.out.println("=============================");	
            	
            
        } catch (EmbarcacaoJaCadastradaException|EmpresaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("tecle <enter> para voltar");
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
        limpaTela();
        int opcao;
        do{
            System.out.println("==============  VIAGENS   ===================");
            System.out.println("                               ===================");
            System.out.println("  1. CRIAR UMA NOVA VIAGEM     ===================");
            System.out.println("  2. EXCLUIR UMA VIAGEM        ===================");
            System.out.println("  3. ALTERAR UMA VIAGEM        ===================");
            System.out.println("  4. LISTAR VIAGENS            ===================");
            System.out.println("  5. BUSCAR VIAGEM             ===================");
            System.out.println("  0. SAIR                      ===================");
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
                    criarViagem();
                    break;
                case 2:
                    excluirViagem();
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
    public static void criarViagem(){

    }
    public static void excluirViagem(){

    }
    public static void alterarViagem(){

    }
    public static void listarViagens(){

    }
    public static void buscarViagem(){

    }

    //                  M E N U   L I N H A S

    public static void menuLinhas(){
        limpaTela();
        int opcao;
        do{
            System.out.println("==============   LINHAS   ===================");
            System.out.println("                               ===================");
            System.out.println("  1. CRIAR UMA NOVA LINHA      ===================");
            System.out.println("  2. EXCLUIR UMA LINHA         ===================");
            System.out.println("  3. ALTERAR UMA LINHA         ===================");
            System.out.println("  4. LISTAR LINHAS             ===================");
            System.out.println("  5. BUSCAR LINHA              ===================");
            System.out.println("  0. SAIR                      ===================");
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
        limpaTela();
        int opcao;
        do{
            System.out.println("============= COMPRAR PASSAGEM ===================");
            System.out.println("                               ===================");
            System.out.println("  1. COMPRAR PASSAGEM          ===================");
            System.out.println("  2. CANCELAR PASSAGEM         ===================");
            System.out.println("  3. ALTERAR PASSAGEM          ===================");
            System.out.println("  4. LISTAR PASSAGENS          ===================");
            System.out.println("  5. TIRAR SEGUNDA VIA         ===================");
            System.out.println("  0. SAIR                      ===================");
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
