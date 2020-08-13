package provinha.src.pessoa;

import java.time.LocalDate;

import provinha.src.exception.CPFException;


public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected LocalDate dataNascimento;
    
    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
 
    		
	public void verificarTamCpf(){
        if (this.cpf.length() != 11){
            throw new CPFException("Pessoa " + nome + " de cpf " + this.cpf + " possui um CPF invalido");
        }
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
    
    

//    @Override
//    public String toString() {
//        return "Pessoa cpf = " + cpf + ", dataNascimento = " + dataNascimento + ", nome = " + nome;
//    }
//       
    
}