package bloco2;

public class exercicio8 {
    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }
    
    public static class ContaBancaria{
        private String titular;
        private Double saldo;

        public ContaBancaria(String titular, Double saldo){
            this.titular = titular;
            this.saldo = saldo;
        }

        public void despositar(Double valor){
            this.saldo = valor + saldo;
        }

        public boolean sacar(Double valor) throws SaldoInsuficienteException{
            if(valor > saldo){
                throw new SaldoInsuficienteException("Saldo insuficiente para sacar R$" + valor);
            }                
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " foi realizado com êxito.");
            return true;
        }

        public Double getSaldo(){
            return saldo;
        }
    }

    public static void main(String[] args){
        ContaBancaria conta = new ContaBancaria(" Jonas", (double)200);
        try {
            conta.despositar((double)500);
            conta.sacar((double)800);
            
        } catch (Exception e) {
            System.out.println("Erro para o procedimento de saque: "+ e.getMessage());
        }

        System.out.println("Saldo atual de: R$" + conta.getSaldo());
    }
}
