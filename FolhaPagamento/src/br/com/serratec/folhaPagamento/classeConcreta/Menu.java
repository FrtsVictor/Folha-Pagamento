package br.com.serratec.folhaPagamento.classeConcreta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.serratec.folhaPagamento.enums.Parentesco;

public class Menu {
    
    private String diretorio, diretorioFixed;
    private double salarioBruto;
    private LocalDate dataNascimento;
    private String saidaInput = new File("").getAbsolutePath().concat("\\src\\br\\com\\serratec\\folhaPagamento\\arquivos\\calcPgInput.csv");      
    private String saidaArqCSV = new File("").getAbsolutePath().concat("\\src\\br\\com\\serratec\\folhaPagamento\\arquivos\\calcPgEntradaCsv.csv");
    
    
    private Scanner dp = new Scanner(System.in);
    private Scanner entradaDiretorio = new Scanner(System.in);
    private Scanner entradaDp = new Scanner(System.in);
    
    private Scanner entradaF = new Scanner(System.in);
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private DateTimeFormatter hourMinuteSecond = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    String horario = hourMinuteSecond.format(LocalTime.now());
    private List<Funcionario> listaFuncionarioInput = new ArrayList<Funcionario>();
    
    

    public void exibirMenu(){
		System.out.println("_______Sistema para Calculo de Folha de Pagamento_______\n");
		System.out.println("1 - Para adicionar funcionarios e dependentes via console");
		System.out.println("2 - Para listar funcionarios e dependentes adicionados via console");
		System.out.println("3 - Para gravar entrada de funcionarios via console.");
		System.out.println("4 - Para adicionar e calcular funcionarios e dependentes via arquivo .csv");
		System.out.println("0 - Para sair do menu");
	}

    
    public void fecharScanners(){
        entradaF.close();
        entradaDp.close();        
    }

    //Adicionar funcionarios e dependentes via console.
    public void adicionarPessoasConsole(){
        String nome,cpf,rg, tipoDependente, dataString;
        System.out.printf("%s - Opcao 1 selecionada.\n", horario);
        System.out.println("Digite o nome do funcionario: ");
        nome = entradaF.nextLine();
        if(nome.isEmpty()){ nome = entradaF.nextLine();}     
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
        System.out.printf("\n%s - Funcionario adicionado com sucesso!!!\n\n", horario);
        System.out.println("Funcionario possui dependentes? sim/nao");        
        String resposta1 = dp.nextLine().toLowerCase();
        
        while (resposta1.equals("sim")) {
            System.out.println("Digite o nome do dependente: ");
            nome = entradaDp.nextLine();
            System.out.println("Digite o CPF do dependente. (CPFs validos possuem somente 11 digitos)");
            cpf = entradaDp.nextLine();
            System.out.println("Digite a data de nascimento do dependente (yyyy-MM-dd   2020-01-01");			
            dataString = entradaDp.nextLine();
            dataNascimento = LocalDate.parse(dataString, format);
            System.out.println("Qual o tipo de dependente? OUTROS/FILHO/SOBRINHO");
            tipoDependente = entradaDp.nextLine().toUpperCase();

            Dependente dependente = new Dependente(nome, cpf, dataNascimento, Parentesco.valueOf(tipoDependente));
            funcionario.adicionarDependente(dependente);
            funcionario.verificarCpfRepetidoDependente();
            System.out.printf("\n%s - Dependente adicionado com sucesso!!\n\n" , horario);
            System.out.println("Funcionario possui mais dependentes? sim/nao");
            resposta1 = dp.nextLine().toLowerCase();
         }    
          funcionario.calcularImpostoRenda();
        }
        
        //Listar funcionarios e dependentes adicionados manualmente.
        public void listarPessoasConsole(){
            System.out.printf("%s - Opcao 2 selecionada.\n", horario);
            System.out.println("Lista de Funcionario com seus dependentes:\n");
            for (Funcionario func : listaFuncionarioInput) {
                System.out.println(func.toString()+"\n");

            }
        }
         
