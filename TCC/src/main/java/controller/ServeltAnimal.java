package controller;

import model.Animal;
import model.Vacina;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    	
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
        	
        	String acao = request.getParameter("acao");
            
            switch (acao) {
                case "cadastrarnimal":
                    CadastrarAnimais(request, response);
                    break;
                case "listaAnimais":
                    InfomaçõesAnimais(request, response);
                    break;
                case "deletarAnimais":
                    DeletarAnimal(request, response);
                    break;
                case "atualizarAnimais":
                    AtualizarAnimal(request, response);
                    break;
                case "peso":
                    PesoAnimal(request, response);
                    break;
                case "vacina":
                    VacinaAnimal(request, response);
                    break;
                case "cadastrarVacina":
                    CadastrarVacina(request, response);
                    break;
                case "descarteAnimal":
                    DescarteAnimal(request, response);
                    break;
                case "registroAlimentacao":
                    RegistroAlimentacao(request, response);
                    break;
                case "registroOvos":
                    RegistroOvos(request, response);
                    break;
                case "entradaAnimal":
                    EntradaAnimal(request, response);
                    break;
                case "saidaAnimal":
                    SaidaAnimal(request, response);
                    break;
                case "formVacina":
                    FormVacina(request, response);
                    break;
                case "formAnimal":
                    FormAnimais(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação inválida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro interno no servidor");
        }
    }
	
	private void CadastrarAnimais(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String nomeAn = request.getParameter("nomeAn");
			
			String sexoAn = request.getParameter("sexoAn");
			
		//		Date dataNascAn = (Date) request.getSession().getAttribute("dataNascAn");
			
			String dataNascAn = request.getParameter("dataNascAn");
			
			String fazenda = request.getParameter("fazenda");
		
			String granja = request.getParameter("granja");
			
			String paiAn = request.getParameter("paiAn");
			
			String maeAn = request.getParameter("maeAn");
			
			String vendedorAn = request.getParameter("vendedorAn");
			
			String precoAn = request.getParameter("precoAn");
			
			//Date dataCompraAn = (Date) request.getSession().getAttribute("dataCompraAn");
			String dataCompraAn = request.getParameter("dataCompraAn");
			
			String dadosExtraAn = request.getParameter("dadosExtraAn");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ou outro formato desejado
			
			DBQuery query = new DBQuery("animal","nomeAnimal,sexoAnimal,dataNascimentoAnimal,fazenda,granja,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra","idAnimal");
			
			String[] novoanimal = {
					nomeAn,
					sexoAn,
					dataNascAn,
					fazenda,
					granja,
					paiAn,
					maeAn,
					vendedorAn,
					precoAn,
					dataCompraAn,
					dadosExtraAn
				};
			query.insert(novoanimal);
			response.sendRedirect("./View/CadastroAnimais.jsp?status=sucesso");
		} catch (Exception e) {
	        e.printStackTrace();

	        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
	        String erro = URLEncoder.encode("Erro ao cadastrar animal", "UTF-8");

	        // Redireciona para a página de erro com status e mensagem
	        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
	    	}
		
	}
	
	private void InfomaçõesAnimais(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    try {
	    	System.out.println("Método doPost foi chamado!");
	        HttpSession session = request.getSession();
	        String fazenda = (String) session.getAttribute("nomeFazenda");
	        System.out.println(fazenda);
	    	
	    	List<Animal> listaAnimais = new ArrayList<>();
	        DBQuery query = new DBQuery("animal", "idAnimal,nomeAnimal,sexoAnimal,dataNascimentoAnimal,fazenda,granja,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra", "idAnimal");
	        ResultSet rs = query.select("idAnimal > 0 AND fazenda =" + "'"+fazenda+"'");

	        while (rs != null && rs.next()) {
	            Animal animal = new Animal();
	            animal.setIdAnimal(rs.getInt("idAnimal"));
	            animal.setNomeAnimal(rs.getString("nomeAnimal"));
	            animal.setSexoAnimal(rs.getString("sexoAnimal"));
	            animal.setPrecoAnimal(rs.getDouble("precoAnimal"));
	            animal.setDataNascimentoAnimal(rs.getDate("dataNascimentoAnimal"));
	            animal.setFazenda(rs.getString("fazenda"));
	            animal.setGranja(rs.getString("granja"));
	            animal.setDataCompra(rs.getDate("dataCompra"));
	            animal.setPaiAnimal(rs.getString("paiAnimal"));
	            animal.setMaeAnimal(rs.getString("maeAnimal"));
	            animal.setVendedor(rs.getString("vendedor"));
	            animal.setDadosExtra(rs.getString("dadosExtra"));
	            listaAnimais.add(animal);
	        }
	        if (rs != null) rs.close();
	        String json = new Gson().toJson(listaAnimais);
	        response.getWriter().write(json);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao obter informações dos animais");
	    }
	}
	
	private void FormAnimais(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 try {
			 	HttpSession session = request.getSession();
		        String fazenda = (String) session.getAttribute("nomeFazenda");
		        System.out.println(fazenda);
		        
			 	List<Animal> listaAnimais = new ArrayList<>();
			 
			 	DBQuery query = new DBQuery("animal", "idAnimal,nomeAnimal", "idAnimal");
		        ResultSet rs = query.select("idAnimal > 0 AND fazenda =" + "'"+fazenda+"'");

		        while (rs != null && rs.next()) {
		            Animal animal = new Animal();
		            animal.setIdAnimal(rs.getInt("idAnimal"));
		            animal.setNomeAnimal(rs.getString("nomeAnimal"));
		            listaAnimais.add(animal);
		        }

		        if (rs != null) rs.close();
		        String json = new Gson().toJson(listaAnimais);
		        response.setContentType("application/json");
		        response.getWriter().write(json);
		    } catch (SQLException | NumberFormatException e) {
		        e.printStackTrace();
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao obter animais");
		    }
	}
	
	private void DeletarAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
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
		} catch (Exception e) {
	        e.printStackTrace();

	        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
	        String erro = URLEncoder.encode("Erro ao deletar animal", "UTF-8");

	        // Redireciona para a página de erro com status e mensagem
	        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
	    	}
	}

	private void AtualizarAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    try {
	        String idAnimalStr = request.getParameter("idAnimal");
	        String nomeAn = request.getParameter("nomeAn");
	        String sexoAn = request.getParameter("sexoAn");
	        String dataNascAn = request.getParameter("dataNascAn");
	        String fazenda = request.getParameter("fazenda");
	        String granja = request.getParameter("granja");
	        String paiAn = request.getParameter("paiAn");
	        String maeAn = request.getParameter("maeAn");
	        String vendedorAn = request.getParameter("vendedorAn");
	        String precoAn = request.getParameter("precoAn");
	        String dataCompraAn = request.getParameter("dataCompraAn");
	        String dadosExtraAn = request.getParameter("dadosExtraAn");
	        DBQuery query = new DBQuery("animal", "idAnimal,nomeAnimal,sexoAnimal,dataNascimentoAnimal,fazenda, granja,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra", "idAnimal");
	        String[] editaranimal = {idAnimalStr, nomeAn, sexoAn, dataNascAn, fazenda,granja, paiAn, maeAn, vendedorAn, precoAn, dataCompraAn, dadosExtraAn};
	        query.update(editaranimal);
	        response.sendRedirect("./View/informacoesAnimal.jsp?status=sucesso");
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("erro", "Erro ao atualizar animal: " + e.getMessage());

	        try {
	            request.getRequestDispatcher("./View/informacoesAnimal.jsp?status=erro").forward(request, response);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro interno ao redirecionar");
	        }
	    }
	}
	
	private void PesoAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
	try {
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
		response.sendRedirect("./View/MenuAnimais.jsp?status=sucesso");
			
	} catch (Exception e) {
        e.printStackTrace();

        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
        String erro = URLEncoder.encode("Erro ao cadastrar vacina", "UTF-8");

        // Redireciona para a página de erro com status e mensagem
        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
    	}
		
		
	}
	
	private void EntradaAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
	try {
		String idAn = request.getParameter("idAn");
		
		String dataEntAn = request.getParameter("dataEntAn");
		
		DBQuery query = new DBQuery("entradaAnimal","idAnimal,dataEntrada","idEntradaAnimal");
		
		String[] novaentrada = {
				idAn,
				dataEntAn
			};	
			
		query.insert(novaentrada);
		response.sendRedirect("./View/MenuAnimais.jsp?status=sucesso");
		} catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("erro", "Erro ao cadastrar entrada animal: " + e.getMessage());
	
	        try {
	            request.getRequestDispatcher("./View/MenuAnimais.jsp?status=erro").forward(request, response);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro interno ao redirecionar");
	        }
	    }
		
		
	}
	
	private void SaidaAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
	try {
		String idAn = request.getParameter("idAn");
		
		String dataSaidaAn = request.getParameter("dataSaidaAn");
		
		DBQuery query = new DBQuery("saidaAnimal","idAnimal,dataSaida","idSaidaAnimal");
		
		String[] novasaida = {
				idAn,
				dataSaidaAn
			};	
			
		query.insert(novasaida);
		DBQuery dbQueryVacinaAnimal = new DBQuery("vacinaAnimal", "idVacinaAnimal, idAnimal", "idVacinaAnimal");
		ResultSet rs1 = dbQueryVacinaAnimal.select("idAnimal = " + idAn);
		
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
		    
		String [] deletarVacinaAnimal = {
				idVacinaAnimal,
				idAn
		};
		
		dbQueryVacinaAnimal.delete(deletarVacinaAnimal);
		
		DBQuery dbQueryPeso = new DBQuery("peso", "idPeso, idAnimal", "idPeso");
		ResultSet rs2 = dbQueryPeso.select("idAnimal = " + idAn);
		
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
				idAn
		};
		
		dbQueryPeso.delete(deletarPeso);
		
		
		DBQuery dbQuery = new DBQuery("animal", "idAnimal", "idAnimal");
		ResultSet rs = dbQuery.select("idAnimal = " + idAn);
		
		String [] deletarAnimal = {
				idAn
		};
		
		dbQuery.delete(deletarAnimal);
		
		response.sendRedirect("./View/MenuAnimais.jsp?status=sucesso");
	} catch (Exception e) {
        e.printStackTrace();

        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
        String erro = URLEncoder.encode("Erro ao confirmar saida animal", "UTF-8");

        // Redireciona para a página de erro com status e mensagem
        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
    	}
		
	}


	private void VacinaAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
	try {
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
		response.sendRedirect("./View/MenuAnimais.jsp?status=sucesso");
	} catch (Exception e) {
        e.printStackTrace();

        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
        String erro = URLEncoder.encode("Erro ao cadastrar vacina", "UTF-8");

        // Redireciona para a página de erro com status e mensagem
        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
    	}
				
	}

	private void CadastrarVacina(HttpServletRequest request, HttpServletResponse response) throws IOException {
	try {
		String nomeVacina = request.getParameter("nomeVacina");
		
		DBQuery query = new DBQuery("vacina","nomeVacina","idVacina");
		
		String[] novavacina = {
				nomeVacina
			};
		query.insert(novavacina);
		
		response.sendRedirect("./View/CadastrarVacina.jsp?status=sucesso");
	} catch (Exception e) {
        e.printStackTrace();

        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
        String erro = URLEncoder.encode("Erro ao cadastrar vacina", "UTF-8");

        // Redireciona para a página de erro com status e mensagem
        response.sendRedirect(request.getContextPath() + "/View/CadastrarVacina.jsp?status=erro&msg=" + erro);
    	}
		
	}
	
	private void FormVacina(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 try {
			 	List<Vacina> listaVacinas = new ArrayList<>();
			 
			 	DBQuery query = new DBQuery("vacina", "idVacina,nomeVacina", "idVacina");
		        ResultSet rs = query.select("idVacina > 0");

		        while (rs != null && rs.next()) {
		            Vacina vacina = new Vacina();
		            vacina.setIdVacina(rs.getInt("idVacina"));
		            vacina.setNomeVacina(rs.getString("nomeVacina"));
		            listaVacinas.add(vacina);
		        }

		        if (rs != null) rs.close();
		        String json = new Gson().toJson(listaVacinas);
		        response.setContentType("application/json");
		        response.getWriter().write(json);
		    } catch (SQLException | NumberFormatException e) {
		        e.printStackTrace();
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao obter vacinas");
		    }
	}

	private void DescarteAnimal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
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
		    
		String [] deletarVacinaAnimal = {
				idVacinaAnimal,
				idAnimal
		};
		
		dbQueryVacinaAnimal.delete(deletarVacinaAnimal);
		
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
		response.sendRedirect("./View/informacoesAnimal.jsp?status=sucesso");
		} catch (Exception e) {
	        e.printStackTrace();

	        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
	        String erro = URLEncoder.encode("Erro ao descartar animal", "UTF-8");

	        // Redireciona para a página de erro com status e mensagem
	        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
	    	}
	}

	private void RegistroAlimentacao(HttpServletRequest request, HttpServletResponse response) throws IOException {
	try {
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
		response.sendRedirect("./View/MenuAnimais.jsp?status=sucesso");
	} catch (Exception e) {
        e.printStackTrace();

        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
        String erro = URLEncoder.encode("Erro ao registrar alimenação", "UTF-8");

        // Redireciona para a página de erro com status e mensagem
        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
    	}
		
	}

	private void RegistroOvos(HttpServletRequest request, HttpServletResponse response) throws IOException {
	try {
		String quantidadeOvos = request.getParameter("quantidadeOvos");
		String dataRegistroOvos = request.getParameter("dataRegistroOvos");
		
		DBQuery query = new DBQuery("resgistroOvos","quantidade, dataRegistro","idresgistroOvos");
		
		String[] registroOvos = {
				quantidadeOvos,
				dataRegistroOvos
			};
		query.insert(registroOvos);
		response.sendRedirect("./View/MenuAnimais.jsp?status=sucesso");
	} catch (Exception e) {
        e.printStackTrace();

        // Mensagem de erro com encoding para evitar problemas com espaços e caracteres especiais
        String erro = URLEncoder.encode("Erro ao registrar ovos", "UTF-8");

        // Redireciona para a página de erro com status e mensagem
        response.sendRedirect(request.getContextPath() + "/View/MenuAnimais.jsp?status=erro&msg=" + erro);
    	}
		
	}
			
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
