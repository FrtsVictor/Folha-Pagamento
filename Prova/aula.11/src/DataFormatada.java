import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class DataFormatada {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a data");
        String dataFormatada = in.next();
        in.close();

        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyy");
        DateTimeFormatter dataSaida = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate dataLd = LocalDate.parse(dataFormatada,data);
        System.out.println(dataLd.format(dataSaida));

        System.err.println("oi");

    }
    
}