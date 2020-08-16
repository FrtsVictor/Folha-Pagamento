package br.com.serratec.folhaPagamento.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.serratec.folhaPagamento.classeConcreta.Dependente;
import br.com.serratec.folhaPagamento.enums.Parentesco;


public class teste {

    public static void main(String[] args) {
        
        Dependente dp = new Dependente("nome", "cpf", LocalDate.now(), Parentesco.FILHO);
        
   
        List<String> minhalista = new ArrayList<String>();
        minhalista.add("Victor");

        System.out.println(minhalista.contains("Victor"));


    }
    
}