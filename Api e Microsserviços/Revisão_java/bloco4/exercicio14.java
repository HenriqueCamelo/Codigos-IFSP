package bloco4;


import java.util.HashSet;

public class exercicio14 {
    public static void main(String[] args) {

        HashSet<String> emails = new HashSet<>();
        emails.add("example.com");
        emails.add("example.com");
        emails.add("example1.com");
        emails.add("example1.com");  
        emails.add("example2.com");

		System.out.println("Emails aleatórios depois da remoção de duplicatas: \n" + emails);
        System.out.println("Tamanho da lista: \n" + emails.size());
    }
}
