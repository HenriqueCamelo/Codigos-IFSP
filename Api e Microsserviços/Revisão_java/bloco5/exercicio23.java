package bloco5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> agenda = new HashMap<>();

        // Adicionando alguns contatos para teste
        agenda.put("Ana", "9999-1111");
        agenda.put("Bruno", "8888-2222");
        agenda.put("Carlos", "7777-3333");

        System.out.print("Digite um nome para verificar se já existe na agenda: ");
        String nomeBusca = scanner.nextLine();

        if (agenda.containsKey(nomeBusca)) {
            System.out.println("O nome \"" + nomeBusca + "\" já está na agenda com o telefone: " + agenda.get(nomeBusca));
        } else {
            System.out.println("O nome \"" + nomeBusca + "\" NÃO está na agenda.");
        }

        System.out.print("\nDigite um telefone para verificar se já está cadastrado: ");
        String telefoneBusca = scanner.nextLine();

        if (agenda.containsValue(telefoneBusca)) {
            System.out.println("O telefone \"" + telefoneBusca + "\" já está cadastrado na agenda.");
        } else {
            System.out.println("O telefone \"" + telefoneBusca + "\" NÃO está na agenda.");
        }

        scanner.close();
    }
}
