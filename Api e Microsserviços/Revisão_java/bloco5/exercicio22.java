package bloco5;

import java.util.Map;
import java.util.TreeMap;

public class exercicio22 {
    public static void main(String[] args) {
        TreeMap <String, Double> salaDeAula = new TreeMap <String, Double>();

        salaDeAula.put("Bia", (double )7);
        salaDeAula.put("Arthur", (double )8);
        salaDeAula.put("Caio", (double )9);
        salaDeAula.put("Michele", (double )10);
        salaDeAula.put("Otavio", (double )7);

        for (Map.Entry<String, Double> i : salaDeAula.entrySet()) {
            System.out.println(i);
        }
    }
}
