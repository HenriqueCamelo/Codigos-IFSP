<%@page import="java.sql.ResultSet"%>
<%@page import="database.DBQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.temporal.ChronoUnit"%>

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
    
<%
    String status = request.getParameter("status");
    String erro = request.getParameter("msg");
    out.print(MensagemUtil.gerarAlerta(status, erro));
%>
<!DOCTYPE html>
<html>
<head>
  <title>Informações Despesa</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	

	
	<div class="container ">
		<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow">	
				
			<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="MenuDespesas.jsp">voltar</a>
			    <h2 class="pb-2">Informações Despesas</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a>> <a href= 'MenuDespesas.jsp'class='text-decoration-none text-black'>Despesas</a> > Informações Despesas </h6>
			</div>
			
			<script>
				$(document).ready(function() {
					$.ajax({
						url: '/TCC/ServeletDespesa?acao=listaDespesas', // URL do servidor para pegar as despesas
						type: 'POST', // Método de requisição
						dataType: 'json', // Tipo de resposta esperada
						success: function(listaDespesas) { // Função de sucesso
							// Itera sobre cada despesa retornada
							$.each(listaDespesas, function(index, despesa) {
								// Criação do container principal
								const container = $('<div class="container bg-white p-4 mt-3 border rounded-2 shadow"></div>');

								// Data da Compra
								const dataCompra = $('<h5></h5>').text('Data da Compra: ' + despesa.dataCompra);
								container.append(dataCompra);

								// Fornecedor
								const fornecedor = $('<p></p>').text('Fornecedor: ' + despesa.idFornecedor);
								container.append(fornecedor);

								// Endereço
								const endereco = $('<p></p>').text('Endereço: ' + despesa.endereco);
								container.append(endereco);

								// Cidade
								const cidade = $('<p></p>').text('Cidade: ' + despesa.cidade);
								container.append(cidade);

								// Bairro
								const bairro = $('<p></p>').text('Bairro: ' + despesa.bairro);
								container.append(bairro);

								// CNPJ/CPF
								const cnpjCpf = $('<p></p>').text('CNPJ/CPF: ' + despesa.CNPJCPF);
								container.append(cnpjCpf);

								// Valor
								const valor = $('<p></p>').text('Valor: ' + despesa.valor);
								container.append(valor);

								// Número de Parcelas
								const numeroParcelas = $('<p></p>').text('Número de Parcelas: ' + despesa.numeroParcelas);
								container.append(numeroParcelas);
								
								// Nome da Fazenda
								const fazenda = $('<p></p>').text('Fazenda: ' + despesa.fazenda);
								container.append(fazenda);

								// Botão de Editar
								const botaoEditar = $('<a></a>').text('Editar')
									.attr('href', 'editarDespesa.jsp?id=' + despesa.idDespesa + '&dataCompra=' + despesa.dataCompra + '&idFornecedor=' + despesa.idFornecedor + '&endereco=' + despesa.endereco + '&cidade=' + despesa.cidade + '&CNPJCPF=' + despesa.CNPJCPF + '&valor=' + despesa.valor + '&numeroParcelas=' + despesa.numeroParcelas + '&bairro=' + despesa.bairro + '&fazenda=' + despesa.fazenda)
									.addClass('btn btn-danger my-2 w-50')
									.css('margin-left', '25%');
								container.append(botaoEditar);

								// Botão de Deletar
								const formExcluir = $('<form></form>')
									.attr('method', 'POST')
									.attr('action', '/TCC/ServeletDespesa?acao=deletarDespesa&id=' + despesa.idDespesa);
								const submitButtonExcluir = $('<button></button>')
									.text('Deletar')
									.addClass('btn btn-warning my-2 w-50')
									.css('margin-left', '25%')
									.attr('type', 'submit');
								formExcluir.append(submitButtonExcluir);
								container.append(formExcluir);

								// Adiciona o container ao corpo da página
								$('body').append(container);
							});
						},
						error: function(xhr, status, error) { // Função de erro
							console.log('Erro ao carregar despesas: ' + error);
						}
					});
				});
			</script>
				
		</div>
	</div>
</body>
</html>
