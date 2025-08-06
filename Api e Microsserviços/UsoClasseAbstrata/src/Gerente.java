
public class Gerente extends Funcionario{
	String area;
	
	public Gerente(String nome, Data nascimento, Float salario, String area) {
		super(nome,nascimento,salario);
		this.area = area;
	}
	
	public Float calculaImposto(){
		return salario * 0.05f;
	}
	
	@Override
	public void imprimeDados(){
		System.out.println("Gerente: " + nome + ", Área: " + area + ", Salário: " + salario + ", Imposto: " + calculaImposto() + ", Nascimento: " + nascimento);
	}
}
