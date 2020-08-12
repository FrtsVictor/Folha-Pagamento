package carros;

public class TesteCastingObjetos {
    public static void main(String[] args) {
        
  //  Veiculo v1 = new Caminhao("ABC-5498", "Scania");
    Object obj = new Veiculo("Vw", "Furgao");
    
    Veiculo v2 = (Veiculo)obj;
    
   // Veiculo v3 = new Caminhao("KLC", "Mercedes");
  //  Caminhao c1 = (Caminhao) v3;

    VeiculoPasseio vp = (VeiculoPasseio) obj;
    
    System.out.println(vp.getClass());
    v2.getPlaca();




    }
}