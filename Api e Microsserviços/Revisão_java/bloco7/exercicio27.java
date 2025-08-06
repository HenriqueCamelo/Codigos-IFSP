package bloco7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;



public class exercicio27 {
    public static void main(String[] args) {
        List<String> participantes = new ArrayList<>();
        LinkedHashSet <String> sorteio = new LinkedHashSet <>();

        participantes.add("Rodrigo");
        participantes.add("Paulo");
        participantes.add("Rodrigo");
        participantes.add("Bianca");
        participantes.add("Helena");

        System.out.println("Inscrevidos e suas apostas: "+participantes);

        for(String i: participantes){
            sorteio.add(i);
        }

        System.out.println("Nomes que serão sorteados: "+sorteio);

        List<String> sorteioFinal = new ArrayList<>(sorteio);

        Collections.shuffle(sorteioFinal);
        System.out.println("Ganhadores:");
        for (int i = 0; i < 3 && i < sorteioFinal.size(); i++) {
            System.out.println("- " + sorteioFinal.get(i));
        }
    }
}
