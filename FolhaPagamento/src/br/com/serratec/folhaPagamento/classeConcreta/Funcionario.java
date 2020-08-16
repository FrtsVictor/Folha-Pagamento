package br.com.serratec.folhaPagamento.classeConcreta;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.serratec.folhaPagamento.exceptions.DependenteException;

public final class Funcionario extends Pessoa  {

	private String rg;
	private double salarioBruto;
	private double descontoINSS;
	private double descontoIR;
	private double salarioLiquido;
	private List<Dependente> listaDependente = new ArrayList<Dependente>();
	

	public Funcionario(String nome, String cpf, String rg, LocalDate dataNascimento, double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.rg = rg;
		super.verificarTamCpf();
	}	
	
	public String getRg() {
		return rg;
	}
	
	public double getSalarioBruto() {
		return salarioBruto;
	}

	public double getDescontoINSS() {
		return descontoINSS;
	}
	
	public double getDescontoIR() {
		return descontoIR;
	}
	
	public double getSalarioLiquido() {
		return salarioLiquido;
	}
	
	public List<Dependente> getListaDependente() {
		return listaDependente;
	}
	
	public void listarDependentes() {
		for (Dependente dependente : listaDependente) {
			System.out.println(dependente.toString());
		}
	}
	
	final public void adicionarDependente(Dependente dependente) {
		this.validarCPFDependente(dependente.getCpf());
		listaDependente.add(dependente);
	}
	
	private void validarCPFDependente(String cpf) {
		this.listaDependente.forEach((Dependente dependente) -> {
			Boolean CPFInvalido = dependente.getCpf().equals(cpf);

			if (CPFInvalido) {
				throw new DependenteException("Este cpf ja foi cadastrado em nosso sistema dependente: " + dependente.getNome());
			}
		});
	}

	final public void verificarCpfRepetidoFuncionario(List<Funcionario> listaF ){
		for (Funcionario fun : listaF) {
			int cont = 0;
			for (Funcionario func : listaF) {
				if (fun.getCpf().equals(func.getCpf())) {
					cont++;
				}
				if (cont >= 2) {
					throw new DependenteException("Dependente: " + func.getNome()+ " \neste cpf ja foi cadastrado em nosso sistema");
				}
			}
		}
	}
	
	
	
	public LocalDate mostrarData() {
		return dataNascimento;
	}

	@Override
	public String toString() {
		return "Nome funcionario:		" + nome + "\n" + 
				"Cpf:		                " + cpf + 
				"\nRG:       	                " + rg + 
				"\nData de nascimento:	        " + dataNascimento +
				"\nSalario bruto:  	        " + new DecimalFormat("####.##").format(salarioBruto) +
				"\nDesconto INSS:                  " + new DecimalFormat("####.##").format(descontoINSS) +
				"\nDesconto Imposto Renda:         "+ new DecimalFormat("####.##").format(descontoIR) +
				"\nSalario liquido:                "+ new DecimalFormat("####.##").format(salarioLiquido) +
				"\nDependentes:                    " + listaDependente;
	}

	public void setDescontoINSS(double descontoINSS) {
		this.descontoINSS = descontoINSS;
	}

	public void setDescontoIR(double descontoIR) {
		this.descontoIR = descontoIR;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
}
