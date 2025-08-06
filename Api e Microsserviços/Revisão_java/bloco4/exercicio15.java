package bloco4;

import java.util.LinkedHashSet;

public class exercicio15 {
    public static void main(String[] args) {

        LinkedHashSet<String> semana = new LinkedHashSet<>();
        semana.add("Quarta");
        semana.add("Segunda");
        semana.add("Quinta");
        semana.add("Sabado");  
        semana.add("Domingo");

        for (String dia : semana) {
            System.out.println(dia);
        }
		
    }
}
