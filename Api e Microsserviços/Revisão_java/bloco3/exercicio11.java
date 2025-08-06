package bloco3;

import java.util.LinkedList;

public class exercicio11 {
   public static void main(String[] args) {
        
        LinkedList<String> fila = new LinkedList<>();
        
        fila.addLast("Ana");
        fila.addLast("Bruno");
        fila.addLast("Carlos");
        fila.addLast("Daniela");
        fila.addLast("Eduardo");
        
        System.out.println("Fila inicial: " + fila);
        
        fila.removeFirst(); // Remove Ana
        fila.removeFirst(); // Remove Bruno
        
        fila.addFirst("Patrícia (Prioritária)");
        fila.addFirst("Roberto (Prioritário)");

        System.out.println("Fila final: " + fila);
    } 
}
