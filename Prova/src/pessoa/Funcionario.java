package provinha.src.pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import provinha.src.exception.DependenteException;
import provinha.src.interfaces.CalcularImpostoRenda;

public class Funcionario extends Pessoa implements CalcularImpostoRenda {
    
    private String rg;
    private double salarioBruto;
    private double descontoINSS; 
    private double descontoIR;
    private double deducao;
    private List<Dependente> listaDependente = new ArrayList<Dependente>();
    
    
    public Funcionario(String nome, String cpf, String rg, LocalDate dataNascimento, double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
        this.rg = rg;
    }


    public void listarDependentes(){
        for (Dependente dp : listaDependente) {
            System.out.println(dp.toString());
        }
    }


    
    public void adicionarDependente(Dependente dp) {
        this.verificarTamCpf();
        this.verificarCpfRepetido();
        listaDependente.add(dp);    
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


	public double getDeducao() {
		return deducao;
	}


	public List<Dependente> getListaDependente() {
		return listaDependente;
	}


	public void verificarTamCpf(){
        if (this.cpf.length() !=11){
            throw new DependenteException("Dependente: " + this.cpf + " possui um CPF inválido você digitou um cpf");
        }
    }



    public void verificarCpfRepetido() {
        for (Dependente ld : listaDependente) {
            for(Dependente dp: listaDependente){
                if(dp.getCpf().equals(ld.getCpf())){
                    throw new DependenteException("Dependente: " + dp.getNome()+ " \neste cpf ja foi cadastrado em nosso sistema");
                }
            }

        }
    }




    @Override
    public void calcularINSS() {
        
        if (salarioBruto <= 1751.81) {
            descontoINSS = salarioBruto * 0.08;
        } else if (descontoINSS >= 1751.82) {
            descontoINSS = salarioBruto * 0.09;
        } else if (descontoINSS >= 2919.73) {
            descontoINSS = salarioBruto * 0.11;
        }
        

    }



    @Override
    public void calcularImpostoRenda() {

        descontoIR = salarioBruto - descontoINSS; // -valor por dependente

        if (descontoIR <= 1903.98) {
            descontoIR = 0;

        } else if (descontoIR >= 2826.65) {
            deducao = 142.80;
            descontoIR *= 0.075 - deducao;

        } else if (descontoIR >= 3751.05) {
            deducao = 354.80;
            descontoIR *= 0.15 - deducao;

        } else if (descontoIR >= 4664.68) {
            deducao = 636.13;
            descontoIR *= 0.225 - deducao;

        } else {
            deducao = 869.36;
            descontoIR *= 0.275 - deducao;
        }
    
                  
        


        
          
    }

    @Override
    public String toString() {
        return "Funcionario " + nome + " Cpf " + cpf + " dataNascimento " + dataNascimento + " salario bruto " + salarioBruto;
    }

 

 
    }
    
