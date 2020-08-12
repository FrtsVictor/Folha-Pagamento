import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ExercicioDelimitador
 */
public class ExercicioDelimitador {
    public static void main(String[] args) {

        try{
        BufferedReader bf = new BufferedReader(new FileReader(("C:\\Estudos\\Java_VSC\\aula11\\arquivo2.txt")));
        System.out.println(bf.readLine());
        //String linha = bf.readLine();
       //System.out.println(linha);
        //String[] palavras = linha.split("-");
        // for (String s: palavras){
        //     System.out.println(s + " ");
        // }
        bf.close();
    }catch (IOException e){
        System.out.println("Erro ao acessar o arquivo");
    } 
    }
    

}