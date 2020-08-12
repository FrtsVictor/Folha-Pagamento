import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ExemploBuferedWriter
 */
public class ExemploBuferedWriter {

    public static void main(String[] args) {
        try {
            //grava em um arquivo texto, caso o arquivo nao existe, cria automaticamente o caminho especificado
            //no caminho do construtor da classe FileWriter
            BufferedWriter bf = new BufferedWriter(new FileWriter("C:\\Estudos\\Java_VSC\\aula11\\ex3.txt"));
            bf.append("Olá"); //funciona tipo put
            bf.write("\r\nstr");
            bf.close();
            System.out.println("Arquivo criado e texto inserido!");
        } catch (IOException e) {
            System.out.println("Erro ao acesar arquivo");
        }
    }
}