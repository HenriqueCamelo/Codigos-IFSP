<%@ page import="java.sql.*" %>
<%@ page import="database.DBQuery" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String idDespesa = request.getParameter("id");
	String dataCompra = request.getParameter("dataCompra");
	String idFornecedor = request.getParameter("idFornecedor");
	String endereco = request.getParameter("endereco");
	String cidade = request.getParameter("cidade");
	String bairro = request.getParameter("bairro");
	String CNPJCPF = request.getParameter("CNPJCPF");
	String valor = request.getParameter("valor");
	String numeroParcelas = request.getParameter("numeroParcelas");
%>
<html>
<head>
  <title>Editar Despesa</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container mt-4">
        <h2>Editar Despesa</h2>
        <div class="container p-4 bg-light mt-3 border rounded-4">

        <form action="/TCC/ServeletDespesa?acao=atualizarDespesa" method="post">
            <input type="hidden" name="idDespesa" id="idDespesa" value="<%= idDespesa %>">
            <div class="form-group">
                <label for="nome">Data de compra:</label>
                <input type="date" class="form-control" id="dataCompra" name="dataCompra" value="<%= dataCompra  %>" required>
            </div>
            <div class="form-group">
                <label for="sexo">Fornecedor:</label>
                <input type="text" class="form-control" id="idFornecedor" name="idFornecedor" value="<%= idFornecedor %>" required>
            </div>
            <div class="form-group">
                <label for="dataNascimento">Endereco:</label>
                <input type="text" class="form-control" id="endereco" name="endereco" value="<%= endereco %>" required>
            </div>
            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" class="form-control" id="cidade" name="cidade" value="<%= cidade %>" required>
            </div>
            <div class="form-group">
                <label for="pai">Bairro:</label>
                <input type="text" class="form-control" id="bairro" name="bairro" value="<%= bairro %>" required>
            </div>
            <div class="form-group">
                <label for="mae">CNPJ:</label>
                <input type="text" class="form-control" id="CPF" name="CPF" value="<%= CNPJCPF %>" required>
            </div>
            <div class="form-group">
                <label for="valor">valor:</label>
                <input type="text" class="form-control" id="valor" name="valor" value="<%= valor %>" required>
            </div>
            <div class="form-group">
                <label for="preco">Numero de Parcelas:</label>
                <input type="number" class="form-control" id="numParcelasDes" name="numParcelas" value="<%= numeroParcelas %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
     </div>   
    </div>
</body>
</html>
