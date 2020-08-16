package br.com.serratec.folhaPagamento.classeConcreta;

import br.com.serratec.folhaPagamento.interfaces.CalcularImpostoRenda;

public final class Calculos implements CalcularImpostoRenda {


    private Funcionario funcionario;
	private double descontoINSS;
	private double descontoIR;
	private double salarioLiquido;
	
	
    public void calcularINSS() {
		double salarioBruto = funcionario.getSalarioBruto();
		if (salarioBruto <= 1751.81) {
			descontoINSS = salarioBruto * 0.08;

		} else if (salarioBruto >= 1751.82 && salarioBruto <= 2919.72) {
			descontoINSS = salarioBruto * 0.09;

		} else if (salarioBruto >= 2919.73 && salarioBruto <= 5839.45) {
			descontoINSS = salarioBruto * 0.11;

		} else if (salarioBruto >= 5839.45) {
			descontoINSS = 5839.45 * 0.11;
		}
		funcionario.setDescontoINSS(descontoINSS);
    }

    
    public void calcularImpostoRenda() {
        this.calcularINSS();

		descontoIR = funcionario.getSalarioBruto() - descontoINSS - valorPorDependente * funcionario.getListaDependente().size();

		if (descontoIR >= 4664.68) {
			descontoIR = descontoIR * 0.275 - 869.36;

		} else if (descontoIR >= 3751.06) {
			descontoIR = descontoIR * 0.225 - 636.13;

		} else if (descontoIR >= 2826.66) {
			descontoIR = descontoIR * 0.15 - 354.80;

		} else if (descontoIR >= 1903.98) {
			descontoIR = descontoIR * 0.075 - 142.80;

		} else {
			descontoIR = 0;
		}
		funcionario.setDescontoIR(descontoIR);
		this.calcularSalarioLiquido();
		funcionario.setSalarioLiquido(salarioLiquido);
        
	}

	public double calcularSalarioLiquido() {
		return salarioLiquido = funcionario.getSalarioBruto() - descontoINSS - descontoIR;
	}

    public Calculos(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

	@Override
	public String toString() {
		return "Calculos descontoINSS = " + descontoINSS + ", descontoIR = " + descontoIR +  ", salarioBruto = " + funcionario.getSalarioBruto() + ", salarioLiquido = " + salarioLiquido;
	}

    }
    
