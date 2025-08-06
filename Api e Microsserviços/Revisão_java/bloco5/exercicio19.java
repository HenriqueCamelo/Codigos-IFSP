package bloco5;

import java.util.HashMap;
import java.util.Map;

public class exercicio19 {
     public static void main(String[] args) {
        String texto = "Java é uma linguagem de programação. Java é usada para desenvolver aplicativos. " +
                       "A linguagem Java é poderosa, segura e popular.";

        // Convertendo tudo para minúsculas e removendo pontuação
        texto = texto.toLowerCase().replaceAll("[^a-zà-ú0-9 ]", "");

        // Separando palavras por espaço
        String[] palavras = texto.split("\\s+");

        // Mapa para contar a frequência
        Map<String, Integer> contador = new HashMap<>();

        for (String palavra : palavras) {
            // Se a palavra já existe no mapa, incrementa, senão começa com 1
            contador.put(palavra, contador.getOrDefault(palavra, 0) + 1);
        }

        // Exibindo os resultados
        System.out.println("Frequência de palavras:");
        for (Map.Entry<String, Integer> entrada : contador.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
