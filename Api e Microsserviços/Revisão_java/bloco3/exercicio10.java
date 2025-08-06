package bloco3;

import java.util.ArrayList;
import java.util.Collections;

public class exercicio10 {
    public static void main(String[] args) {
        int n = 15;
        int numerosAleatorios;

        ArrayList<Integer> a = new ArrayList<>();

        for(int i = 0; i < n; i++){
            numerosAleatorios = (int)(Math.random() * 100);
            a.add(numerosAleatorios);
        }
        System.out.println("Numeros aleatórios antes da organização: \n" + a);
		Collections.sort(a);
		System.out.println("Numeros aleatórios depois da organização: \n" + a);
    }
}
