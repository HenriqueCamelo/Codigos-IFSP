package bloco4;

import java.util.TreeSet;

public class exercicio16 {
    public static void main(String[] args) {

        TreeSet<String> nomes = new TreeSet<>();
        nomes.add("Zeca");
        nomes.add("Carlos");
        nomes.add("Bianca");
        nomes.add("Eduardo");  
        nomes.add("Lauro");

        for (String nome : nomes) {
            System.out.println(nome);
        }
		
    }
}
