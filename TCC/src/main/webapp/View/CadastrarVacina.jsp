<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
		<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
		  		<div class="container-fluid">
		    		<a class="navbar-brand mx-auto text-bg-primary" href="#">Logo</a>
		  		</div>
		</nav>
		
		<div class="container ">
			<div class="container p-4 bg-light mt-3 border rounded-4">	
				
				<div class="container p-3 rounded-3">
					<h3>Adicionar Animal</h3>
				</div>
				
				
				<a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="Vacinas.jsp">voltar</a>
				
				<div class="mb-3 mt-3">
					 <form action="/TCC/ServeltAnimal?acao=cadastrarVacina" method="post">
					    <label for="email">Nome Vacina:</label>
					    <input type="text" class="form-control" id="nomeVacina" placeholder="Insira o nome da Vacina" name="nomeVacina">
					  	<br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    	<br><a id="linkCadUser" style="margin-left:25%" type="button" class="btn btn-danger my-2 w-50 " href="#">Cancelar</a>
					  </form> 
				</div>
			</div>
		</div>
</body>
</html>