<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
<% 
	
	String idAnimal = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Descarte Animal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-4">
        <h2>Entrada Animal</h2>
        <a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="informacoesAnimal.jsp">voltar</a>
        
        <div class="container p-4 bg-light mt-3 border rounded-4">
        	<form action="/TCC/ServeltAnimal?acao=entradaAnimal" method="post">
                <div class="mb-3 mt-3">
					      <label for="idAn">Id Animal:</label>
					      <input type="number" class="form-control" id="idAn" placeholder="Insira o Id" name="idAn">
				</div>
                
                <div class="form-group">
                    <label for="dataEntAn">Data de Entrada:</label>
                    <input type="date" class="form-control" id="dataEntAn" name="dataEntAn" value="Insira data de entrada" required>
                </div>
                
            <br><button type="submit" class="btn btn-primary">Adicionar Entrada</button>
            <input id="linkCadUser" style="margin-left:25%" class="btn btn-danger my-2 w-50 " href="#" type="reset" value="Cancelar">
            </form>
        </div>
    </div>
</body>
</html>