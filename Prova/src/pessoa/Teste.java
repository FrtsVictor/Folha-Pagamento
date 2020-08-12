package pessoa;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import enumm.Parentesco;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class Teste {

    public static void main(String[] args) {

        // Dependente dp1 = new Dependente("Victor", "cpf", LocalDate.of(2000, 01, 01),
        // Parentesco.FILHO);

        // Set<Dependente> dependentes = new HashSet<Dependente>();
        // dependentes.add(new Dependente("Victor", "cpf", LocalDate.of(2000, 01, 01),
        // Parentesco.FILHO));
        // dependentes.add(new Dependente("nome", "cpf", LocalDate.of(2000, 01, 01),
        // Parentesco.FILHO));
        
        //String arquivo;
        String diretorio;
        String diretorioFixed;

        //_________
        Scanner fileInput = new Scanner(System.in); // Inicia o Scanner
        System.out.println("Diretorio?"); // Pedindo diretório pro usuario
        diretorio = fileInput.nextLine(); // Jogando o caminho do diretório para a variável diretório
                
        
        diretorioFixed = diretorio.replace("\"" , "\\");  //concerta o diretório em relação as ""



        // FileInputStream arq = new FileInputStream("C:\\Estudos\\Java_VSC\\aula11\\arquivo.dat");
            // DataInputStream lerArq = new DataInputStream(arq);
            // String resultado = lerArq.readLine();
            // System.out.println(resultado);
            
        String aq;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            BufferedReader arquivoEntrada = new BufferedReader(new FileReader(diretorioFixed)); 
            
            //LISTA DE FUNCIONARIOS
            List <Funcionario> listaFuncionario = new ArrayList<Funcionario>();
            
            //C:\AAAA\Prova\src\enumm\tabela.csv
            
            while(arquivoEntrada.ready()){
            String leitura  = arquivoEntrada.readLine();
            String[] pessoa = leitura.split(";");
            System.out.println(leitura.length());
           
           
            
            if(leitura.length() > 0 ){                    
                Funcionario funcionario = new Funcionario(pessoa[0], pessoa[1], LocalDate.parse(pessoa[2], formatter), Double.parseDouble(pessoa[3]));
                listaFuncionario.add(funcionario);
                
                if(pessoa[3] == "OUTROS" || pessoa[3] == "FILHO" || pessoa[3] == "SOBRINHO"){
                    Dependente depenten = new Dependente(pessoa[0], pessoa[1], LocalDate.parse(pessoa[2] formatter), );

                    funcionario.adicionarDependente(depenten);

                }
            }
                
                
            }
        
                
                for (Funcionario funcionario : listaFuncionario) {
                    System.out.println(funcionario);
                }       
            
            
            
            //CONSTRUTOR FUNCIONARIO
            
            

    
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      
    }

}