package provinha.src.pessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import provinha.src.enumm.Parentesco;

public class Teste {

    public static void main(String[] args) {

        String diretorio;
        String diretorioFixed;

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

            List <Funcionario> listaFuncionario = new ArrayList<Funcionario>();

            String leitura  = arquivoEntrada.readLine();
            
            Funcionario funcionario = null;
            
            while(arquivoEntrada.ready()){

                while(leitura.length() > 0 ){
                    
                    String[] pessoa = leitura.split(";");
                    
                    if(funcionario == null){
                        funcionario = new Funcionario(pessoa[0], pessoa[1], LocalDate.parse(pessoa[2], formatter), Double.parseDouble(pessoa[3]));
                        listaFuncionario.add(funcionario);
                        
                    }else if(pessoa[3] == "OUTROS"){ 
                        //String[] pessoa = leitura.split(";");
                        Dependente depenten = new Dependente(pessoa[0], pessoa[1], LocalDate.parse(pessoa[2], formatter), Parentesco.valueOf(pessoa[3]));
                        funcionario.adicionarDependente(depenten);
                        
                    }
                                         
                }

                funcionario.listarDependentes();
                
            for (Funcionario func : listaFuncionario) {
                System.out.println(func);
            }          
        
        }    
            
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }}

// while(arquivoEntrada.ready()){
// String leitura = arquivoEntrada.readLine();
// String[] pessoa = leitura.split(";");

// while((leitura.length() > 0 )){
// if(leitura.length() > 0 ){
// Funcionario funcionario = new Funcionario(pessoa[0], pessoa[1],
// LocalDate.parse(pessoa[2], formatter), Double.parseDouble(pessoa[3]));
// listaFuncionario.add(funcionario);

// // if(pessoa[3] == "OUTROS" || pessoa[3] == "FILHO" || pessoa[3] ==
// "SOBRINHO"){
// // String enumm = "Parentesco.";
// // String enumConcat = enumm.concat(pessoa[3]);

// // Dependente depenten = new Dependente(pessoa[0], pessoa[1],
// LocalDate.parse(pessoa[2] formatter), valueOf(pessoa[3]));

// // funcionario.adicionarDependente(depenten);

// }
// }

// }

// for (Funcionario funcionario : listaFuncionario) {
// System.out.println(funcionario);
// }