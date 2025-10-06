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
  <title>Informações Animal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class="bg-light">
	
	
	<div class="container p-3">
		<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow">	
				
			<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="MenuAnimais.jsp">voltar</a>
			    <h2 class="pb-2">Informações Animais</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuAnimais.jsp'class='text-decoration-none text-black'>Animais</a> > Informações Animais </h6>
			</div>

			<script>
				$(document).ready(function() {
					$.ajax({
						url: '/TCC/ServeltAnimal?acao=listaAnimais',  // URL do servidor para pegar os animais
						type: 'POST',  // Método de requisição
						dataType: 'json',  // Tipo de resposta esperada
						success: function(listaAnimais) {  // Função de sucesso
							// Iterar sobre os dados retornados
							console.log("Dados recebidos:", listaAnimais);  // Verifique os dados recebidos

						    // Iterar sobre os dados retornados
						    $.each(listaAnimais, function(index, animal) {
						        // Criação do container principal
						        const container = $('<div class="container bg-white p-4 mt-3 border rounded-2 shadow"></div>');

								// Nome do animal
								const titulo = $('<h5></h5>').text('Nome: ' + animal.nomeAnimal);
								container.append(titulo);

								// Sexo do animal
								const sexo = $('<p></p>').text('Sexo: ' + animal.sexoAnimal);
								container.append(sexo);

								// Data de nascimento
								const dataNascimento = $('<p></p>').text('Data de Nascimento: ' + animal.dataNascimentoAnimal);
								container.append(dataNascimento);

								// Cálculo da idade em semanas e anos
								const dataNascimentoAnimal = parseDate(animal.dataNascimentoAnimal); // Função para corrigir a data
								console.log('Data Nascimento Animal:', animal.dataNascimentoAnimal); // Log para depurar
								if (dataNascimentoAnimal) {
									const dataAtual = new Date();
									const diasDeVida = (dataAtual - dataNascimentoAnimal) / (1000 * 3600 * 24); // Diferença em dias
									const idadeEmSemanas = Math.floor(diasDeVida / 7);  // Converte dias para semanas
									const idadeEmAnos = (diasDeVida / 365.25).toFixed(1); // Converte dias para anos (com uma precisão de uma casa decimal)

									// Exibe a idade em semanas e anos
									const idadeSemanas = $('<p></p>').text('Idade em Semanas: ' + idadeEmSemanas + ' (Idade em Anos: ' + idadeEmAnos + ')');
									container.append(idadeSemanas);
								} else {
									// Se a data não for válida, exibe um aviso
									const idadeSemanas = $('<p></p>').text('Idade em Semanas: Dados de nascimento inválidos');
									container.append(idadeSemanas);
								}

								const fazenda = $('<p></p>').text('Fazenda: ' + animal.fazenda);
								container.append(fazenda);
								
								const granja = $('<p></p>').text('Granja: ' + animal.granja);
								container.append(granja);
								
								// Pai do animal
								const pai = $('<p></p>').text('Pai: ' + animal.paiAnimal);
								container.append(pai);

								// Mãe do animal
								const mae = $('<p></p>').text('Mãe: ' + animal.maeAnimal);
								container.append(mae);

								// Preço do animal
								const preco = $('<p></p>').text('Preço Animal: ' + animal.precoAnimal);
								container.append(preco);

								// Vendedor
								const vendedor = $('<p></p>').text('Vendedor: ' + animal.vendedor);
								container.append(vendedor);

								// Data de compra
								const dataCompra = $('<p></p>').text('Data de Compra: ' + animal.dataCompra);
								container.append(dataCompra);

								// Dados extras
								const dadosExtras = $('<p></p>').text('Dados extras: ' + animal.dadosExtra);
								container.append(dadosExtras);

								// Botão de Editar
								const botaoEditar = $('<a></a>').text('Editar')
									.attr('href', 'editarAnimal.jsp?id=' + animal.idAnimal + '&nome=' + animal.nomeAnimal + '&sexo=' + animal.sexoAnimal + '&nasc=' + animal.dataNascimentoAnimal + '&fazenda=' + animal.fazenda +'&granja=' + animal.granja + '&pai=' + animal.paiAnimal + '&mae=' + animal.maeAnimal + '&vendedor=' + animal.vendedor + '&preco=' + animal.precoAnimal + '&compra=' + animal.dataCompra + '&extra=' + animal.dadosExtra)
									.addClass('btn btn-primary my-2 w-50')
									.css('margin-left', '25%');
								container.append(botaoEditar);

								// Botão de Descartar
								const botaoDescart = $('<a></a>').text('DescartarAnimal')
									.attr('href', 'descarteAnimal.jsp?id=' + animal.idAnimal)
									.addClass('btn btn-danger my-2 w-50')
									.css('margin-left', '25%');
								container.append(botaoDescart);
								
								//Confirmar Saída
								const botaoSaida = $('<a></a>').text('Confirmar Saída')
								.attr('href', 'saidaAnimal.jsp?id=' + animal.idAnimal)
								.addClass('btn btn-danger my-2 w-50')
								.css('margin-left', '25%');
								container.append(botaoSaida);

								// Formulário para Deletar
								const formExcluir = $('<form></form>')
									.attr('method', 'POST')
									.attr('action', '/TCC/ServeltAnimal?acao=deletarAnimais&id=' + animal.idAnimal);
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
						error: function(xhr, status, error) {  // Função de erro
							console.log('Erro: ' + error);
						}
					});
				});

				// Função para garantir que a data seja interpretada corretamente
				function parseDate(dateString) {
					console.log('Parse Date Input:', dateString); // Log para depurar

					// Mapeamento de meses
					const meses = {
						"jan.": 0, "fev.": 1, "mar.": 2, "abr.": 3, "maio": 4, "jun.": 5, "jul.": 6, "ago.": 7, "set.": 8, "out.": 9, "nov.": 10, "dez.": 11
					};

					// Formato esperado: "nov. 11, 2024"
					const partes = dateString.split(' ');

					if (partes.length === 3) {
						const mes = meses[partes[0].toLowerCase()];
						const dia = parseInt(partes[1], 10);
						const ano = parseInt(partes[2], 10);

						if (mes !== undefined) {
							// Cria uma nova data
							return new Date(ano, mes, dia);
						}
					}
					return null; // Se o formato não for válido, retorna null
				}
			</script>
		</div>
	</div>
</body>
</html>
