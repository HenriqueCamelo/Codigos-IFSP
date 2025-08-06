import java.util.ArrayList;

public class CadastroPessoas {
	Integer qtdAtual;
	ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public void cadastraPessoa(Pessoa p) {
		pessoas.add(p);
	}
	
	public void imprimeCadastro() {
		for(Pessoa p: pessoas) {
			p.imprimeDados();
		}
		
	}
}
