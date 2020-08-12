import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ExemploMainBinarioLeitura {

    public static void main(String[] args) {

        try {
            FileInputStream arq = new FileInputStream("C:\\AAAA\\Prova\\src\\enumm\\ex1.dat");
            DataInputStream lerArq = new DataInputStream(arq);
            String resultado = lerArq.readLine();
            System.out.println(resultado);
            lerArq.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao acessar arquivo");
            
        }
        

    }

    
}