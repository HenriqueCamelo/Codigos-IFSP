<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h2>Descarte Animal</h2>
        <a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="informacoesAnimal.jsp">voltar</a>
        
        <div class="container p-4 bg-light mt-3 border rounded-4">
        	<form action="/TCC/ServeltAnimal?acao=descarteAnimal" method="post">
                <input type="hidden" name="idAnimal" id="idAnimal" value="<%= idAnimal %>">
                <div class="form-group">
                    <label for="dataNascimento">Data de Descarte:</label>
                    <input type="date" class="form-control" id="dataDescAn" name="dataDescAn" value="Insira data de descarte" required>
                </div>
            <br><button type="submit" class="btn btn-primary">Descartar</button>
            </form>
        </div>
    </div>
</body>
</html>