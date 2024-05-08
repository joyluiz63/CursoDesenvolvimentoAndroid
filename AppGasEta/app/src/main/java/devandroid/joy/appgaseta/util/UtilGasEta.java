package devandroid.joy.appgaseta.util;

public class UtilGasEta {

   /* public void naoEstatico() {
        // Para utilizar um metodo não estatico, a classe tem que ser
        // instanciada primeiro
    }

    public static String Estatico(){
        // Para utilizar um metodo estatico, não precisa instancia a classe
        return "Mensagem de teste";
    }*/

    public static String calcularMelhorOpcao(double gasolina, double etanol){
        double melhorPreco = gasolina * 0.70;
        String melhorOpcao;

        if (etanol <= melhorPreco){
            melhorOpcao = "Abastecer com Etanol!";
        } else {
            melhorOpcao = "Abastecer com Gasolina!";
        }

        return melhorOpcao;
    }
}
