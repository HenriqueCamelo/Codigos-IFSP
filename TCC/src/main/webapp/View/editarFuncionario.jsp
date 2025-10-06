<%@ page import="java.sql.*" %>
<%@ page import="database.DBQuery" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String idFuncionario = request.getParameter("id");
    String nomefun = request.getParameter("nomefun");
    String sexo = request.getParameter("sexo");
    String dataNascimento = request.getParameter("dataNascimento");
    String CPF = request.getParameter("CPF");
    String banco = request.getParameter("banco");
    String telefone = request.getParameter("telefone");
%>
<html>
<head>
  <title>Editar Funcionário</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container mt-4">
        <h2>Editar Funcionário</h2>
        <div class="container p-4 bg-light mt-3 border rounded-4">

        <form action="/TCC/ServletFuncionario?acao=atualizarFuncionario" method="post">
            <input type="hidden" name="idFuncionario" id="idFuncionario" value="<%= idFuncionario %>">
            <div class="form-group">
                <label for="nomefun">Nome:</label>
                <input type="text" class="form-control" id="nomefun" name="nomefun" value="<%= nomefun %>" required>
            </div>
            <div class="form-group">
                <label for="sexo">Sexo:</label>
                <input type="text" class="form-control" id="sexo" name="sexo" value="<%= sexo %>" required>
            </div>
            <div class="form-group">
                <label for="dataNascimento">Data de Nascimento:</label>
                <input type="date" class="form-control" id="dataNascimento" name="dataNascimento" value="<%= dataNascimento %>" required>
            </div>
            <div class="form-group">
                <label for="CPF">CPF:</label>
                <input type="number" class="form-control" id="CPF" name="CPF" value="<%= CPF %>" required>
            </div>
            <div class="form-group">
                <label for="banco">Banco:</label>
                <input type="number" class="form-control" id="banco" name="banco" value="<%= banco %>" required>
            </div>
            <div class="form-group">
                <label for="telefone">Telefone:</label>
                <input type="number" class="form-control" id="telefone" name="telefone" value="<%= telefone %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
     </div>   
    </div>
</body>
</html>
