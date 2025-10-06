<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String idAnimal = request.getParameter("id");
    String nomeAnimal = request.getParameter("nome");
    String sexoAnimal = request.getParameter("sexo");
    String dataNascimentoAnimal = request.getParameter("nasc");
    String foto = request.getParameter("fotinha");
    String paiAnimal = request.getParameter("pai");
    String maeAnimal = request.getParameter("mae");
    String vendedor = request.getParameter("vendedor");
    String precoAnimal = request.getParameter("preco");
    String dataCompra = request.getParameter("compra");
    String dadosExtra = request.getParameter("extra");

    // Variáveis para armazenar as datas no formato "yyyy-MM-dd"
    String formattedDataNascimentoAnimal = "";
    String formattedDataCompra = "";

    try {
        if (dataNascimentoAnimal != null && !dataNascimentoAnimal.isEmpty()) {
            // Configuração para interpretar datas com abreviações em português
            SimpleDateFormat inputFormat = new SimpleDateFormat("MMM. dd, yyyy", new Locale("pt", "BR"));
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            formattedDataNascimentoAnimal = outputFormat.format(inputFormat.parse(dataNascimentoAnimal));
        }
        if (dataCompra != null && !dataCompra.isEmpty()) {
            // Configuração para interpretar datas com abreviações em português
            SimpleDateFormat inputFormat = new SimpleDateFormat("MMM. dd, yyyy", new Locale("pt", "BR"));
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            formattedDataCompra = outputFormat.format(inputFormat.parse(dataCompra));
        }
    } catch (Exception e) {
        // Log para depuração caso ocorra um erro
        System.out.println("Erro ao converter datas: " + e.getMessage());
        formattedDataNascimentoAnimal = "";
        formattedDataCompra = "";
    }
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
                    <label for="nome">Nome:</label>
                    <input type="text" class="form-control" id="nomeAn" name="nomeAn" value="<%= nomeAnimal %>" required>
                </div>
                <div class="form-group">
                    <label for="sexo">Sexo:</label>
                    <input type="text" class="form-control" id="sexoAn" name="sexoAn" value="<%= sexoAnimal %>" required>
                </div>
                <div class="form-group">
                    <label for="dataNascimento">Data de Nascimento:</label>
                    <input type="date" class="form-control" id="dataNascAn" name="dataNascAn" value="<%= formattedDataNascimentoAnimal %>" required>
                </div>
                <div class="form-group">
                    <label for="foto">Foto:</label>
                    <input type="text" class="form-control" id="fotoAn" name="fotoAn" value="<%= foto %>" required>
                </div>
                <div class="form-group">
                    <label for="pai">Pai:</label>
                    <input type="text" class="form-control" id="paiAn" name="paiAn" value="<%= paiAnimal %>" required>
                </div>
                <div class="form-group">
                    <label for="mae">Mãe:</label>
                    <input type="text" class="form-control" id="maeAn" name="maeAn" value="<%= maeAnimal %>" required>
                </div>
                <div class="form-group">
                    <label for="vendedor">Vendedor:</label>
                    <input type="text" class="form-control" id="vendedorAn" name="vendedorAn" value="<%= vendedor %>" required>
                </div>
                <div class="form-group">
                    <label for="preco">Preço:</label>
                    <input type="number" class="form-control" id="precoAn" name="precoAn" value="<%= precoAnimal %>" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="dataCompra">Data de Compra:</label>
                    <input type="date" class="form-control" id="dataCompraAn" name="dataCompraAn" value="<%= formattedDataCompra %>" required>
                </div>
                <div class="form-group">
                    <label for="dadosExtra">Dados Extras:</label>
                    <input type="text" class="form-control" id="dadosExtraAn" name="dadosExtraAn" value="<%= dadosExtra %>">
                </div>
                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>
        </div>
    </div>
</body>
</html>
