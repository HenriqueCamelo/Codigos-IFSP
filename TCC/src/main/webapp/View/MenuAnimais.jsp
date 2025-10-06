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
  <title>Animais</title>
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
	
		<!-- <div class="container">
			<div class="container p-3 my-3 rounded-3">
				<h3>Animais</h3>
			</div>
			
			<a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="MenuPrincipal.jsp">voltar</a>
			
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="CadastroAnimais.jsp">Controle de Granja</a>
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="Vacinas.jsp">Vacinação</a>
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="Pesagem.jsp">Pesagem</a>
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="informacoesAnimal.jsp">Informações Animais</a>
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="registroOvos.jsp">Registro Ovos</a>
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="registrarAlimentacao.jsp">Registro Alimentação</a>
		</div> -->
		
		<div class="container px-4 py-5" id="hanging-icons">
    <a id="linkCadUser" href="MenuPrincipal.jsp">voltar</a>
    <h2 class="pb-2">Animais</h2>
    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > Animais </h6>
    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
      
      <a href='CadastroAnimais.jsp' class='text-decoration-none text-black '>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          🐓
	        </div>
	        <div>
	          <h2>Cadastro de franga</h2>
	          <p>Insira um novo animal a uma de suas granjas.</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='Vacinas.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          💉
	        </div>
	        <div>
	          <h2>Vacinação</h2>
	          <p>Insira qual vacina será aplicada em qual animal.</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='Pesagem.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          ⚖
	        </div>
	        <div>
	          <h2>Pesagem</h2>
	          <p>Insira o peso correspondente a qual animal..</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='informacoesAnimal.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          🗄
	        </div>
	        <div>
	          <h2>Informações Animais</h2>
	          <p>Verifique aqui todas as inoformações disponíveis sobre as granjas cadastradas.</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='registroOvos.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          🥚
	        </div>
	        <div>
	          <h2>Registro Ovos</h2>
	          <p>Insira aqui a quantidade de ovos adquirida em determinado dia.</p>
	          
	        </div>
	      </div>
      </a>
      
      <a href='registrarAlimentacao.jsp' class='text-decoration-none text-black'>
	      <div class="col d-flex align-items-start m-1 shadow border border-4 border-light p-2">
	        <div class="icon-square flex-shrink-0 m-3">
	          🍽
	        </div>
	        <div>
	          <h2>Registro Alimentação</h2>
	          <p>Inisira aqui a quantidade de alimento fornecida aos animais em determinado dia.</p>
	          
	        </div>
	      </div>
      </a>
      
    </div>
  </div>
	
</body>
</html>