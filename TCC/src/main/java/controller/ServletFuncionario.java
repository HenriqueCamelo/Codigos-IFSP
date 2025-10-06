package controller;

import java.io.IOException;
import java.net.URLEncoder;
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
import model.Funcionario;

/**
 * Servlet implementation class ServletFuncionario
 */
@WebServlet("/ServletFuncionario")
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFuncionario() {
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
            if ("cadastrarfuncionario".equals(acao)) {
                CadastrarFuncionario(request, response);
            } else if ("listaFuncionario".equals(acao)) {
                InfomacoesFuncionario(request, response);
            } else if ("deletarFuncionario".equals(acao)) {
                DeletarFuncionario(request, response);
            } else if ("atualizarFuncionario".equals(acao)) {
                AtualizarFuncionario(request, response);
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

    private void CadastrarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nomeFuncionario = request.getParameter("nomeFuncionario");
            String sexoFuncionario = request.getParameter("sexoFuncionario");
            String fazendaFuncionario = request.getParameter("fazendaFuncionario");
            String nascFuncionario = request.getParameter("nascFuncionario");
            String cpfFuncionario = request.getParameter("cpfFuncionario");
            String bancoFuncionario = request.getParameter("bancoFuncionario");
            String telFuncionario = request.getParameter("telFuncionario");

            DBQuery query = new DBQuery("funcionario", "nomefun,sexo,fazenda,dataNascimento,CPF,banco,telefone", "idFuncionario");

            String[] novofunc = {nomeFuncionario, sexoFuncionario,fazendaFuncionario, nascFuncionario, cpfFuncionario, bancoFuncionario, telFuncionario};
            query.insert(novofunc);

            response.sendRedirect("./View/MenuFuncionarios.jsp?status=sucesso");
        } catch (Exception e) {
	        e.printStackTrace();

	        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
	        String erro = URLEncoder.encode("Erro ao cadastrar funcionario. Verifique as informações inseridas nos campos.", "UTF-8");

	        // Redireciona para a página de erro com status e mensagem
	        response.sendRedirect(request.getContextPath() + "/View/MenuFuncionarios.jsp?status=erro&msg=" + erro);
	    }
    }

    private void InfomacoesFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
        	System.out.println("Método doPost foi chamado!");
	        HttpSession session = request.getSession();
	        String fazenda = (String) session.getAttribute("nomeFazenda");
	        System.out.println(fazenda + " no menu de funcionarios.");
        	
        	List<Funcionario> listaFuncionario = new ArrayList<>();
            DBQuery query = new DBQuery("funcionario", "idFuncionario,nomefun,sexo,fazenda,dataNascimento,CPF,banco,telefone", "idFuncionario");
            ResultSet rs = query.select("idFuncionario > 0 AND fazenda =" + "'"+fazenda+"'");

            while (rs != null && rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomefun(rs.getString("nomefun"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setFazenda(rs.getString("fazenda"));
                funcionario.setDataNascimento(rs.getDate("dataNascimento"));
                funcionario.setCPF(rs.getFloat("CPF"));
                funcionario.setBanco(rs.getFloat("banco"));
                funcionario.setTelefone(rs.getFloat("telefone"));
                listaFuncionario.add(funcionario);
            }
            if (rs != null) rs.close();

            String json = new Gson().toJson(listaFuncionario);
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar funcionários.");
        }
    }

    private void DeletarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String idFuncStr = request.getParameter("id");
            int idFuncionario = Integer.parseInt(idFuncStr);

            DBQuery dbQuery = new DBQuery("funcionario", "idFuncionario", "idFuncionario");
            String[] deletarFuncionario = {idFuncStr};
            dbQuery.delete(deletarFuncionario);

            response.sendRedirect("./View/informacoesFunc.jsp");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        } catch (Exception e) {
	        e.printStackTrace();

	        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
	        String erro = URLEncoder.encode("Erro ao Deletar funcionario. Verifique as informações inseridas nos campos.", "UTF-8");

	        // Redireciona para a página de erro com status e mensagem
	        response.sendRedirect(request.getContextPath() + "/View/MenuFuncionarios.jsp?status=erro&msg=" + erro);
	    }
    }

    private void AtualizarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String idFuncStr = request.getParameter("idFuncionario");
            int idFuncionario = Integer.parseInt(idFuncStr);
            String nomefun = request.getParameter("nomefun");
            String sexo = request.getParameter("sexo");
            String fazenda = request.getParameter("fazenda");
            String dataNascimento = request.getParameter("dataNascimento");
            String CPF = request.getParameter("CPF");
            String banco = request.getParameter("banco");
            String telefone = request.getParameter("telefone");

            DBQuery query = new DBQuery("funcionario", "idFuncionario,nomefun,sexo,fazenda,dataNascimento,CPF,banco,telefone", "idFuncionario");
            String[] atualizarfunc = {idFuncStr, nomefun, sexo, fazenda,dataNascimento, CPF, banco, telefone};
            query.update(atualizarfunc);

            response.sendRedirect("./View/MenuFuncionarios.jsp?status=sucesso");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        } catch (Exception e) {
	        e.printStackTrace();

	        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
	        String erro = URLEncoder.encode("Erro ao Atualizar funcionario. Verifique as informações inseridas nos campos.", "UTF-8");

	        // Redireciona para a página de erro com status e mensagem
	        response.sendRedirect(request.getContextPath() + "/View/MenuFuncionarios.jsp?status=erro&msg=" + erro);
	    }
    }


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
