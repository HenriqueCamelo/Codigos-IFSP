package bloco5;

import java.util.HashMap;
import java.util.Scanner;

public class exercicio18 {
    public static void main(String[] args) {
    
    HashMap<String, String> palavrasTraducoes = new HashMap<String, String>();

        palavrasTraducoes.put("carro", "car");
        palavrasTraducoes.put("bola", "ball");
        palavrasTraducoes.put("frio", "cold");
        palavrasTraducoes.put("quente", "hot");
        palavrasTraducoes.put("computador", "computer");

        System.out.print("Digite uma palacra que pode ou não ter tradução: ");
		
		Scanner myObj = new Scanner(System.in);  
		String palavra = myObj.nextLine();
        
        
        if(palavrasTraducoes.containsKey(palavra)){
            System.out.println(palavrasTraducoes.get(palavra));
        }else{
            System.out.println("Essa palavra não tem tradução");
        }
        
  }
}
