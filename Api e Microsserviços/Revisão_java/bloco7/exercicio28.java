package bloco7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();
        Deque<String> pilha = new ArrayDeque<>();
        for (String palavra : frase.split("\\s+")) {
            pilha.push(palavra);
        }
        System.out.print("Frase invertida: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }
        System.out.println();
    }
}
