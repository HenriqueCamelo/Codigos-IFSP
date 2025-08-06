package bloco4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class exercicio13 {
    public static void main(String[] args) {
        int n = 15;
        int numerosAleatorios;

        ArrayList<Integer> a = new ArrayList<>();
        HashSet<Integer> b = new HashSet<>();

        for(int i = 0; i < n; i++){
            numerosAleatorios = (int)(Math.random() * 10);
            a.add(numerosAleatorios);
        }
        
        Collections.sort(a);
        System.out.println("\nNumeros aleatórios antes da remoção de duplicatas: \n" + a);

        for(Integer numero : a){
            b.add(numero);
            
        }
		
		System.out.println("Numeros aleatórios depois da remoção de duplicatas: \n" + b);
    }
}
