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
		
		if ("cadastrarfuncionario".equals(acao)) {
			CadastrarFuncionario(request,response);
        }
		
		if ("listaFuncionario".equals(acao)) {
			InfomaçõesFuncionario(request,response);
        }
		
		
		 if ("deletarFuncionario".equals(acao)) {
		 DeletarFuncionario(request,response); 
		 }
		 
		 if ("atualizarFuncionario".equals(acao)) {
		 AtualizarFuncionario(request,response); 
		 }
		 
		
	}
	
	private void CadastrarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nomeFuncionario = request.getParameter("nomeFuncionario");
		String sexoFuncionario = request.getParameter("sexoFuncionario");
		String nascFuncionario = request.getParameter("nascFuncionario");
		String cpfFuncionario = request.getParameter("cpfFuncionario");
		String bancoFuncionario = request.getParameter("bancoFuncionario");
		String telFuncionario = request.getParameter("telFuncionario");
		
		DBQuery query = new DBQuery("funcionario","nomefun,sexo,dataNascimento,CPF,banco,telefone","idFuncionario");

		String[] novofunc = {
				nomeFuncionario,
				sexoFuncionario,
				nascFuncionario,
				cpfFuncionario,
				bancoFuncionario,
				telFuncionario
			};
		query.insert(novofunc);
		
		response.sendRedirect("./View/CadastrarFuncionario.jsp");
	}
	
	private void InfomaçõesFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Funcionario> listaFuncionario= new ArrayList<>();
		
		DBQuery query = new DBQuery("funcionario","idFuncionario,nomefun,sexo,dataNascimento,CPF,banco,telefone","idFuncionario");
		ResultSet rs = query.select("idFuncionario > 0");
		
		try {
			while (rs != null && rs.next()){
			
			Funcionario funcionario = new Funcionario();
			
			funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
			funcionario.setNomefun(rs.getString("nomefun"));
            funcionario.setSexo(rs.getString("sexo"));
            funcionario.setDataNascimento(rs.getDate("dataNascimento"));
			funcionario.setCPF(rs.getInt("CPF"));  
			funcionario.setBanco(rs.getInt("banco"));
			funcionario.setTelefone(rs.getInt("telefone"));
			System.out.println(funcionario.getDataNascimento());
			
			listaFuncionario.add(funcionario);
			
			}
			if (rs != null) {
	            rs.close();
	        }
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		String json = new Gson().toJson(listaFuncionario);
        response.getWriter().write(json);
	}

	private void DeletarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idFuncStr = request.getParameter("id");
		int idFuncionario = Integer.parseInt(idFuncStr);
		
		DBQuery dbQuery = new DBQuery("funcionario", "idFuncionario", "idFuncionario");
		ResultSet rs = dbQuery.select("idFuncionario = " + idFuncionario);
		
		String [] deletarFuncionario = {
				idFuncStr
		};
		
		dbQuery.delete(deletarFuncionario);
		response.sendRedirect("./View/informacoesFuncionario.jsp");
	}

	private void AtualizarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idFuncStr = request.getParameter("idFuncionario");
		int idFuncionario = Integer.parseInt(idFuncStr);
		
		String nomefun = request.getParameter("nomefun");
		String sexo = request.getParameter("sexo");
		String dataNascimento = request.getParameter("dataNascimento");
		String CPF = request.getParameter("CPF");
		String banco = request.getParameter("banco");
		String telefone = request.getParameter("telefone");
		
		DBQuery query = new DBQuery("funcionario","idFuncionario,nomefun,sexo,dataNascimento,CPF,banco,telefone","idFuncionario");
		
		String[] atualizarfunc = {
				idFuncStr,
				nomefun,
				sexo,
				dataNascimento,
				CPF,
				banco,
				telefone
			};
		query.update(atualizarfunc);
		
		response.sendRedirect("./View/CadastrarFuncionario.jsp");
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
