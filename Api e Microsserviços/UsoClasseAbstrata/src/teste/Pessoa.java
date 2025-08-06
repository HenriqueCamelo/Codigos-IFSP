package teste;
import org.eclipse.jface.text.templates.GlobalTemplateVariables.Date;

public abstract class Pessoa {
	String nome;
	Data nascimento;
	
	public Pessoa() {
		
	}
	
	public abstract void imprimeDados();
		
	
}
