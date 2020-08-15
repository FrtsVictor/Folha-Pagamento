package br.com.serratec.folhaPagamento.main;

import java.util.Scanner;

import br.com.serratec.folhaPagamento.classeConcreta.Menu;

public class FolhaPagamento {

	public static void exibirMenu() {
		System.out.println("_______Sistema para Calculo de Folha de Pagamento_______\n");
		System.out.println("1 - Para adicionar funcionarios e dependentes via console");
		System.out.println("2 - Para listar funcionarios e dependentes adicionados via console");
		System.out.println("3 - Para gravar entrada de funcionarios via console.");
		System.out.println("4 - Para adicionar e calcular funcionarios e dependentes via arquivo .csv");
		System.out.println("0 - Para sair do menu");
	}

	public static void main(String[] args) {
			
		
		Menu scannersCases = new Menu();
		
		System.out.println("Bem vindo ao sistema de Calculo IR para funcionarios!!!\n");
		
		Scanner inMenu = new Scanner(System.in);
		int menus;
		do {
			exibirMenu();
			menus = inMenu.nextInt();
			
			switch (menus) {
			case 1: {
				scannersCases.adicionarPessoasConsole(); 	
			}break;
			case 2:{
				scannersCases.listarPessoasConsole();
			}break;
			case 3:
				scannersCases.escreverSaida();
			break;
			case 4:
				System.out.println("Opcao 4 selecionada.");
				scannersCases.calcularViaCSV();
				break;
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default: System.out.println("Digite um valor valido\n");				
			}
			
		}while(menus!=0);
	inMenu.close();
	scannersCases.fecharScanners();

}

}