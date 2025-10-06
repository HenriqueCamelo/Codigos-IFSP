<%@page import="database.DBQuery"%>
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
			
				<a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="MenuAnimais.jsp">voltar</a>
				
				<div  id="inserirAnimal" class="container mx-auto ">
					<form action="/TCC/ServeltAnimal?acao=cadastrarnimal" method="post">
						
						<div class="mb-3 mt-3">
					      <label for="email">Nome:</label>
					      <input type="text" class="form-control" id="nomeAn" placeholder="Insira o nome do animal" name="nomeAn">
					    </div>
					    
					    <div class="mb-3">
					      <label for="pwd">Sexo:</label>
					      <input type="text" class="form-control" id="sexoAn" placeholder="Insira o sexo do animal " name="sexoAn">
					    </div>
					    
					    <div class="mb-3">
					      <label for="pwd">Data de Nascimento:</label>
					      <input type="date" class="form-control" id="dataNascAn" placeholder="Insira data de nascimento" name="dataNascAn">
					    </div>
					    
					    <div class="mb-3">
					      <label for="pwd">Foto:</label>
					      <input type="text" class="form-control" id="fotoAn" placeholder="Insira uma foto " name="fotoAn">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Pai:</label>
					      <input type="text" class="form-control" id="paiAn" placeholder="Insira o pai do animal " name="paiAn">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Mãe:</label>
					      <input type="text" class="form-control" id="maeAn" placeholder="Insira a mãe do animal " name="maeAn">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Vendedor:</label>
					      <input type="text" class="form-control" id="vendedorAn" placeholder="Insira o vendedor do animal " name="vendedorAn">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Preco Animal:</label>
					      <input type="text" class="form-control" id="precoAn" placeholder="Insira o preço da compra do animal " name="precoAn">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Data de compra:</label>
					      <input type="date" class="form-control" id="dataCompraAn" placeholder="Insira a data da compra do animal " name="dataCompraAn">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Dados Extra:</label>
					      <input type="text" class="form-control" id="dadosExtraAn" placeholder="Insira dados extras do animal" name="dadosExtraAn">
					    </div>

				    
				    <br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    <br><a id="linkCadUser" style="margin-left:25%" type="button" class="btn btn-danger my-2 w-50 " href="#">Cancelar</a>
				  </form>
				</div>
			</div>
		</div>
</body>
</html>