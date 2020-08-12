import java.util.Scanner;

public class ExemploDelimitador {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner ("Gol,Hb20,Fiesta,Sandero,Onix,Siena");

        sc.useDelimiter("\\d,0");
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
        sc.close();
    }

    
}