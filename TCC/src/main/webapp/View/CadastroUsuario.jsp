<%@page import="database.DBQuery"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>   
<%@ page import="model.SessaoUtil" %>
<%@ page import="model.MensagemUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
    <%-- Exibe mensagem de sucesso ou erro com base no parâmetro 'status' na URL --%>
<%
    String status = request.getParameter("status");
    if ("sucesso".equals(status)) {
%>
        <script type="text/javascript">
            alert("Cadastro realizado com sucesso!");
        </script>
<%
    } else if ("erro".equals(status)) {
%>
        <script type="text/javascript">
            alert("Erro ao cadastrar funcionário. Tente novamente.");
        </script>
<%
    }
%>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastro Usuario</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class="bg-light">
	<nav class="navbar navbar-expand-sm navbar-dark bg-success">
      <div class="container-fluid">
        <a class="navbar-brand mx-auto" href="#">GranjaManagements</a>
      </div>
    </nav>
    
    <div id="frmCadastroArea" class="container mx-auto">
    <h2 class="mt-3">Login</h2>
    <a id="linkCadUser" href="Login.jsp"> <-voltar</a>
    
    <form action="/TCC/LoginServlet" method="post">
          
          <div class="mb-3 mt-3">
              <label for="Nome">Nome:</label>
              <input type="text" class="form-control" id="nome" name="nome" required>
          </div>
          
          <div class="mb-3 mt-3">
              <label for="email">Email:</label>
              <input type="email" class="form-control" id="email" name="email" required>
          </div>
          
          <div class="mb-3">
              <label for="senha">Senha:</label>
              <input type="password" class="form-control" id="senha" name="senha" required>
          </div>
          
          <div class="mb-3 mt-3">
              <label for="nomefazenda">Nome da fazenda:</label>
              <input type="text" class="form-control" id="nomefazenda" name="nomefazenda" required>
          </div>
          
          <div class="mb-3 mt-3">
              <label for="cargo">Cargo(Dono ou funcionário):</label>
              <input type="text" class="form-control" id="cargo" name="cargo" required>
          </div>
          
          <button type="submit" style="margin-left:25%" class="btn btn-success w-50">Entrar</button>
      
      </form>
    
    </div>
</body>
</html>