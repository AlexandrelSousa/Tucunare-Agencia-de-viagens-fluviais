package main;

import controler.ControladorTucunare;
import java.util.Scanner;

public class AgenciaTucunare{

    static ControladorTucunare controlador;
    static Scanner scanner = new Scanner(System.in);

    //                     !! Menu principal / homepage  !!
    public static void main (String[] args) throws Exception{
        int opcao;
        do{
            System.out.println("=============»  MENU PRINCIPAL  «=============");
            System.out.println("                             ===================");
            System.out.println("  1. MENU EMPRESAS           ===================");
            System.out.println("  2. MENU EMBACACOES         ===================");
            System.out.println("  3. MENU VIAGENS            ===================");
            System.out.println("  4. MENU LINHAS             ===================");
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
            System.out.println("=============»  MENU EMPRESAS  «=============");
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
            System.out.println("===========  MENU EMBARCACOES  ===================");
            System.out.println("                               ===================");
            System.out.println("  1. CRIAR UMA NOVA EMBARCACAO ===================");
            System.out.println("  2. EXCLUIR UMA EMBARCACAO    ===================");
            System.out.println("  3. ALTERAR UMA EMBARCACAO    ===================");
            System.out.println("  4. LISTAR EMBARCACOES        ===================");
            System.out.println("  5. BUSCAR EMBARCACAO         ===================");
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
                    criarEmparcacao();
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
    public static void criarEmparcacao(){

    } 
    public static void excluirEmbarcacao(){

    }
    public static void alterarEmbarcacao(){

    }
    public static void listarEmbarcacoes(){

    }
    public static void buscarEmbarcacao(){

    }

    //                  M E N U   V I A G E N S
    
    public static void menuViagens(){
        limpaTela();
        int opcao;
        do{
            System.out.println("==============  MENU VIAGENS   ===================");
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
            System.out.println("==============   MENU LINHAS   ===================");
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
