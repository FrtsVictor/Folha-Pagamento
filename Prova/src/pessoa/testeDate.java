package pessoa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class testeDate {

        LocalDate birthDate = LocalDate.of(1994, 12, 10);
        LocalDate currentDate = LocalDate.now();
        
    
        public testeDate(LocalDate birthDate, LocalDate currentDate) {
            this.birthDate = birthDate;
            this.currentDate = currentDate;
        }


       public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
           return Period.between(birthDate, currentDate).getYears();
       }

       public static void main(String[] args) {

           LocalDate dataAtual = LocalDate.now();
           LocalDate dataNascimento = LocalDate.of(1994, 03, 17);

           DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyy");
           DateTimeFormatter dataSaida = DateTimeFormatter.ofPattern("yyyy/MM/dd");

           testeDate td = new testeDate(dataNascimento, dataAtual);

           int idade = calculateAge(dataNascimento, dataAtual);
            System.out.println(idade);
      

    }


}