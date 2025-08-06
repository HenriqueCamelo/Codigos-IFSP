package bloco6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> pilhaLivros = new ArrayDeque<>();

        System.out.println("Digite o nome de 3 livros para empilhar:");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Livro " + i + ": ");
            String livro = scanner.nextLine();
            pilhaLivros.push(livro);  
        }

        System.out.println("\nPilha atual: " + pilhaLivros);

        String removido = pilhaLivros.pop();
        System.out.println("\nLivro removido (desempilhado): " + removido);

        String topo = pilhaLivros.peek();
        System.out.println("Livro no topo da pilha agora: " + topo);

        System.out.println("\nPilha atual após operações: " + pilhaLivros);

        scanner.close();
    }
}
