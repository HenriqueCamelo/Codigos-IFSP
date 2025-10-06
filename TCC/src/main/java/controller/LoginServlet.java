package controller;

import database.DBQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    // Método que responde à requisição GET (exibe o formulário de login)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    // Método que processa a requisição POST (realiza o login)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
    	String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String nomeFazenda = request.getParameter("nomefazenda");
        String cargo = request.getParameter("cargo");

        // Usando o DBQuery para consultar o banco de dados
        DBQuery dbQuery = new DBQuery("usuarios", "idUsuario, nome, email, senha, fazenda, tipo", "idUsuario");

        // Montando a consulta WHERE para buscar o usuário
        String whereClause = "email = '" + email + "' AND senha = '" + senha + "'";
        
        ResultSet rs = dbQuery.select(whereClause);

        try {
            if (rs != null && rs.next()) {
                // Se o usuário foi encontrado, significa que a autenticação foi bem-sucedida
                int idUsuario = rs.getInt("idUsuario");
                String nomeUsuario = rs.getString("nome");
                int tipo = rs.getInt("tipo"); // Obtendo o tipo do usuário
                String nomeFazenda2 = rs.getString("fazenda");
                
                // Armazenando informações do usuário na sessão
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", idUsuario);
                session.setAttribute("nome", nomeUsuario);
                session.setAttribute("tipoUsuario", tipo); // Armazenando o tipo de usuário
                session.setAttribute("nomeFazenda", nomeFazenda2);
                //System.out.println("\nNome da Fazenda armazenado na sessão: " + nomeFazenda2);
                
                // Redirecionando para o menu principal
                response.sendRedirect("./View/MenuPrincipal.jsp");
            } else {
                // Caso o login falhe, vamos cadastrar o novo usuário
                DBQuery insertQuery = new DBQuery("usuarios", 
                    "nome, email, senha, fazenda, tipo", "idUsuario");

                // Alterando a lógica para definir o tipo de usuário com base no cargo
                int tipoUsuario = "Dono".equalsIgnoreCase(cargo) ? 1 : 0;

                // Preparando os dados para a inserção
                String[] novoUsuario = {
                    nome,
                    email,
                    senha,
                    nomeFazenda,
                    String.valueOf(tipoUsuario)
                };
                
                if(nomeFazenda != null) {
                	
                	// Função de inserção que vai chamar a query de inserção no banco
                    insertQuery.insert(novoUsuario);

                    // Redirecionando para o login com sucesso
                    response.sendRedirect("./View/Login.jsp?status=sucesso");
                }else {
                	response.sendRedirect("./View/Login.jsp?status=erro");
                }
                
                // Função de inserção que vai chamar a query de inserção no banco
                //insertQuery.insert(novoUsuario);

                // Redirecionando para o login com sucesso
                //response.sendRedirect("./View/Login.jsp?status=sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("./View/Login.jsp?status=erro");
        }
        }catch (Exception e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao acessar/cadastrar login");
	    }
    }

    


}
