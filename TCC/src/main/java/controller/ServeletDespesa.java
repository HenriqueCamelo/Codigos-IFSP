package controller;

import model.Despesa;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.DBQuery;

/**
 * Servlet implementation class ServeletDespesa
 */
@WebServlet("/ServeletDespesa")
public class ServeletDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletDespesa() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if ("cadastrardespesa".equals(acao)) {
			CadastrarDespesa(request,response);
        }
		
		if ("listaDespesas".equals(acao)) {
			InfomaçõesDespesa(request,response);
        }
		
		if ("deletarDespesa".equals(acao)) {
			DeletarDespesa(request,response);
        }
		
		if ("atualizarDespesa".equals(acao)) {
			AtualizarDespesa(request,response);
        }
		
	}
	
	private void InfomaçõesDespesa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Despesa> listaDespesas= new ArrayList<>();
		
		DBQuery query = new DBQuery("despesas","idDespesa,dataCompra, idFornecedor, endereco, cidade, bairro, CNPJCPF, valor, numeroParcelas","idDespesa");
		ResultSet rs = query.select("idDespesa > 0");
		
		try {
			while (rs != null && rs.next()){
			Despesa despesa = new Despesa();
			
			despesa.setIdDespesa(rs.getInt("idDespesa"));
			despesa.setDataCompra(rs.getDate("dataCompra"));
            despesa.setIdFornecedor(rs.getInt("idFornecedor"));
            despesa.setEndereco(rs.getString("endereco"));
			despesa.setCidade(rs.getString("cidade"));
			despesa.setBairro(rs.getString("bairro"));
			despesa.setCNPJCPF(rs.getDouble("CNPJCPF"));
			despesa.setValor(rs.getDouble("valor"));
			despesa.setNumeroParcelas(rs.getInt("numeroParcelas"));
			

			listaDespesas.add(despesa);
			
			}
			if (rs != null) {
	            rs.close();
	        }
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		String json = new Gson().toJson(listaDespesas);
        response.getWriter().write(json);

		}
	
	private void CadastrarDespesa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idDespesa = "";
		
		String dataCompraDes = request.getParameter("dataCompraDes");
		
		String fornecedorDes = request.getParameter("fornecedorDes");
		
		String enderecoDes = request.getParameter("enderecoDes");
		
		String cidadeDes = request.getParameter("cidadeDes");
		
		String bairroDes = request.getParameter("bairroDes");
		
		String CPFDes = request.getParameter("CPFCNPJDes");
		
		String valorDes = request.getParameter("valorDes");
		
		String numParcelasDes = request.getParameter("numParcelasDes");
		
		
		DBQuery query = new DBQuery("despesas","dataCompra,idFornecedor,endereco,cidade,bairro,CNPJCPF,valor,numeroParcelas","idDespesa");

		String[] novadespesa = {
				dataCompraDes,
				fornecedorDes,
				enderecoDes,
				cidadeDes,
				bairroDes,
				CPFDes,
				valorDes,
				numParcelasDes
			};	
			
		query.insert(novadespesa);
		
		DBQuery querydes = new DBQuery("despesas","idDespesa","idDespesa");
		
		ResultSet rs1 = querydes.select("idDespesa =(SELECT MAX(idDespesa) FROM despesas)");
			
		try {
			if (rs1 != null && rs1.next()) {
				idDespesa = rs1.getString("idDespesa");
			}
			if (rs1 != null) {
			    rs1.close();
			}
		
		} catch (SQLException e) {
            e.printStackTrace();
        }
		DBQuery queryfordes = new DBQuery("fornecedorDespesa","idFornecedor,idDespesa","idFornecedorDespesa");
		
		String[] novafordespesa = {
				fornecedorDes,
				idDespesa
			};
		
		queryfordes.insert(novafordespesa);
		response.sendRedirect("./View/Despesas.jsp");
	}

	
	private void DeletarDespesa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idDespesaStr = request.getParameter("id");
		int idDespesa = Integer.parseInt(idDespesaStr);
		
		DBQuery dbQueryFornDes = new DBQuery("fornecedordespesa", "idFornecedorDespesa, idDespesa", "idFornecedorDespesa");
		ResultSet rs1 = dbQueryFornDes.select("idDespesa = " + idDespesa);
		
		String idFornecedorDespesa = "";
		
		try {
			if (rs1 != null && rs1.next()) {
		        idFornecedorDespesa = rs1.getString("idFornecedorDespesa");
		    }
	
		    if (rs1 != null) {
		        rs1.close();
		    }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		    
		String [] deletarForneDespesa = {
				idFornecedorDespesa,
				idDespesaStr
		};
		
		dbQueryFornDes.delete(deletarForneDespesa);
		
		DBQuery dbQueryDes = new DBQuery("despesas", "idDespesa", "idDespesa");
		ResultSet rs2 = dbQueryDes.select("idDespesa = " + idDespesa);
		
		String [] deletarDespesa = {
			idDespesaStr
		};
		
		dbQueryDes.delete(deletarDespesa);
		response.sendRedirect("./View/informacoesDespesa.jsp");
	}
	
	private void AtualizarDespesa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idDespesaStr = request.getParameter("idDespesa");
	    int idDespesa = Integer.parseInt(idDespesaStr);
		
		String dataCompraDes = request.getParameter("dataCompra");
		
		String fornecedorDes = request.getParameter("idFornecedor");
		
		String enderecoDes = request.getParameter("endereco");
		
		String cidadeDes = request.getParameter("cidade");
		
		String bairroDes = request.getParameter("bairro");
		
		String CPFDes = request.getParameter("CPF");
		
		String valorDes = request.getParameter("valor");
		
		String numParcelasDes = request.getParameter("numParcelas");
			
		DBQuery query = new DBQuery("despesas","idDespesa,dataCompra, idFornecedor, endereco, cidade, bairro, CNPJCPF, valor, numeroParcelas","idDespesa");
		
		String[] atualizardespesa = {
				idDespesaStr,
				dataCompraDes,
				fornecedorDes,
				enderecoDes,
				cidadeDes,
				bairroDes,
				CPFDes,
				valorDes,
				numParcelasDes,
			};	
			
		query.update(atualizardespesa);
		
		DBQuery query3 = new DBQuery("fornecedordespesa","idFornecedorDespesa, idFornecedor,idDespesa","idFornecedorDespesa");
		
		ResultSet rs = query3.select("idDespesa = " + idDespesa);
		
		String idFornecedorDespesa = "";
		
		try {
		    if (rs != null && rs.next()) {
		        idFornecedorDespesa = rs.getString("idFornecedorDespesa");
		    }
	
		    if (rs != null) {
		        rs.close();
		    }	
		    
		} catch (SQLException e) {
            e.printStackTrace();
        }   
		String[] atualizarfornecedordespesa = {
				idFornecedorDespesa,
				fornecedorDes,
				idDespesaStr
			};	
		
		query3.update(atualizarfornecedordespesa);
		response.sendRedirect("./View/informacoesDespesa.jsp");
	}

	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
