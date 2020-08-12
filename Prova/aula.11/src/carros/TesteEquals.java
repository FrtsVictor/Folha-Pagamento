package carros;

public class TesteEquals {
    public static void main(String[] args) {
        Veiculo v1 = new VeiculoPasseio("placa", "modelo");
        Veiculo v2 = new VeiculoPasseio("placa", "modelo");
        

        if(!v1.equals(v2)){
            System.out.println("Diferentes");
        }else{
            System.out.println("Iguais");
        }

        if(v1.getPlaca().equals(v2.getPlaca())){
            System.out.println("Iguais");
        }
    
    }
}