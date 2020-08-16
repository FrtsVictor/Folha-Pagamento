package br.com.serratec.folhaPagamento.main;

import java.util.Scanner;

import br.com.serratec.folhaPagamento.classeConcreta.Menu;


public class FolhaPagamentoJ {

	public static void main(String[] args) {
			
		
		Menu menuPrincipal = new Menu(); 
		System.out.println("-----------------------------------------------------------");
		System.out.println("Bem vindo ao sistema de Calculo IR para funcionarios!!!");
		System.out.println("-----------------------------------------------------------\n");
		Scanner inMenu = new Scanner(System.in);
		int menus;

		do {
			menuPrincipal.exibirMenu();
			menus = inMenu.nextInt();
			
			switch (menus) {
			case 1: {
				menuPrincipal.adicionarPessoasConsole(); 	
			}break;
			case 2:{
				menuPrincipal.listarPessoasConsole();
			}break;
			case 3:
				menuPrincipal.escreverSaida();
			break;
			case 4:
				menuPrincipal.calcularViaCSV();
				break;
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default: System.out.println("Digite um valor valido\n");				
			}
			
		}while(menus!=0);
	inMenu.close();
	menuPrincipal.fecharScanners();

}

}