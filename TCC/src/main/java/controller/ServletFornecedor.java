package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import database.DBQuery;
import model.Fornecedor;
import model.Vacina;

/**
 * Servlet implementation class ServletFuncionario
 */
@WebServlet("/ServletFornecedor")
public class ServletFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFornecedor() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        try {
            if ("cadastrarFornecedor".equals(acao)) {
                CadastrarFornecedor(request, response);
            } else if ("deletarFornecedor".equals(acao)) {
                DeletarFornecedor(request, response);
            } else if ("formFornecedor".equals(acao)) {
                FormFornecedor(request, response);
            } else {
                throw new IllegalArgumentException("Ação inválida: " + acao);
            }
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.");
        }
    }

    private void CadastrarFornecedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nomeFornecedor = request.getParameter("nomeForn");
            String cnpj = request.getParameter("CNPJ");
            

            DBQuery query = new DBQuery("fornecedor", "nomeforn,CNPJ", "idFornecedor");

            String[] novoforn = {nomeFornecedor, cnpj};
            query.insert(novoforn);

            response.sendRedirect("./View/CadastrarFuncionario.jsp?status=sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao cadastrar fornecedor.");
        }
    }

    

    private void DeletarFornecedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String idFuncStr = request.getParameter("id");
            int idFuncionario = Integer.parseInt(idFuncStr);

            DBQuery dbQuery = new DBQuery("funcionario", "idFuncionario", "idFuncionario");
            String[] DeletarFornecedor = {idFuncStr};
            dbQuery.delete(DeletarFornecedor);

            response.sendRedirect("./View/informacoesFunc.jsp");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao deletar funcionário.");
        }
    }

    private void FormFornecedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 try {
			 	List<Fornecedor> listaFornecedor = new ArrayList<>();
			 
			 	DBQuery query = new DBQuery("fornecedor", "idFornecedor,nomeforn", "idFornecedor");
		        ResultSet rs = query.select("idFornecedor > 0");

		        while (rs != null && rs.next()) {
		            Fornecedor fornecedor = new Fornecedor();
		            fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
		            fornecedor.setNomeFornecedor(rs.getString("nomeforn"));
		            listaFornecedor.add(fornecedor);
		        }

		        if (rs != null) rs.close();
		        String json = new Gson().toJson(listaFornecedor);
		        response.setContentType("application/json");
		        response.getWriter().write(json);
		    } catch (SQLException | NumberFormatException e) {
		        e.printStackTrace();
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao obter fornecedores");
		    }
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}