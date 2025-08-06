package bloco6;

import java.util.LinkedList;
import java.util.Queue;

public class exercicio24 {
    public static void main(String[] args) {
        Queue<String> filaImpressao = new LinkedList<>();

        // Adicionando documentos à fila
        filaImpressao.add("Documento1.pdf");
        filaImpressao.add("Foto.png");
        filaImpressao.add("Relatorio.docx");
        filaImpressao.add("Planilha.xlsx");
        filaImpressao.add("Apresentacao.pptx");

        System.out.println("\nFila: " + filaImpressao);

        System.out.println("Iniciando a fila de impressão...\n");

        while (!filaImpressao.isEmpty()) {
            String documento = filaImpressao.poll();  // remove o primeiro da fila
            System.out.println("Imprimindo: " + documento);
        }

        System.out.println("\nTodos os documentos foram impressos.");

        System.out.println("Fila: " + filaImpressao);
    }
}
