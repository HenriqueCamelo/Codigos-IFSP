<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
<!DOCTYPE html>
<html>
<head>
  <title>Informações Funcionarios</title>
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
			    <a id="linkCadUser"  href="MenuFuncionarios.jsp">voltar</a>
			    <h2 class="pb-2">Informações Funcionários</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuFuncionarios.jsp'class='text-decoration-none text-black'>Menu Funcionarios</a> > Informações Funcionários </h6>
				<a class="btn btn-danger" href="CadastrarFuncionario.jsp"> + Adicionar Funcionario</a>
			</div>
			
			
			<script>
				$(document).ready(function() {
					// Requisição AJAX para pegar a lista de funcionários
					$.ajax({
						url: '/TCC/ServletFuncionario?acao=listaFuncionario',
						type: 'POST',
						dataType: 'json',
						success: function(listaFuncionarios) {
							// Itera sobre a lista de funcionários e cria os elementos para cada um
							$.each(listaFuncionarios, function(index, funcionario) {
								// Criação do container principal para cada funcionário
								const container = $('<div class="container bg-white p-4 mt-3 border rounded-2 shadow"></div>');
								
								// Nome do Funcionário
								const nomeFuncionario = $('<h5></h5>').text('Nome: ' + funcionario.nomefun);
								container.append(nomeFuncionario);

								// Sexo
								const sexo = $('<p></p>').text('Sexo: ' + funcionario.sexo);
								container.append(sexo);

								// Data de Nascimento
								const dataNascimento = $('<p></p>').text('Data de Nascimento: ' + funcionario.dataNascimento);
								container.append(dataNascimento);

								// Fazenda de trabalho
								const fazenda = $('<p></p>').text('Fazenda: ' + funcionario.fazenda);
								container.append(fazenda);
								
								// CPF
								const cpf = $('<p></p>').text('CPF: ' + funcionario.CPF);
								container.append(cpf);

								// Banco
								const banco = $('<p></p>').text('Banco: ' + funcionario.banco);
								container.append(banco);

								// Telefone
								const telefone = $('<p></p>').text('Telefone: ' + funcionario.telefone);
								container.append(telefone);

								// Botão de Editar
								const botaoEditar = $('<a></a>')
									.text('Editar')
									.attr('href', 'editarFuncionario.jsp?id=' + funcionario.idFuncionario +
										'&nomefun=' + funcionario.nomefun +
										'&sexo=' + funcionario.sexo +
										'&fazenda=' + funcionario.fazenda +
										'&dataNascimento=' + funcionario.dataNascimento +
										'&CPF=' + funcionario.CPF +
										'&banco=' + funcionario.banco +
										'&telefone=' + funcionario.telefone)
									.addClass('btn btn-danger my-2 w-50')
									.css('margin-left', '25%');
								container.append(botaoEditar);

								// Botão de Deletar
								const formExcluir = $('<form></form>')
									.attr('method', 'POST')
									.attr('action', '/TCC/ServletFuncionario?acao=deletarFuncionario&id=' + funcionario.idFuncionario);
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
						error: function(xhr, status, error) {
							console.log('Erro ao carregar funcionários: ' + error);
						}
					});
				});
			</script>
		</div>
	</div>
</body>
</html>
