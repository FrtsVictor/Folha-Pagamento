package br.com.serratec.folhaPagamento.main;

import java.util.Scanner;

import br.com.serratec.folhaPagamento.classeConcreta.Menu;

public class FolhaPagamento {

	public static void main(String[] args) {
			
		
		Menu menuC = new Menu();
		
		System.out.println("Bem vindo ao sistema de Calculo IR para funcionarios!!!\n");
		
		Scanner inMenu = new Scanner(System.in);
		int menus;
		do {
			menuC.exibirMenu();
			menus = inMenu.nextInt();
			
			switch (menus) {
			case 1: {
				menuC.adicionarPessoasConsole(); 	
			}break;
			case 2:{
				menuC.listarPessoasConsole();
			}break;
			case 3:
				menuC.escreverSaida();
			break;
			case 4:
				menuC.calcularViaCSV();
				break;
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default: System.out.println("Digite um valor valido\n");				
			}
			
		}while(menus!=0);
	inMenu.close();
	menuC.fecharScanners();

}

}