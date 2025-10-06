<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
<!DOCTYPE html>
<html>
<head>
  <title>Quantidade Ovos</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
		<!-- <nav class="navbar navbar-expand-sm navbar-dark bg-success">
	  		<div class="container-fluid">
	    		<a class="navbar-brand mx-auto " href="#">Logo</a>
	  		</div>
		</nav> -->
		
		<div class="container mt-4">
	        <!-- <h2> Registro Ovos</h2>
	        <a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="MenuAnimais.jsp">voltar</a> -->
	        
	        <div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
				
				<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="MenuAnimais.jsp">voltar</a>
			    <h2 class="pb-2">Registro de Ovos</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuAnimais.jsp'class='text-decoration-none text-black'>Animais</a> > Registro de Ovos </h6>
				</div>
				
	        	<form action="/TCC/ServeltAnimal?acao=registroOvos" method="post">
                
                <div class="form-group">
                    <label for="quantidadeOvos">Quantidade de ovos:</label>
                    <input type="number" class="form-control bg-light" id="quantidadeOvos" name="quantidadeOvos" placeholder="Quantidade" required>
                </div>
                
                <div class="form-group">
                    <label for="dataRegistroOvos">Dia em que os dados foram colocados:</label>
                    <input type="date" class="form-control bg-light" id="dataRegistroOvos" name="dataRegistroOvos" placeholder="Insira data de inserção" required>
                </div>
            	<br><button type="submit" class="btn btn-primary">Salvar</button>
            </form>
	        </div>
        </div>
        	
</body>
</html>