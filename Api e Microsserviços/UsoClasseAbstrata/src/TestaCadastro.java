
public class TestaCadastro {
	public static void main(String[] args) {
CadastroPessoas cadastro = new CadastroPessoas();
        
        Cliente cliente = new Cliente("Carlos", new Data(10, 5, 1985), 1234);
        Funcionario funcionario = new Funcionario("Mariana", new Data(15, 7, 1990), 5000f);
        Gerente gerente = new Gerente("Roberto", new Data(20, 8, 1980), 10000f, "TI");
        
        cadastro.cadastraPessoa(cliente);
        cadastro.cadastraPessoa(funcionario);
        cadastro.cadastraPessoa(gerente);
        
        cadastro.imprimeCadastro();
	}
}
