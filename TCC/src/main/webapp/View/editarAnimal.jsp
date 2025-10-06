<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="model.DateUtil" %>
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

	String idAnimal = request.getParameter("id");
    String nomeAnimal = request.getParameter("nome");
    String sexoAnimal = request.getParameter("sexo");
    String dataNascimentoAnimal = request.getParameter("nasc");
    String fazenda = request.getParameter("fazenda");
    String granja = request.getParameter("granja");
    String paiAnimal = request.getParameter("pai");
    String maeAnimal = request.getParameter("mae");
    String vendedor = request.getParameter("vendedor");
    String precoAnimal = request.getParameter("preco");
    String dataCompra = request.getParameter("compra");
    String dadosExtra = request.getParameter("extra");

    String formattedDataNascimentoAnimal = dateUtil.formatarData(dataNascimentoAnimal);
	String formattedDataCompra = dateUtil.formatarData(dataCompra);
    
%>
<html>
<head>
  <title>Editar Animal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container mt-4">
        <h2>Editar Animal</h2>
        <a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="informacoesAnimal.jsp">voltar</a>
        <div class="container p-4 bg-light mt-3 border rounded-4">

        
            
            <form action="/TCC/ServeltAnimal?acao=atualizarAnimais" method="post">
                <input type="hidden" name="idAnimal" id="idAnimal" value="<%= idAnimal %>">
                <div class="form-group">
                    <label for="nomeAn">Nome:</label>
                    <input type="text" class="form-control" id="nomeAn" name="nomeAn" value="<%= nomeAnimal %>" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
                </div>
                <div class="mb-3">
						  <label for="sexoAn">Sexo:</label>
						  <select class="form-control bg-light" id="sexoAn" name="sexoAn" required>
						    <option value="<%= sexoAnimal %>"> <%= sexoAnimal %> </option>
						    <option value="macho">Macho</option>
						    <option value="femea">Fêmea</option>
						  </select>
				</div>
                <div class="form-group">
                    <label for="dataNascAn">Data de Nascimento:</label>
                    <input type="date" class="form-control" id="dataNascAn" name="dataNascAn" value="<%= formattedDataNascimentoAnimal %>" required>
                </div>
                <div class="form-group">
                    <label for="fazenda">Fazenda:</label>
                    <input type="text" class="form-control" id="fazenda" name="fazenda" value="<%= fazenda %>" required>
                </div>
                <div class="form-group">
                    <label for="granja">Granja:</label>
                    <input type="text" class="form-control" id="granja" name="granja" value="<%= granja %>" required>
                </div>
                <div class="form-group">
                    <label for="paiAn">Pai:</label>
                    <input type="text" class="form-control" id="paiAn" name="paiAn" value="<%= paiAnimal %>" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
                </div>
                <div class="form-group">
                    <label for="maeAn">Mãe:</label>
                    <input type="text" class="form-control" id="maeAn" name="maeAn" value="<%= maeAnimal %>" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
                </div>
                <div class="form-group">
                    <label for="vendedorAn">Vendedor:</label>
                    <input type="text" class="form-control" id="vendedorAn" name="vendedorAn" value="<%= vendedor %>" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
                </div>
                <div class="form-group">
                    <label for="precoAn">Preço:</label>
                    <input type="number" class="form-control" id="precoAn" name="precoAn" value="<%= precoAnimal %>" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="dataCompraAn">Data de Compra:</label>
                    <input type="date" class="form-control" id="dataCompraAn" name="dataCompraAn" value="<%= formattedDataCompra %>" required>
                </div>
                <div class="form-group">
                    <label for="dadosExtraAn">Dados Extras:</label>
                    <input type="text" class="form-control" id="dadosExtraAn" name="dadosExtraAn" value="<%= dadosExtra %>">
                </div>
                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>
        </div>
    </div>
</body>
</html>
