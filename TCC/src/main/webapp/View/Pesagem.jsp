<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Pesagem</title>
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
					<h3>Pesagem</h3>
				</div>
			
				<a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="MenuAnimais.jsp">voltar</a>
			
				<div  id="vacinasArea" class="container mx-auto ">
					<form action="/TCC/ServeltAnimal?acao=peso" method="post">
						
						<div class="mb-3 mt-3">
					      <label for="email">Id Animal:</label>
					      <input type="number" class="form-control" id="idAn" placeholder="Insira o Id" name="idAn">
					    </div>
					    
					    <div class="mb-3">
					      <label for="pwd">Data:</label>
					      <input type="date" class="form-control" id="dataPes" placeholder="Enter password" name="dataPes">
					    </div>
					    
					    <div class="mb-3">
					      <label for="pwd">Peso:</label>
					      <input type="text" class="form-control" id="pesagem" placeholder="Insira o peso em Kg" name="pesagem">
					    </div>
				    
				    <br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    <br><a id="linkCadUser" style="margin-left:25%" type="button" class="btn btn-danger my-2 w-50 " href="#">Cancelar</a>
				  </form>
				</div>
			</div>
		</div>
</body>
</html>