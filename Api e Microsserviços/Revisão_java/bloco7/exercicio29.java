package bloco7;

import java.util.LinkedList;

public class exercicio29 {
    private final LinkedList<String> visitas = new LinkedList<>();
    private int pos = -1;

    public void visitar(String url) {
        while (visitas.size() - 1 > pos) {
            visitas.removeLast();
        }
        visitas.add(url);
        pos = visitas.size() - 1;
        System.out.println("Visitado: " + url);
    }

    public void voltar() {
        if (pos > 0) {
            pos--;
            System.out.println("Voltando para: " + visitas.get(pos));
        } else {
            System.out.println("Sem página anterior.");
        }
    }

    public void avancar() {
        if (pos < visitas.size() - 1) {
            pos++;
            System.out.println("Avançando para: " + visitas.get(pos));
        } else {
            System.out.println("Sem página à frente.");
        }
    }

    public static void main(String[] args) {
        Historico h = new Historico();
        h.visitar("google.com");
        h.visitar("openai.com");
        h.voltar();
        h.avancar();
    }
}
