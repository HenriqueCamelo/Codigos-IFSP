
public class Funcionario extends Pessoa{
	Float salario;
	
	public Funcionario(String nome, Data nascimento, Float salario) {
		super(nome,nascimento);
		this.salario = salario;
	}
	
	public Float calculaImposto() {
		return salario * 0.03f;
	}
	
	@Override
	public void imprimeDados(){
		System.out.println("Funcionario: " + nome + ", Salário: " + salario + "Imposto:"+ calculaImposto() +", Nascimento: " + nascimento);
	}
}
