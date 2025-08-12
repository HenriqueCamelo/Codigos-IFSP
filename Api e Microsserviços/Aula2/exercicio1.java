import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class exercicio1 {
    public static class Produto{
        private String nome;
        private double preco;
        private String categoria;
        public Produto(String nome, double preco, String categoria){
            this.nome = nome;
            this.preco = preco;
            this.categoria = categoria;
        };
        public String getNome(){return nome;}
        public void setNome(String nome){ this.nome = nome;}
        public double getPreco(){return preco;}
        public void setPreco(double preco){ this.preco = preco;}
        public String getCategoria(){return categoria;}
        public void setCategoria(String categoria){ this.categoria = categoria;}
        @Override public String toString() { return "Produto{nome=" + nome + ", preco='" + preco + "', categoria='" + categoria + "'}"; }
    }

    //d. Escreva um método buscarProdutoPorNome(List<Produto> produtos, String nome) que retorna um Optional<Produto>. Use a Stream API (filter e findFirst).
    public static void buscarProdutoPorNome(List<Produto> produtos, String nome){
        Optional<Produto> produtosBuscadoPorNome = produtos.stream()
            .filter(p -> p.getNome().equals(nome))
            .findFirst();

        if (produtosBuscadoPorNome.isPresent()) {
            System.out.println("Produto encontrado :"+produtosBuscadoPorNome.get());
        }
        else {
            produtosBuscadoPorNome.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        }
    }

    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();
        
        listaProdutos.add(new Produto("Monitor", 500, "Eletrônico"));
        listaProdutos.add(new Produto("PCGamer", 3500, "Eletrônico"));
        listaProdutos.add(new Produto("Mouse", 50, "Eletrônico"));
        listaProdutos.add(new Produto("MousePad", 500, "Eletrônico"));
        listaProdutos.add(new Produto("Don Quixote", 30, "Livros"));
        listaProdutos.add(new Produto("Odisseya", 60, "Livros"));
        listaProdutos.add(new Produto("Metamorfose", 40, "Livros"));
        listaProdutos.add(new Produto("Sherlock Holmes", 100, "Livros"));

        //a
        List<String> nomesProdutosEletronicos1 = new ArrayList<>();
        for (Produto produto : listaProdutos) {
            if (produto.getCategoria().equals("Eletrônico")) {
                nomesProdutosEletronicos1.add(produto.getNome());
            }
        }
        System.out.println("Lista 1: " + nomesProdutosEletronicos1);

        List<String> nomesProdutosEletronicos2 = listaProdutos.stream()
            .filter(p -> p.getCategoria().equals("Eletrônico"))
            .map(p -> p.getNome())
            .collect(Collectors.toList());
        System.out.println("Lista 2: " +nomesProdutosEletronicos2);

        //b
        List<String> nomesProdutosCaros = listaProdutos.stream()
            .filter(p -> p.getPreco() > 500)
            .map(p -> p.getNome())
            .collect(Collectors.toList());
        System.out.println("Lista com produtos acima de 500: " +nomesProdutosCaros);

        //c
        Double valorTotaldosLivros = listaProdutos.stream()
            .filter(p -> p.getCategoria().equals("Livros"))
            .mapToDouble(p -> p.getPreco())
            .sum();
        System.out.println("Valor total do estoque de produtos da categoria \"Livros\": " + valorTotaldosLivros);

        //d
        buscarProdutoPorNome(listaProdutos,"Monitor");

        //e
        //buscarProdutoPorNome(listaProdutos, "Geladeira");

        //f
        List<String> nomesProdutos = listaProdutos.stream()
            .map(p -> p.getNome())
            .collect(Collectors.toList());
        System.out.println("Lista com nomes usando p -> p.getNome() : " +nomesProdutos);

        List<String> nomesProdutos2 = listaProdutos.stream()
            .map(Produto::getNome)
            .collect(Collectors.toList());
        System.out.println("Lista com nomes usando Produto::getNome : " +nomesProdutos2);
    }
}
