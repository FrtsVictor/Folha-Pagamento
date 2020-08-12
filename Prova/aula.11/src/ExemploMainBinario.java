import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExemploMainBinario {

    public static void main(String[] args) {

        
        try {
            FileOutputStream arq = new FileOutputStream("C:\\Estudos\\Java_VSC\\aula11\\arquivo3.txt");
            DataOutputStream gravarArq = new DataOutputStream(arq);
            gravarArq.writeChars("Bom dia");
            gravarArq.close();                    
        }catch (IOException e) {
            System.out.println("Erro ao acessar arquivo");
        
        }
    }
}
    
