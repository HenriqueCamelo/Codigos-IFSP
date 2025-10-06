package controller;

import database.DBQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Usando o DBQuery para consultar o banco de dados
        DBQuery dbQuery = new DBQuery("usuarios", "idUsuario, nome, email, senha, tipo", "idUsuario");
        
        // Montando a consulta WHERE para buscar o usuário
        String whereClause = "email = '" + email + "' AND senha = '" + senha + "'";
        
        ResultSet rs = dbQuery.select(whereClause);

        try {
            if (rs != null && rs.next()) {
                // Se o usuário foi encontrado, significa que a autenticação foi bem-sucedida
                int idUsuario = rs.getInt("idUsuario");
                String nome = rs.getString("nome");

                // Armazenando informações do usuário na sessão
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", idUsuario);
                session.setAttribute("nome", nome);
                
                // Redirecionando para o dashboard ou página principal
                response.sendRedirect("./View/MenuPrincipal.jsp");
            } else {
                // Se não encontrou o usuário ou as credenciais estão erradas, redireciona de volta para o login
                response.sendRedirect("./View/Login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("./View/Login.jsp");
        }
    }
}
