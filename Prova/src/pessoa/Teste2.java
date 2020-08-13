package provinha.src.pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import provinha.src.enumm.Parentesco;

public class Teste2 {
    public static void main(String[] args) {
        
   
        String enumm = "Parentesco.";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        
        String[] pessoa = {"Nome", "15265959", "20200809" , "OUTROS" };
        
        String enumConcat = enumm.concat(pessoa[3]);
               

        Dependente depen = new Dependente(pessoa[0], pessoa[1], LocalDate.parse(pessoa[2], formatter), Parentesco.valueOf(pessoa[3]));

        System.out.println(enumConcat);


    }
    
}