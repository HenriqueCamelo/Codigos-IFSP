package bloco3;

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio9 {
        public static class ListaTarefa{
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();

        public void adicionarTarefa(Tarefa tarefa){
            listaTarefas.add(tarefa);
        }

        public void exibirTarefa(){
            for (Tarefa Tarefas : listaTarefas) {
            
                System.out.println(Tarefas);
            }
        }

        public void deletarTarefaLista(){
            Scanner myIndiceDel = new Scanner(System.in);  
            System.out.println("Insira o indice da tarefa que desja deletar: ");
            Integer IndiceDel = myIndiceDel.nextInt();
            deletarTarefa(IndiceDel);
        }

        public void deletarTarefa(int indice){
            for (Tarefa Tarefas : listaTarefas) {
                if(Tarefas.getIndice() == indice){
                    listaTarefas.remove(Tarefas);
                }
                    System.out.println(Tarefas+" removida.");
            }
        }
    }

    public static class Tarefa{
        private int indice;
        private String conteudo;

        public int getIndice() {
		    return indice;
	    }

        public void setIndice(int indice) {
            this.indice = indice;
        }

        public String getConteudo() {
		    return conteudo;
	    }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        public Tarefa (){
            
        }

        public Tarefa (int indice, String conteudo){
            this.indice = indice;
            this.conteudo = conteudo;
        }

        public Tarefa criarTarefa() {
            Scanner myIndice = new Scanner(System.in);  
            System.out.println("Insira o indice da tarefa: ");
            Integer Indice = myIndice.nextInt();  
            
            
            Scanner myConteud = new Scanner(System.in);  
            System.out.println("Insira o conteudo da tarefa: ");
            String Conteudo = myConteud.nextLine();
            
            Tarefa tarefa = new Tarefa(Indice, Conteudo);
         
            return tarefa;
        }

        @Override
	    public String toString() {
	        return "\nTarefa " + indice +  ":[ conteúdo: " + conteudo + "]";
	    }
    }

    public static void Menu(ListaTarefa listaTarefas) {
		
		String escolha = "";
		
		System.out.print("\nBem vindo a sua agenda de tarefas");
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.print("\nDejesa: 1 - Adicionar Tarefa; 2 - Ver Todas as tarefas; 3 - Deletar Tarefa \n");
		escolha = myObj.nextLine();  // Read user input
		
		
		switch (escolha) {
	    case "1": 
	    	System.out.println("Adicionar tarefa");
            Tarefa tarefa = new Tarefa();
            listaTarefas.adicionarTarefa(tarefa.criarTarefa());
	    	Menu(listaTarefas);
	    	break;
	    case "2": 
	    	System.out.println("Ver Tarefas");
	    	listaTarefas.exibirTarefa();
	    	Menu(listaTarefas); 
	    	break;
        case "3": 
	    	System.out.println("Deletar Tarefa");
	    	listaTarefas.exibirTarefa();
            listaTarefas.deletarTarefaLista();
	    	Menu(listaTarefas); 
	    	break;
	    
	    default: System.out.println("Escolha inválido"); break;
	    }
	}
    

    public static void main(String[] args) {
        ListaTarefa lista = new ListaTarefa();
        Menu(lista);
        
    }
    
}

