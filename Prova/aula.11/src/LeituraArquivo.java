import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraArquivo {
    public static void main(String[] args) {
        File arquivo = new File ("C:\\Estudos\\Java_VSC\\aula11\\ex1.txt");
        try{
            Scanner sc = new Scanner(arquivo);
            while(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }


    
    }

    
}