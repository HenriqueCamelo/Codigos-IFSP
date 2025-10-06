package database;

public class DBtest {
	public static void main(String[] args) {
		
	       try
	       {  
				DBConnection conexao = new DBConnection();
				System.out.println("Conexão com o banco do ttc esta ok");
				
	       }
			catch (Exception e)	
			{	
				System.out.println("Conexão com o banco do ttc esta não ok");
			}
			      
						
		}

}
