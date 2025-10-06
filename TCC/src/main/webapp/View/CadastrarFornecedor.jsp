<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastrar Fornecedor</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<meta charset="UTF-8">
<title>Cadastrar Fornecedor</title>
</head>
<body>
		
		<nav class="navbar navbar-expand-sm navbar-dark bg-success">
		  		<div class="container-fluid">
		    		<a class="navbar-brand mx-auto " href="#">GranjaManagements</a>
		  		</div>
		</nav>
		
		<div class="container ">
			<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
				
				<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="MenuDespesas.jsp">voltar</a>
			    <h2 class="pb-2">Adicionar Fornecedor</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuDespesas.jsp'class='text-decoration-none text-black'>Despesas</a> > Adicionar Fornecedor </h6>
				</div>
				
				<div class="mb-3 mt-3">
					 <form action="/TCC/ServletFornecedor?acao=cadastrarFornecedor" method="post">
					    
					    <label for="nomeForn">Nome do Fornecedor:</label>
					    <input type="text" class="form-control" id="nomeForn" placeholder="Insira o nome do forncedor" name="nomeForn" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    
					    <label for="CNPJ">CNPJ do Fornecedor:</label>
					    <input type="number" class="form-control" id="CNPJ" placeholder="Insira o CNPJ do fornecedor" name="CNPJ" required>
					  	
					  	<br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    	<br><a id="linkCadUser" style="margin-left:25%" type="button" class="btn btn-danger my-2 w-50 " href="#">Cancelar</a>
					  </form> 
				</div>
			</div>
		</div>
</body>
</html>