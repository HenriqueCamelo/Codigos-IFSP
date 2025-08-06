import java.util.Arrays;
import java.util.List;

public class exercicio4 {
    public static void main(String[] args){
    Integer somaDeImpares=0;

        List<Integer> numeros = Arrays.asList(1 , 2, 3, 4, 5, 6, 7, 8, 9);

        for(Integer numero : numeros){
            if( numero % 2 != 0){
                System.out.println(numero);
                somaDeImpares += numero;
            }
            
        }
        System.out.println("A soma de impares é "+ somaDeImpares);
    }
}