package bloco3;

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio12 {
    public static void main(String[] args) {
        
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("Acre");
        lista.add("Fortaleza");
        lista.add("Goiais");
        lista.add("Tocantins");
        lista.add("Palmas");
        
        Scanner myCidade = new Scanner(System.in);  
        System.out.println("Insira uma cidade que pode estar na lista: ");
        String IndiceCidade = myCidade.nextLine();

        
                if (lista.contains(IndiceCidade)) {
                    int indiceCidade= lista.indexOf(IndiceCidade);
                    System.out.println("Cidade encontrada no indice "+ indiceCidade);
                }
                System.out.println();
            

        System.out.println("Fila final: " + lista);
    } 
}
