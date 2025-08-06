package bloco5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio20 {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> agenda = new HashMap<>();

        int opcao;

        do {
            System.out.println("\n--- AGENDA DE CONTATOS ---");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Buscar telefone por nome");
            System.out.println("3. Listar todos os contatos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir o '\n'

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();

                    agenda.put(nome, telefone);
                    System.out.println("Contato adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome para buscar: ");
                    String buscaNome = scanner.nextLine();
                    if (agenda.containsKey(buscaNome)) {
                        System.out.println("Telefone de " + buscaNome + ": " + agenda.get(buscaNome));
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vazia.");
                    } else {
                        System.out.println("Contatos na agenda:");
                        for (Map.Entry<String, String> contato : agenda.entrySet()) {
                            System.out.println(contato.getKey() + " - " + contato.getValue());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Encerrando a agenda...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
