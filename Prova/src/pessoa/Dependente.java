package provinha.src.pessoa;

import java.time.LocalDate;
import java.time.Period;

import provinha.src.enumm.Parentesco;
import provinha.src.exception.DependenteException;

public final class Dependente extends Pessoa {

    private Parentesco parentesco;
    private final LocalDate diaAtual = LocalDate.now();
    private int idade;

    public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
        super(nome, cpf, dataNascimento);
        this.parentesco = parentesco;
        this.idade = Period.between(super.dataNascimento, this.diaAtual).getYears();
        this.verificarIdade();
        
    }
    
    public void verificarIdade() {
        if (this.idade > 18) {
            System.out.println(idade+" anos de idade");
            throw new DependenteException("Você ultrapassou a idade limite");
        }
    }
        
}
