<%@ page import="java.sql.*" %>
<%@ page import="model.DateUtil" %>
<%@ page import="database.DBQuery" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
<%
	DateUtil dateUtil = new DateUtil();
	String idDespesa = request.getParameter("id");
	String dataCompra = request.getParameter("dataCompra");
	String idFornecedor = request.getParameter("idFornecedor");
	String endereco = request.getParameter("endereco");
	String cidade = request.getParameter("cidade");
	String bairro = request.getParameter("bairro");
	String CNPJCPF = request.getParameter("CNPJCPF");
	String valor = request.getParameter("valor");
	String numeroParcelas = request.getParameter("numeroParcelas");
	String fazenda = request.getParameter("fazenda");

	// Variáveis para armazenar as datas no formato "yyyy-MM-dd"
	String formattedDataCompra = dateUtil.formatarData(dataCompra);

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
        <a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="informacoesDespesa.jsp">voltar</a>
        <div class="container p-4 bg-light mt-3 border rounded-4">

        <form action="/TCC/ServeletDespesa?acao=atualizarDespesa" method="post">
            <input type="hidden" name="idDespesa" id="idDespesa" value="<%= idDespesa %>">
            <div class="form-group">
                <label for="dataCompra">Data de compra:</label>
                <input type="date" class="form-control" id="dataCompra" name="dataCompra" value="<%= formattedDataCompra  %>" required>
            </div>
            <div class="form-group">
                <label for="idFornecedor">Fornecedor:</label>
                <input type="text" class="form-control" id="idFornecedor" name="idFornecedor" value="<%= idFornecedor %>" required>
            </div>
            <div class="form-group">
                <label for="endereco">Endereco:</label>
                <input type="text" class="form-control" id="endereco" name="endereco" value="<%= endereco %>" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
            </div>
            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" class="form-control" id="cidade" name="cidade" value="<%= cidade %>" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
            </div>
            <div class="form-group">
                <label for="bairro">Bairro:</label>
                <input type="text" class="form-control" id="bairro" name="bairro" value="<%= bairro %>" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
            </div>
            <div class="form-group">
                <label for="CPF">CNPJ:</label>
                <input type="text" class="form-control" id="CPF" name="CPF" value="<%= CNPJCPF %>" required>
            </div>
            <div class="form-group">
                <label for="valor">valor:</label>
                <input type="text" class="form-control" id="valor" name="valor" value="<%= valor %>" required>
            </div>
            <div class="form-group">
                <label for="numParcelasDes">Numero de Parcelas:</label>
                <input type="number" class="form-control" id="numParcelasDes" name="numParcelas" value="<%= numeroParcelas %>" required>
            </div>
			<div class="form-group">
                <label for="fazenda">Nome fazenda:</label>
                <input type="text" class="form-control" id="fazenda" name="fazenda" value="<%= fazenda %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
     </div>   
    </div>
</body>
</html>
