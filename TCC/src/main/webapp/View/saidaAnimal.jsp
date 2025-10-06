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
  <title>Saída Animal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-4">
        <h2>Saída Animal</h2>
        <a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="informacoesAnimal.jsp">voltar</a>
        
        <div class="container p-4 bg-light mt-3 border rounded-4">
        	<form action="/TCC/ServeltAnimal?acao=saidaAnimal" method="post">
				<input type="hidden" name="idAn" id="idAn" value="<%= idAnimal %>" >
                <div class="form-group">
                    <label for="dataSaidaAn">Data de Saída:</label>
                    <input type="date" class="form-control" id="dataSaidaAn" name="dataSaidaAn" value="Insira data de saida" required>
                </div>
            <br><button type="submit" class="btn btn-primary">Confirmar Saida</button>
            </form>
        </div>
    </div>
</body>
</html>