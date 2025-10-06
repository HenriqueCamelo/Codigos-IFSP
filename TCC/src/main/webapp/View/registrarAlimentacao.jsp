<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Alimentação Animal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
		<div class="container mt-4">
	        <h2>Alimentação Animal</h2>
	        <a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="MenuAnimais.jsp">voltar</a>
	        
	        <div class="container p-4 bg-light mt-3 border rounded-4">
	        	<form action="/TCC/ServeltAnimal?acao=registroAlimentacao" method="post">
                
                <div class="form-group">
                    <label for="dataNascimento">Quantidade de ração:</label>
                    <input type="text" class="form-control" id="quantidade" name="quantidade" placeholder="Quantidade em Kg" required>
                </div>
                
                <div class="form-group">
                    <label for="dataNascimento">Litros de agua:</label>
                    <input type="text" class="form-control" id="litros" name="litros" placeholder="Quantidade em Litros" required>
                </div>
                
                <div class="form-group">
                    <label for="dataNascimento">Dia em que os dados foram colocados:</label>
                    <input type="date" class="form-control" id="dataRacao" name="dataRacao" placeholder="Insira data de inserção" required>
                </div>
            	<br><button type="submit" class="btn btn-primary">Salvar</button>
            </form>
	        </div>
        </div>
        	
</body>
</html>