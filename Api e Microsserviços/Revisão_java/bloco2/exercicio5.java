package bloco2;

public class exercicio5 {
    public static class Carro{
        public String Marca;
        public String Modelo;
        public int Ano;

        public Carro(String Marca, String Modelo, int Ano){
            this.Marca = Marca;
            this.Modelo = Modelo;
            this.Ano = Ano;
        }

        public void exibirNome(){
            System.out.println("\nMarca: "+ this.Marca);
            System.out.println("Modelo: "+ this.Modelo);
            System.out.println("Ano: "+ this.Ano);
        }
    }

    public static void main(String[] args){
        Carro carro = new Carro("Volkswagen", "Gol", 2005);
        carro.exibirNome();
    }
}