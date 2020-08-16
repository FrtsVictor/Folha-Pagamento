package br.com.serratec.folhaPagamento.interfaces;

/**
 * CalcularImpostoRenda
 */
public interface CalcularImpostoRenda extends CalcularINSS {
    double valorPorDependente = 189.59;
    
    void calcularImpostoRenda();
    
}