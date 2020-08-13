package provinha.src.pessoa;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ranges.RangeException;

import provinha.src.enumm.Parentesco;
import provinha.src.exception.DataException;
import provinha.src.exception.DependenteException;

public class Teste_copy  {

	public static void main(String[] args) {
        //C:\AAAA\Prova\src\enumm\tabela.csv
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
       
        String diretorio;
        String diretorioFixed;

        File arquivoEntrada = new File("C:\\Users\\residencia17\\Desktop\\tabela.csv");
        
        
        List <Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        
        Funcionario funcionario = null; 
        try {
            Scanner entrada = new Scanner(arquivoEntrada);
            
            while (entrada.hasNextLine()) {       
                
            			
            	while(!entrada.equals(1) && entrada.hasNext()) {
            		String[] pessoa = entrada.nextLine().split(";"); 		
                    if(pessoa.length == 5 ){
                    		funcionario = new Funcionario(pessoa[0], pessoa[1], pessoa[2], LocalDate.parse(pessoa[3], formatter), Double.parseDouble(pessoa[4]));
                    		listaFuncionario.add(funcionario);
                    }else if(pessoa.length == 4) {
                        Dependente dependente = new Dependente(pessoa[0], pessoa[1], LocalDate.parse(pessoa[2], formatter), Parentesco.valueOf(pessoa[3]));
                        funcionario.adicionarDependente(dependente);
                    }
                    
                    funcionario.calcularImpostoRenda();
                    funcionario.verificarCpfRepetidoDependente();
                     }//FIM DO WHILE DE DENTRO            	

            	for(Funcionario fun : listaFuncionario ) {
            		int cont = 0;
            		for(Funcionario func : listaFuncionario ) {
           				if (fun.getCpf().equals(func.getCpf())) {
            				cont++;
            				}if (cont >= 2) {
            					throw new DependenteException(
            							"Dependente: " + func.getNome() + " \neste cpf ja foi cadastrado em nosso sistema");
            				}
            			}            	         	
                }//FIM DO WHILE MAIOR
                        
            for (Funcionario func : listaFuncionario) {
            		System.out.println(func.getNome());
            		System.out.printf("Salario Bruto: %.2f", func.getSalarioBruto());
            		System.out.printf("\nDesconto INSS: %.2f", func.getDescontoINSS());
            		System.out.printf("\nData Nascimento: ", func.getDataNascimento());
            		System.out.printf("\nDesconto IR: %.2f", func.getDescontoIR());
            		System.out.printf("\nSalario Liq: %.2f", func.getSalarioLiquido());
            		System.out.println(func.getListaDependente());
            	
	           }          
            
            
            } }catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } }
               
 }
