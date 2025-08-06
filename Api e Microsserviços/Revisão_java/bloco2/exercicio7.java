package bloco2;

public class exercicio7 {
    public static class Veiculo{
        public String Marca;
        public String Modelo;

        public Veiculo(String Marca, String Modelo){
            this.Marca = Marca;
            this.Modelo = Modelo;
        }

    }

    public static class Carro extends Veiculo{
        public int numeroDePortas;

        public Carro(String Marca, String Modelo, int numeroDePortas) {
            super(Marca, Modelo);
            this.numeroDePortas = numeroDePortas;
        }

        @Override
	    public String toString() {
	        return "\n\nCarro [Marca: " + Marca +  ", Modelo: " + Modelo + ", Numero de portas: " + numeroDePortas + "]";
	    }
    }

    public static class Moto extends Veiculo{
        public int cilindradas;

        public Moto(String Marca, String Modelo, int cilindradas) {
            super(Marca, Modelo);
            this.cilindradas = cilindradas;
        }

        @Override
	    public String toString() {
	        return "Moto [Marca: " + Marca +  ", Modelo: " + Modelo + ", Cilindradas: " + cilindradas + "]\n\n";
	    }
    }

    public static void main(String[] args){
        Veiculo[] automotivos = new Veiculo[2];
        automotivos[0] = new Carro("Ronda", "Civic", 4);
        automotivos[1] = new Moto("Kawasaki", "Honda", 7);

        System.out.println("Processando");

            for (Veiculo veiculo : automotivos) {
            
            System.out.println(veiculo);
        }

    }

}
