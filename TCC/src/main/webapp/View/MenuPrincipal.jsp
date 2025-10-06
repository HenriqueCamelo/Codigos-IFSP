<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
  <title>Menu</title>
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
	
	<br>
	<br>
	<br>
		<div class="container">
			<div class="container p-5 my-5 border rounded-3">
				<h3>Fazenda de São João</h3>
			</div>
			
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="MenuAnimais.jsp">Animais</a>
			<button type="button" class="btn btn-secondary p-3 my-3 w-100 disabled">Relatórios</button>
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href = "informacoesFunc">Funcionarios</a>
			<a type="button" class="btn btn-secondary p-3 my-3 w-100" href="MenuDespesas.jsp" >Despesas</a>
		</div>
		
		
	
</body>
</html>