<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Despesas</title>
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
		
		<div class="container ">
			<div class="container p-4 bg-light mt-3 border rounded-4">
			
				<div class="container p-3 rounded-3">
					<h3>Adicionar Despesa</h3>
				</div>
				
				<a  class="p-3 my-3 w-100" href="MenuDespesas.jsp">Voltar</a>
				
				
				<div  id="inserirDespesa" class="container mx-auto ">
						<form action="/TCC/ServeletDespesa?acao=cadastrardespesa" method="post"> 
					
					    <div class="mb-3">
					      <label for="pwd">Data de Compra:</label>
					      <input type="date" class="form-control" id="dataCompraDes" placeholder="Insira a data" name="dataCompraDes">
					    </div>
					    
					    <div class="mb-3">
					      <label for="pwd">Fornecedor:</label>
					      <input type="text" class="form-control" id="fornecedorDes" placeholder="Enter " name="fornecedorDes">
					    </div>
					    
					    <div class="mb-3">
					      <label for="pwd">Endereço:</label>
					      <input type="text" class="form-control" id="enderecoDes" placeholder="Enter " name="enderecoDes">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Cidade:</label>
					      <input type="text" class="form-control" id="cidadeDes" placeholder="Enter " name="cidadeDes">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Bairro:</label>
					      <input type="text" class="form-control" id="bairroDes" placeholder="Enter " name="bairroDes">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">CNPJ/CPF:</label>
					      <input type="text" class="form-control" id="CPFCNPJDes" placeholder="Enter " name="CPFCNPJDes">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Valor:</label>
					      <input type="text" class="form-control" id="valorDes" placeholder="Enter " name="valorDes">
					    </div>
					    
					    <div class="mb-3">
					    <label for="pwd">Número de Parcelas:</label>
					      <input type="text" class="form-control" id="numParcelasDes" placeholder="Enter " name="numParcelasDes">
					    </div>
												
					<br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    <br><a id="linkCadUser" style="margin-left:25%" type="button" class="btn btn-danger my-2 w-50 " href="#">Cancelar</a>
							
					</form> 
				</div>
			</div> 
		</div>
</body>
</html>