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
<!DOCTYPE html>
<html>
<head>
  <title>Informações Despesa</title>
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
    <h2 class="pb-2">Despesas</h2>
    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > Despesas </h6>
    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
      
      <a href='Despesas.jsp' class='text-decoration-none text-black '>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          📥
	        </div>
	        <div>
	          <h2>Adicionar despesa</h2>
	          <p>Insira aqui uma nova despesa pendente.</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='CadastrarFornecedor.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          👩‍💼👨‍💼
	        </div>
	        <div>
	          <h2>Adicionar Fornecedor</h2>
	          <p>Insira aqui um novo fornecedor.</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='informacoesDespesa.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          💰
	        </div>
	        <div>
	          <h2>Informações despesa</h2>
	          <p>Informações das despesas anteriormente adicionadas.</p>
	          
	        </div>
	      </div>
      </a>
      
            
    </div>
  </div>
	
</body>
</html>