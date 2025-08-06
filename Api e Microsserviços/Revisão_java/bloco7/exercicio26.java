package bloco7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exercicio26 {
    
    public static class Produtos{
        private String nome;
        private Double preco;

        public Produtos(){

        }

        public Produtos(String nome, Double preco){
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return this.nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return this.preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

    }
    
    

    public static void main(String[] args) {
        Map<String, List<Produtos>> loja = new HashMap<>();
        List<Produtos> eletronico = new ArrayList<>();
        List<Produtos> moda = new ArrayList<>();


        eletronico.add(new Produtos("Computador", 200.0));
        eletronico.add(new Produtos("PC", 100.0));
        eletronico.add(new Produtos("Monitor", 250.0));
        moda.add(new Produtos("Esmalte", 20.0));
        moda.add(new Produtos("Delineador", 50.0));

        loja.put("Eletrônico", eletronico);
        loja.put("Moda", moda);

        for (Map.Entry<String, List<Produtos>> i : loja.entrySet()) {
            System.out.println("Categoria: " + i.getKey());
            for (Produtos p : i.getValue()) {
                System.out.println("  - " + p.getNome() + ": R$" + p.getPreco());
            }
        }
    }
}
