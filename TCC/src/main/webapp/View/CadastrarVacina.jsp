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
<%-- Exibe mensagem de sucesso ou erro com base no parâmetro 'status' na URL --%>
<%
    String status = request.getParameter("status");
    String erro = request.getParameter("msg");
    out.print(MensagemUtil.gerarAlerta(status, erro));
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
<body>
		
		<nav class="navbar navbar-expand-sm navbar-dark bg-success">
		  		<div class="container-fluid">
		    		<a class="navbar-brand mx-auto " href="#">GranjaManagements</a>
		  		</div>
		</nav>
		
		<div class="container ">
			<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
				
				<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="Vacinas.jsp">voltar</a>
			    <h2 class="pb-2">Adicionar Vacina</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuAnimais.jsp'class='text-decoration-none text-black'>Animais</a> > <a href="Vacinas.jsp" class="text-decoration-none text-black">Vacinas</a> > Adicionar Vacinas </h6>
				</div>
				
				<div class="mb-3 mt-3">
					 <form action="/TCC/ServeltAnimal?acao=cadastrarVacina" method="post">
					    <label for="nomeVacina">Nome Vacina:</label>
					    <input type="text" class="form-control" id="nomeVacina" placeholder="Insira o nome da Vacina" name="nomeVacina" required>
					  	<br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    	<input id="linkCadUser" style="margin-left:25%" class="btn btn-danger my-2 w-50 " type="reset" value="Cancelar">
					  </form> 
				</div>
			</div>
		</div>
</body>
</html>