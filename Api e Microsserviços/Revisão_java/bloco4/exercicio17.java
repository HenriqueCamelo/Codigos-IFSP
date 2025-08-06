package bloco4;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class exercicio17 {
    
    public static class Produto implements Comparable<Produto>{
        
        TreeSet<Produto> listaProdutos = new TreeSet<>();
        private String nome;
        private Double preco;

        public Produto(){
            
        }

        public Produto(String nome, Double preco){
            this.nome = nome;
            this.preco = preco;
        }

        public void exibição(){
            for (Produto produto : listaProdutos) {
                System.out.println(produto);
            }
        }

        @Override
	    public String toString() {
	        return "Produto [Nome: " + nome +  ", Preço: " + preco + "]\n\n";
	    }
        

        @Override
        public int compareTo(Produto outro) {
            return Double.compare(this.preco, outro.preco);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Produto)) return false;
            Produto produto = (Produto) o;
            return Double.compare(produto.preco, preco) == 0 &&
                Objects.equals(nome, produto.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, preco);
        }

    
        
    }
    
    public static void main(String[] args) {
        Set<Produto> produtos = new TreeSet<>();

        produtos.add(new Produto("Teclado", 120.0));
        produtos.add(new Produto("Mouse", 70.0));
        produtos.add(new Produto("Monitor", 800.0));
        produtos.add(new Produto("Cadeira Gamer", 1500.0));
        produtos.add(new Produto("Mousepad", 50.0));

        System.out.println("Produtos ordenados por preço (crescente):");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
