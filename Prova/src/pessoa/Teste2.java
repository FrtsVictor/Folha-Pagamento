package provinha.src.pessoa;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import provinha.src.enumm.Parentesco;
import provinha.src.exception.DependenteException;

public class Teste2 {

	public static void exibirMenu() {
		System.out.println("_______Sistema para Calculo de Folha de Pagamento_______\n");
		System.out.println("1 - Para adicionar funcionarios e dependentes manualmente");
		System.out.println("2 - Para listar funcionarios e dependentes adicionados manualmente");
		System.out.println("3 - Para adicionar e calcular funcionarios e dependentes");
		System.out.println("0 - Para sair do menu");
	}

	public static void main(String[] args) {

		int menu;
		String nome, cpf, rg, dataString, tipoDependente,  diretorio, diretorioFixed;
		double salarioBruto, salarioLiquido, descontoIR, descontoINSS;
		LocalDate dataNascimento;

		Scanner inMenu = new Scanner(System.in);
		Scanner entradaDp = new Scanner(System.in);
		Scanner entradaDiretorio = new Scanner(System.in);
		Scanner entradaF = new Scanner(System.in);
		Scanner dp = new Scanner(System.in);
		
		
		System.out.println("Bem vindo ao sistema de Calculo IR para funcionários!!!\n");

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		List<Funcionario> listaFuncionarioInput = new ArrayList<Funcionario>();

		do {
			exibirMenu();
			menu = inMenu.nextInt();
			switch (menu) {
			case 1: {
				System.out.println("Digite o nome do funcionario: ");
				nome = entradaF.nextLine();
				System.out.println("Digite o CPF do funcionario. (CPF valido somente de 11 digitos)");
				cpf = entradaF.nextLine();
				System.out.println("Digite o RG do funcionario");
				rg = entradaF.nextLine();
				System.out.println("Digite a data de nascimento do funcionario yyyy-MM-dd  ex: 2020-01-01");
				dataString = entradaF.nextLine();
				dataNascimento = LocalDate.parse(dataString, format);
				System.out.println("Digite o salario bruto do funcionario");
				salarioBruto = entradaF.nextDouble();

				Funcionario funcionario = new Funcionario(nome, cpf, rg, dataNascimento, salarioBruto);
				listaFuncionarioInput.add(funcionario);
				
				System.out.println("Funcionario possui dependentes? sim/nao");
				
				String resposta1 = dp.nextLine();

				while (resposta1.equals("sim")) {
					System.out.println("Digite o nome do dependente: ");
					nome = entradaDp.nextLine();
					System.out.println("Digite o CPF do dependente. (CPF valido somente de 11 digitos)");
					cpf = entradaDp.nextLine();
					System.out.println("Digite a data de nascimento do dependente yyyy-MM-dd  ex: 2020-01-01");
					dataString = entradaDp.nextLine();
					dataNascimento = LocalDate.parse(dataString, format);
					System.out.println("Qual o tipo de dependente? OUTROS/FILHO/SOBRINHO");
					tipoDependente = entradaDp.nextLine().toUpperCase();

					Dependente dependente = new Dependente(nome, cpf, dataNascimento,
							Parentesco.valueOf(tipoDependente));
					funcionario.adicionarDependente(dependente);
					System.out.println("Funcionario possui mais dependentes? sim/nao");
					resposta1 = dp.nextLine().toLowerCase();
				}
				funcionario.calcularImpostoRenda();				
			}break;
			case 2:{
				System.out.println("Lista de Funcionario com seus dependentes");
				for (Funcionario func : listaFuncionarioInput) {
            		System.out.println(func.getNome());
            		System.out.printf("Salario Bruto: %.2f", func.getSalarioBruto());
            		System.out.printf("\nDesconto INSS: %.2f", func.getDescontoINSS());
            		System.out.printf("\nData Nascimento: ", func.getDataNascimento());
            		System.out.printf("\nDesconto IR: %.2f", func.getDescontoIR());
            		System.out.printf("\nSalario Liq: %.2f", func.getSalarioLiquido());
            		System.out.println(func.getListaDependente());
					}
			}break;
			case 3:				
				System.out.println("Selecione o caminho absoluto para entrada de arquivo csv");
				diretorio = entradaDiretorio.nextLine();
				diretorioFixed = diretorio.replace("\"", "\\");

				File arquivoEntrada = new File(diretorioFixed);

				List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

				Funcionario funcionario = null;
				try {
					Scanner entradaArq = new Scanner(arquivoEntrada);

					while (entradaArq.hasNextLine()) {

						while (!entradaArq.equals(1) && entradaArq.hasNext()) {
							String[] pessoa = entradaArq.nextLine().split(";");
							if (pessoa.length == 5) {
								
								funcionario = new Funcionario(pessoa[0], pessoa[1], pessoa[2], LocalDate.parse(pessoa[3], formatter), Double.parseDouble(pessoa[4]));
								listaFuncionario.add(funcionario);
								
							} else if (pessoa.length == 4) {
								
								Dependente dependente = new Dependente(pessoa[0], pessoa[1],LocalDate.parse(pessoa[2], formatter), Parentesco.valueOf(pessoa[3]));
								funcionario.adicionarDependente(dependente);
							}

							funcionario.calcularImpostoRenda();
							funcionario.verificarCpfRepetidoDependente();
						} // FIM DO WHILE DE DENTRO

						for (Funcionario fun : listaFuncionario) {
							int cont = 0;
							for (Funcionario func : listaFuncionario) {
								if (fun.getCpf().equals(func.getCpf())) {
									cont++;
								}
								if (cont >= 2) {
									throw new DependenteException("Dependente: " + func.getNome()+ " \neste cpf ja foi cadastrado em nosso sistema");
								}
							}
						} // FIM DO WHILE MAIOR
						
						for (Funcionario func : listaFuncionario) {
							System.out.println(func.getNome());
							System.out.printf("Salario Bruto: %.2f", func.getSalarioBruto());
							System.out.printf("\nDisconto INSS: %.2f", func.getDescontoINSS());
							System.out.printf("\nDisconto IR: %.2f", func.getDescontoIR());
							System.out.printf("\nSalario Liq: %.2f", func.getSalarioLiquido());
							System.out.println(func.getListaDependente());
						}
					} 
					break;
					
				}catch (FileNotFoundException e) {
					e.getMessage();
				}
				
			default: System.out.println("Digite um valor valido\n");
				
			}
			
		} while (menu != 0);
		
	}
	
}