import java.util.Scanner;


public class exercicio3 {
    
    public static void main(String[] args){
    int numeroAleatorio = (int)(Math.random() * 101);;
    int contador = 0;
    int numeroChute = 0;

    Scanner leitor = new Scanner(System.in);

    
    while (numeroChute != numeroAleatorio) {
        System.out.print("\n\nChute um numero: ");
        numeroChute = leitor.nextInt();
        contador++;

        if(numeroChute > numeroAleatorio){
            System.out.print("Chute um numero menor");
        } else if(numeroChute < numeroAleatorio){
            System.out.print("Chute um numero maior");
        }
    }

    System.out.print("Voce acertou\n");
    System.out.print("Voce acertou depois de "+contador+" tentativas.");

    leitor.close();
    }
}
