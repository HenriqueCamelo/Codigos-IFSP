package bloco5;

import java.util.LinkedHashMap;
import java.util.Map;

public class exercicio21 {
    
    public static void main(String[] args) {
        LinkedHashMap <String, Double> produtos = new LinkedHashMap <String, Double>();

        produtos.put("Mamao", (double )7);
        produtos.put("Maca", (double )8);
        produtos.put("Pera", (double )9);
        produtos.put("Banana", (double )10);
        produtos.put("Uvas", (double )7);

        for (Map.Entry<String, Double> i : produtos.entrySet()) {
            System.out.println(i);
        }
    }
}
