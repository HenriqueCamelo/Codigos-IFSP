package bloco7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exercicio30 {
    public static class Aluno {
    String nome;
    double nota;
    Aluno(String n, double nt) { nome = n; nota = nt;}
    }
    
    public class AgruparNotas {
    public static void main(String[] args) {
        List<Aluno> lista = Arrays.asList(
            new Aluno("Ana", 8.5),
            new Aluno("Bruno", 6.0),
            new Aluno("Carla", 4.0),
            new Aluno("Daniel", 7.2),
            new Aluno("Eduarda", 5.5)
        );

        Map<String, List<Aluno>> mapa = new HashMap<>();
        for (Aluno a : lista) {
            String faixa;
            if (a.nota >= 7) {
                faixa = "Aprovados";
            } else if (a.nota >= 5) {
                faixa = "Recuperação";
            } else {
                faixa = "Reprovados";
            }
            mapa.computeIfAbsent(faixa, k -> new ArrayList<>()).add(a);
        }

        for (var entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Aluno a : entry.getValue()) {
                System.out.println("  " + a.nome + " – " + a.nota);
            }
        }
    }
}
}
