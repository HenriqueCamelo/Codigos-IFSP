package controller;

import model.Animal;
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
 * Servlet implementation class ServeltAnimal
 */
@WebServlet("/ServeltAnimal")
public class ServeltAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltAnimal() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if ("cadastrarnimal".equals(acao)) {
			CadastrarAnimais(request,response);
        }
		
		if ("listaAnimais".equals(acao)) {
			InfomaçõesAnimais(request,response);
        }
		
		if ("deletarAnimais".equals(acao)) {
			DeletarAnimal(request,response);
        }
		
		if ("atualizarAnimais".equals(acao)) {
			AtualizarAnimal(request,response);
        }
		
		if ("peso".equals(acao)) {
			PesoAnimal(request,response);
        }
		
		if ("vacina".equals(acao)) {
			VacinaAnimal(request,response);
        }
		
		if ("cadastrarVacina".equals(acao)) {
			CadastrarVacina(request,response);
		}
		
		if("descarteAnimal".equals(acao)) {
			DescarteAnimal(request,response);
		}
		
		if("registroAlimentacao".equals(acao)) {
			RegistroAlimentacao(request,response);
		}
		
		if("registroOvos".equals(acao)) {
			RegistroOvos(request,response);
		}
		
	}
	
	private void CadastrarAnimais(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nomeAn = request.getParameter("nomeAn");
		
		String sexoAn = request.getParameter("sexoAn");
		
	//		Date dataNascAn = (Date) request.getSession().getAttribute("dataNascAn");
		
		String dataNascAn = request.getParameter("dataNascAn");
	
		String fotoAn = request.getParameter("fotoAn");
		
		String paiAn = request.getParameter("paiAn");
		
		String maeAn = request.getParameter("maeAn");
		
		String vendedorAn = request.getParameter("vendedorAn");
		
		String precoAn = request.getParameter("precoAn");
		
		//Date dataCompraAn = (Date) request.getSession().getAttribute("dataCompraAn");
		String dataCompraAn = request.getParameter("dataCompraAn");
		
		String dadosExtraAn = request.getParameter("dadosExtraAn");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ou outro formato desejado
		
		DBQuery query = new DBQuery("animal","nomeAnimal,sexoAnimal,dataNascimentoAnimal,foto,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra","idAnimal");
		
		String[] novoanimal = {
				nomeAn,
				sexoAn,
				dataNascAn,
				fotoAn,
				paiAn,
				maeAn,
				vendedorAn,
				precoAn,
				dataCompraAn,
				dadosExtraAn
			};
		query.insert(novoanimal);
		
		response.sendRedirect("./View/CadastroAnimais.jsp");
	}
	
	private void InfomaçõesAnimais(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		List<Animal> listaAnimais= new ArrayList<>();
		
		DBQuery query = new DBQuery("animal","idAnimal,nomeAnimal,sexoAnimal,dataNascimentoAnimal,foto,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra","idAnimal");
		ResultSet rs = query.select("idAnimal > 0");
		
		try {
			while (rs != null && rs.next()){
			Animal animal = new Animal();
			
			animal.setIdAnimal(rs.getInt("idAnimal"));
			animal.setNomeAnimal(rs.getString("nomeAnimal"));
            animal.setSexoAnimal(rs.getString("sexoAnimal"));
            animal.setPrecoAnimal(rs.getFloat("precoAnimal"));
			animal.setDataNascimentoAnimal(rs.getDate("dataNascimentoAnimal"));  
			animal.setDataCompra(rs.getDate("dataCompra"));
			animal.setPaiAnimal(rs.getString("paiAnimal"));
			animal.setMaeAnimal(rs.getString("maeAnimal"));
			animal.setVendedor(rs.getString("vendedor"));
			animal.setDadosExtra(rs.getString("dadosExtra"));
			System.out.println(animal.getDataCompra());
			// Converter Date para LocalDate
			//LocalDate localDateNascimento = dataNascimentoAnimal.toLocalDate();
			//LocalDate localDateCompra = dataCompra.toLocalDate();
			
			// Calcular a idade
			//Period periodo = Period.between(localDateNascimento, LocalDate.now());
			//int idadeAnos = periodo.getYears(); // Idade em anos
			//long idadeSemanas = ChronoUnit.WEEKS.between(localDateNascimento, LocalDate.now()); // Idade em semanas
			listaAnimais.add(animal);
			
			}
			if (rs != null) {
	            rs.close();
	        }
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		String json = new Gson().toJson(listaAnimais);
        response.getWriter().write(json);

		}
	
	private void DeletarAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idAnimalStr = request.getParameter("id");
		int idAnimal = Integer.parseInt(idAnimalStr);
		
		DBQuery dbQueryVacinaAnimal = new DBQuery("vacinaAnimal", "idVacinaAnimal, idAnimal", "idVacinaAnimal");
		ResultSet rs1 = dbQueryVacinaAnimal.select("idAnimal = " + idAnimal);
		
		String idVacinaAnimal = "";
		
		try {
			if (rs1 != null && rs1.next()) {
				idVacinaAnimal = rs1.getString("idVacinaAnimal");
		    }
	
		    if (rs1 != null) {
		        rs1.close();
		    }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		    
		String [] deletarForneDespesa = {
				idVacinaAnimal,
				idAnimalStr
		};
		
		dbQueryVacinaAnimal.delete(deletarForneDespesa);
		
		DBQuery dbQueryPeso = new DBQuery("peso", "idPeso, idAnimal", "idPeso");
		ResultSet rs2 = dbQueryPeso.select("idAnimal = " + idAnimal);
		
		String idPeso = "";
		
		try {
			if (rs2 != null && rs2.next()) {
				idPeso = rs2.getString("idPeso");
		    }
	
		    if (rs2 != null) {
		        rs2.close();
		    }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		    
		String [] deletarPeso = {
				idPeso,
				idAnimalStr
		};
		
		dbQueryPeso.delete(deletarPeso);
		
		DBQuery dbQuery = new DBQuery("animal", "idAnimal", "idAnimal");
		ResultSet rs = dbQuery.select("idAnimal = " + idAnimal);
		
		String [] deletarAnimal = {
			idAnimalStr
		};
		
		dbQuery.delete(deletarAnimal);
		response.sendRedirect("./View/informacoesAnimal.jsp");
	}

	private void AtualizarAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idAnimalStr = request.getParameter("idAnimal");
    	int idAnimal = Integer.parseInt(idAnimalStr);	
	
		String nomeAn = request.getParameter("nomeAn");
		
		String sexoAn = request.getParameter("sexoAn");
		
// 		Date dataNascAn = (Date) request.getSession().getAttribute("dataNascAn");
		
		String dataNascAn = request.getParameter("dataNascAn");

		String fotoAn = request.getParameter("fotoAn");
		
		String paiAn = request.getParameter("paiAn");
		
		String maeAn = request.getParameter("maeAn");
		
		String vendedorAn = request.getParameter("vendedorAn");
		
		String precoAn = request.getParameter("precoAn");
		
		//Date dataCompraAn = (Date) request.getSession().getAttribute("dataCompraAn");
		String dataCompraAn = request.getParameter("dataCompraAn");
		
		String dadosExtraAn = request.getParameter("dadosExtraAn");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ou outro formato desejado
		
		DBQuery query = new DBQuery("animal","idAnimal,nomeAnimal,sexoAnimal,dataNascimentoAnimal,foto,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra","idAnimal");
		
		String[] editaranimal = {
				idAnimalStr,
				nomeAn,
				sexoAn,
				dataNascAn,
				fotoAn,
				paiAn,
				maeAn,
				vendedorAn,
				precoAn,
				dataCompraAn,
				dadosExtraAn
			};
		query.update(editaranimal);	
		response.sendRedirect("./View/informacoesAnimal.jsp");
	}
	
	private void PesoAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idAn = request.getParameter("idAn");
		
		String dataPes = request.getParameter("dataPes");
		
		String pesagem = request.getParameter("pesagem");
		
		DBQuery query = new DBQuery("peso","idAnimal,dataPesagem,pesoAnimal","idPeso");
		
		String[] novapesagem = {
				idAn,
				dataPes,
				pesagem
			};	
			
		query.insert(novapesagem);
		response.sendRedirect("./View/Animais.jsp");
	}

	private void VacinaAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idAn = request.getParameter("idAn");
		
		String dataVac = request.getParameter("dataVac");
		
		String vacina = request.getParameter("vacina");
		
		DBQuery query = new DBQuery("vacinaAnimal","idAnimal,dataVacina,idVacina","idVacinaAnimal");
		
		String[] novavacina = {
				idAn,
				dataVac,
				vacina
			};	
			
		query.insert(novavacina);
		response.sendRedirect("./View/Animais.jsp");
	}

	private void CadastrarVacina(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nomeVacina = request.getParameter("nomeVacina");
		
		DBQuery query = new DBQuery("vacina","nomeVacina","idVacina");
		
		String[] novavacina = {
				nomeVacina
			};
		query.insert(novavacina);
		
		response.sendRedirect("./View/Vacinas.jsp");
	}

	private void DescarteAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idAnimal = request.getParameter("idAnimal");
		
		String dataDescAn = request.getParameter("dataDescAn");
		
		DBQuery query = new DBQuery("descarteAnimal","idAnimal,dataDescarte","idDescarteAnimal");
		
		String[] animaldescartado = {
				idAnimal,
				dataDescAn
			};
		query.insert(animaldescartado);
		
		
		DBQuery dbQueryVacinaAnimal = new DBQuery("vacinaAnimal", "idVacinaAnimal, idAnimal", "idVacinaAnimal");
		ResultSet rs1 = dbQueryVacinaAnimal.select("idAnimal = " + idAnimal);
		
		String idVacinaAnimal = "";
		
		try {
			if (rs1 != null && rs1.next()) {
				idVacinaAnimal = rs1.getString("idVacinaAnimal");
		    }
	
		    if (rs1 != null) {
		        rs1.close();
		    }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		    
		String [] deletarForneDespesa = {
				idVacinaAnimal,
				idAnimal
		};
		
		dbQueryVacinaAnimal.delete(deletarForneDespesa);
		
		DBQuery dbQueryPeso = new DBQuery("peso", "idPeso, idAnimal", "idPeso");
		ResultSet rs2 = dbQueryPeso.select("idAnimal = " + idAnimal);
		
		String idPeso = "";
		
		try {
			if (rs2 != null && rs2.next()) {
				idPeso = rs2.getString("idPeso");
		    }
	
		    if (rs2 != null) {
		        rs2.close();
		    }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		    
		String [] deletarPeso = {
				idPeso,
				idAnimal
		};
		
		dbQueryPeso.delete(deletarPeso);
		
		
		DBQuery dbQuery = new DBQuery("animal", "idAnimal", "idAnimal");
		ResultSet rs = dbQuery.select("idAnimal = " + idAnimal);
		
		String [] deletarAnimal = {
			idAnimal
		};
		
		dbQuery.delete(deletarAnimal);
		response.sendRedirect("./View/informacoesAnimal.jsp");
		
	}

	private void RegistroAlimentacao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String quantidade = request.getParameter("quantidade");
		
		String litros = request.getParameter("litros");
		
		String dataRacao = request.getParameter("dataRacao");
		
		DBQuery query = new DBQuery("alimentacacaoAnimal","quantidade,litros,dataRacao ","idAlimentacacaoAnimal");
		
		String[] animalaltimentacao = {
				quantidade,
				litros,
				dataRacao
			};
		query.insert(animalaltimentacao);
	}

	private void RegistroOvos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String quantidadeOvos = request.getParameter("quantidadeOvos");
		String dataRegistroOvos = request.getParameter("dataRegistroOvos");
		
		DBQuery query = new DBQuery("resgistroOvos","quantidade, dataRegistro","idresgistroOvos");
		
		String[] registroOvos = {
				quantidadeOvos,
				dataRegistroOvos
			};
		query.insert(registroOvos);
		
	}
			
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
