import java.util.Scanner;

public class Bloco1 {
    
    //Exercício 1
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite sua 1 nota:");
        int nota1 = leitor.nextInt();

        System.out.print("Digite sua 2 nota:");
        int nota2 = leitor.nextInt();

        System.out.print("Digite sua 3 nota:");
        int nota3 = leitor.nextInt();

        int media = (nota1 + nota2 + nota3)/3;

        System.out.printf("Sua nota final é %d \n", media);


        if (media >= 7 ) {
            System.out.printf("Aprovado");
        } else  if(media >= 5 && media >= 5){
            System.out.printf("Recuperação");
        } else{
            System.out.printf("Reprovado");
        }

        leitor.close();
    }

}