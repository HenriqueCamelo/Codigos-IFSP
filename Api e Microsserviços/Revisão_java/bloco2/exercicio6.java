package bloco2;

public class exercicio6 {
        private static class Circulo{
        private Double Raio;

        public Double getRaio() {
		    return Raio;
	    }

        public void setRaio(Double Raio) {
            if (Raio < 0.0) {
                throw new IllegalArgumentException("O raio deve ser positivo");
            }

            this.Raio = Raio;
        }

        public void calcularArea(){
            Double raioCalculo = this.Raio;
            Double resultado;
            final double PI = 3.14159;

            resultado = PI * Math.pow(raioCalculo, 2);
            System.out.println("\nA area do ciculo é: "+ resultado);

        } 
    }

    public static void main(String[] args){
        Circulo circulo = new Circulo();
        circulo.setRaio((double) 3);
        circulo.calcularArea();
    }
}
