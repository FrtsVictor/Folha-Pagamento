import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ExemploBufferedReader {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Estudos\\Java_VSC\\aula11\\ex1.txt"));
            int quantidadeLinhas = 0;
            while(br.ready()){
                String linhas = br.readLine();
              //  System.out.printf(br.readLine());
                quantidadeLinhas += linhas.length();
                System.out.println(linhas);
               // System.out.println(linhas.length());            
            }
        System.out.println("Total de caracteres no arquivo: " + quantidadeLinhas);
        } catch (IOException e) {
            System.out.println("Erro ao acesar arquivo");
            e.printStackTrace();
        }

    }
    
}
