package provinha.src.pessoa;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import provinha.src.enumm.Parentesco;

public class Teste_copy {

    public static void main(String[] args) {
        //C:\AAAA\Prova\src\enumm\tabela.csv
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
       
        String diretorio;
        String diretorioFixed;
      //  Scanner fileInput = new Scanner(System.in); // Inicia o Scanner
       // System.out.println("Diretorio?"); // Pedindo diretório pro usuario
       // diretorio = fileInput.nextLine(); // Jogando o caminho do diretório para a variável diretório              
       // diretorioFixed = diretorio.replace("\"" , "\\");  //concerta o diretório em relação as ""
     
        
        File arquivoEntrada = new File("C:\\AAAA\\Prova\\src\\enumm\\tabela.csv");
        
        
        List <Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        
        Funcionario funcionario = null; 
        try {
            Scanner entrada = new Scanner(arquivoEntrada);
            
            while (entrada.hasNextLine()) {       
                
                String[] pessoa = entrada.nextLine().split(";");
                   
                	while(!entrada.nextLine().isEmpty()) {
                		
                    if(pessoa.length == 5 ){
                        funcionario = new Funcionario(pessoa[0], pessoa[1], pessoa[2], LocalDate.parse(pessoa[3], formatter), Double.parseDouble(pessoa[4]));
                        listaFuncionario.add(funcionario);
                    }else if(pessoa.length == 4) {
                        Dependente dependente = new Dependente(pessoa[0], pessoa[1], LocalDate.parse(pessoa[2], formatter), Parentesco.valueOf(pessoa[3]));
                        funcionario.adicionarDependente(dependente);
                        funcionario.listarDependentes();
                    }
                }     

                for (Funcionario func : listaFuncionario) {
                    System.out.println(func);
                }
                funcionario.listarDependentes();
            }          
                
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
 } }
    

