package carros;

public class Veiculo {

protected String placa;    
protected String modelo;

public Veiculo(String placa, String modelo) {
    this.placa = placa;
    this.modelo = modelo;
}

@Override//sobrescrevendo equals para gerar um equals mais parruddo.
public boolean equals(Object outro) {
    if(!(outro instanceof VeiculoPasseio)){
        return false;
    }else{
        VeiculoPasseio vp = (VeiculoPasseio) outro;
        return this.modelo == vp.modelo && this.placa == vp.placa;
    }
}

public String getPlaca() {
    return placa;
}

public String getModelo() {
    return modelo;
}

@Override
public String toString() {
    return "Veiculo modelo = " + modelo + ", placa = " + placa;
}

public static void main(String[] args) {
    

    double cont = 189.56;
   
    for (int i = 0; i <= 10; i++) {
       System.out.println(i * cont); 
        
    }

}



}