        //Escrevendo saída de arquivos
        public void escreverSaida() {
            System.out.printf("Opcao 3 Selecionada \n%s - Gravando arquivos no diretorio de saida...\n", horario );
            try {
                BufferedWriter bf2 = new BufferedWriter(new FileWriter(saidaInput));
                for (Funcionario func : listaFuncionarioInput){
                        bf2.write(func.getNome() + ";" + func.getCpf() + ";" +  String.format("%.2f", func.getDescontoINSS()) + ";" + String.format("%.2f", func.getDescontoIR()) + ";" + String.format("%.2f", func.getSalarioLiquido()) +";"+ "\r\n \r\n");
                    } 
                    System.out.printf("%s - %d Funcionario(s) gravado(s) com sucesso!!!\nNome do arquivo: 'calcPgInput.csv'\nCaminho de saida: \n%s \n\n\n",horario, listaFuncionarioInput.size(), saidaInput);		
                    bf2.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }		
            }        

    public void calcularViaCSV(){
        System.out.printf("%s - Opcao 4 selecionada.\n", horario);
        System.out.println("Digite o caminho absoluto para entrada de arquivo csv");
        diretorio = entradaDiretorio.nextLine();
        System.out.printf("%s Arquivo encontrado.\n%sCalculando Imposto de Renda...\n\n",horario, horario);
        diretorioFixed = diretorio.replace("\"", "\\");
        File arquivoEntrada = new File(diretorioFixed);

        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        
        Funcionario funcionario = null;
        try {
            Scanner entradaArq = new Scanner(arquivoEntrada);
            while (entradaArq.hasNextLine()) {
                
                while (!entradaArq.equals(1) && entradaArq.hasNext()) {
                    String[] pessoa = entradaArq.nextLine().split(";");
                    if (pessoa.length == 5) {								
                        funcionario = new Funcionario(pessoa[0], pessoa[1], pessoa[2], LocalDate.parse(pessoa[3], formatter), Double.parseDouble(pessoa[4]));
                        listaFuncionarios.add(funcionario);							
                    } else if (pessoa.length == 4) {								
                        Dependente dependente = new Dependente(pessoa[0], pessoa[1],LocalDate.parse(pessoa[2], formatter), Parentesco.valueOf(pessoa[3]));
                        funcionario.adicionarDependente(dependente);
                    }

                    funcionario.calcularImpostoRenda();
                    funcionario.verificarCpfRepetidoDependente();
                } 

                funcionario.verificarCpfRepetidoFuncionario(listaFuncionarios);
                BufferedWriter bf = new BufferedWriter(new FileWriter(saidaArqCSV));
                
                for (Funcionario func : listaFuncionarios) {							
                    System.out.println(func.getNome());							
                    System.out.printf("Salario Bruto: %.2f", func.getSalarioBruto());
                    System.out.printf("\nDesconto INSS: %.2f", func.getDescontoINSS());
                    System.out.printf("\nDesconto IR: %.2f", func.getDescontoIR());
                    System.out.printf("\nSalario Liq: %.2f", func.getSalarioLiquido());
                    System.out.println(func.getListaDependente());
                    bf.write(func.getNome() + ";" + func.getCpf() + ";" +  String.format("%.2f", func.getDescontoINSS()) + ";" + String.format("%.2f", func.getDescontoIR()) + ";" + String.format("%.2f", func.getSalarioLiquido()) +";"+ "\r\n \r\n");
                }
                bf.close();				
            } 
            System.out.printf("\n\n%s - Operacao concluida!!!\n%d Funcionarios adicionados com sucesso!!!\n", horario, listaFuncionarios.size());
            System.out.printf("Nome do arquivo: 'calcPgEntradaCsv.csv'\nCaminho de saida: %s\n\n" ,saidaArqCSV);
            entradaArq.close();
        }catch (FileNotFoundException e) {
            System.out.printf("%d - Arquivo nao encontrado! Digite um diretorio valido\n\n", horario);;
        } catch (IOException e) {
            System.out.printf("%d - Erro ao criar arquivo de saída.\n\n", horario);
            e.printStackTrace();
        }

    }

}