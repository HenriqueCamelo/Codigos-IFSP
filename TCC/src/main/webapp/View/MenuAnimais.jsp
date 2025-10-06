<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
	  		<div class="container-fluid">
	    		<a class="navbar-brand mx-auto text-bg-primary" href="#">Logo</a>
	  		</div>
		</nav>
	
		<div class="container">
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
		</div>
	
</body>
</html>