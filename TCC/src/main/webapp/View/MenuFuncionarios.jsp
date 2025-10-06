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

<!DOCTYPE html>
<html>
<head>
  <title>Informações Funcionarios</title>
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
		
	<div class="container px-4 py-5" id="hanging-icons">
    <a id="linkCadUser" href="MenuPrincipal.jsp">voltar</a>
    <h2 class="pb-2">Menu Cadastrados</h2>
    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > Menu cadastrados </h6>
    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
      
      <a href='CadastrarFuncionario.jsp' class='text-decoration-none text-black '>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          👩‍💼👨‍💼
	        </div>
	        <div>
	          <h2>Adicionar Funcionario</h2>
	          <p>Insira aqui um novo funcionário.</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='informacoesFunc.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          ℹ
	        </div>
	        <div>
	          <h2>Informações funcionarios</h2>
	          <p>Informações relacionadas aos funcionários.</p>
	          
	        </div>
	      </div>
      </a>
            
    </div>
  </div>
	
</body>
</html>