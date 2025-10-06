<%@page import="database.DBQuery"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%@ page import="model.MensagemUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>

<%
    String status = request.getParameter("status");
    String erro = request.getParameter("msg");
    out.print(MensagemUtil.gerarAlerta(status, erro));
%>

<% 
		// Recupera o nome do usuário armazenado na sessão
		String nomeFazenda = (String) session.getAttribute("nomeFazenda");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Adicionar Animal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class = "bg-light">
		
		<!-- <nav class="navbar navbar-expand-sm navbar-dark bg-success">
	  		<div class="container-fluid">
	    		<a class="navbar-brand mx-auto " href="#">Logo</a>
	  		</div>
		</nav> -->
	
				
	
		<div class="container ">
			<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
				
			<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="MenuAnimais.jsp">voltar</a>
			    <h2 class="pb-2">Cadastro Animais</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuAnimais.jsp'class='text-decoration-none text-black'>Animais</a> > Cadastro Animais </h6>
			</div>
				
				<div  id="inserirAnimal" class="container mx-auto ">
					<form action="/TCC/ServeltAnimal?acao=cadastrarnimal" method="post">
						
						<div class="mb-3 mt-3">
					      <label for="nomeAn">Nome:</label>
					      <input type="text" class="form-control bg-light" id="nomeAn" placeholder="Insira o nome do animal" name="nomeAn" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais/Nome excede 30 caracteres.">
					    </div>
					    
					    <div class="mb-3">
						  <label for="sexoAn">Sexo:</label>
						  <select class="form-control bg-light" id="sexoAn" name="sexoAn" required>
						    <option value="">Selecione</option>
						    <option value="macho">Macho</option>
						    <option value="femea">Fêmea</option>
						  </select>
						</div>
					    
					    <div class="mb-3">
					      <label for="dataNascAn">Data de Nascimento:</label>
					      <input type="date" class="form-control bg-light" id="dataNascAn" placeholder="Insira data de nascimento" name="dataNascAn" required>
					    </div>
					    

					      <input type="hidden" class="form-control bg-light" value="<%= nomeFazenda %>"id="fazenda" name="fazenda" required>
					    
					    
					    <div class="mb-3">
					      <label for="granja">Granja:</label>
					      <input type="text" class="form-control bg-light" id="granja" placeholder="Insira o nome da granja " name="granja" required >
					    </div>
					    
					    <div class="mb-3">
					    <label for="paiAn">Pai:</label>
					      <input type="text" class="form-control bg-light" id="paiAn" placeholder="Insira o pai do animal " name="paiAn" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    </div>
					    
					    <div class="mb-3">
					    <label for="maeAn">Mãe:</label>
					      <input type="text" class="form-control bg-light" id="maeAn" placeholder="Insira a mãe do animal " name="maeAn" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    </div>
					    
					    <div class="mb-3">
					    <label for="vendedorAn">Vendedor:</label>
					      <input type="text" class="form-control bg-light" id="vendedorAn" placeholder="Insira o vendedor do animal " name="vendedorAn" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    </div>
					    
					    <div class="mb-3">
					    <label for="precoAn">Preco Animal:</label>
					      <input type="number" class="form-control bg-light" id="precoAn" placeholder="Insira o preço da compra do animal " name="precoAn" step="any" required>
					    </div>
					    
					    <div class="mb-3">
					    <label for="dataCompraAn">Data de compra:</label>
					      <input type="date" class="form-control bg-light" id="dataCompraAn" placeholder="Insira a data da compra do animal " name="dataCompraAn" required>
					    </div>
					    
					    <div class="mb-3">
					    <label for="dadosExtraAn">Dados Extra:</label>
					      <input type="text" class="form-control bg-light" id="dadosExtraAn" placeholder="Insira dados extras do animal" name="dadosExtraAn" required>
					    </div>

				    
				    <br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    <input id="linkCadUser" style="margin-left:25%" class="btn btn-danger my-2 w-50 " type="reset" value="Cancelar">
				  </form>
				</div>
			</div>
		</div>
</body>
</html>