
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
<body>
	<div class="container">
		<div class="container p-4 bg-light mt-3 border rounded-4">
			<div class="container p-3 rounded-3">
				<h3>Informações Animal</h3>
				<a id="linkCadUser"  class=" my-2 w-50 " style="margin-left:3%" href="MenuAnimais.jsp">voltar</a>
				
			</div>

			<script>
				async function informaçõesAnimais() {
					const response = await fetch("/TCC/ServeltAnimal?acao=listaAnimais", {
						method: "POST",
					});

					const listaAnimais = await response.json();

					listaAnimais.forEach((animal) => {
				
						
						// Criação do container principal
						const container = document.createElement("div");
						container.className = "container p-4 bg-light mt-3 border rounded-4";

						//Nome do animal
						const titulo = document.createElement("h5");
						titulo.textContent = `Nome: `+animal.nomeAnimal;
						container.appendChild(titulo);
						
						// Sexo do animal
						const sexo = document.createElement("p");
						sexo.textContent = `Sexo: `+animal.sexoAnimal;
						container.appendChild(sexo);

						// Data de nascimento
						const dataNascimento = document.createElement("p");
						dataNascimento.textContent = `Data de Nascimento: `+animal.dataNascimentoAnimal;
						container.appendChild(dataNascimento);

						
						// Pai do animal
						const pai = document.createElement("p");
						pai.textContent = `Pai: `+animal.paiAnimal;
						container.appendChild(pai);

						// Mãe do animal
						const mae = document.createElement("p");
						mae.textContent = `Mãe: `+animal.maeAnimal;
						container.appendChild(mae);

						// Preço do animal
						const preco = document.createElement("p");
						preco.textContent = `Preço Animal: `+animal.precoAnimal;
						container.appendChild(preco);

						// Vendedor
						const vendedor = document.createElement("p");
						vendedor.textContent = `Vendedor: `+animal.vendedor;
						container.appendChild(vendedor);

						// Data de compra
						const dataCompra = document.createElement("p");
						dataCompra.textContent = `Data de Compra: `+animal.dataCompra;
						container.appendChild(dataCompra);

						// Dados extras
						const dadosExtras = document.createElement("p");
						dadosExtras.textContent = `Dados Extras: `+animal.dadosExtra;
						container.appendChild(dadosExtras);

						// Botão de Editar
						const botaoEditar = document.createElement("a");
						botaoEditar.textContent = "Editar";
						botaoEditar.href = `editarAnimal.jsp?id=`+animal.idAnimal+`&nome=`+animal.nomeAnimal+`&sexo=`+animal.sexoAnimal+`&nasc=`+animal.dataNascimentoAnimal+`&fotinha=`+animal.foto+`&pai=`+animal.paiAnimal+`&mae=`+animal.maeAnimal+`&vendedor=`+animal.vendedor+`&preco=`+animal.precoAnimal+`&compra=`+animal.dataCompra+`&extra=`+animal.dadosExtra;
						botaoEditar.className = "btn btn-danger my-2 w-50";
						botaoEditar.style.marginLeft = "25%";
						container.appendChild(botaoEditar);
						
						const botaoDescart = document.createElement("a");
						botaoDescart.textContent = "DescartarAnimal";
						botaoDescart.href = `descarteAnimal.jsp?id=`+animal.idAnimal;
						botaoDescart.className = "btn btn-danger my-2 w-50";
						botaoDescart.style.marginLeft = "25%";
						container.appendChild(botaoDescart);

						// Botão de Deletar

						const formExcluir = document.createElement("form");
						formExcluir.method = "POST";
		                formExcluir.action = "/TCC/ServeltAnimal?acao=deletarAnimais&id="+animal.idAnimal
						const submitButtonExcluir = document.createElement("button");
		                submitButtonExcluir.textContent = "Deletar";
		                submitButtonExcluir.className = "btn btn-warning my-2 w-50";
		                submitButtonExcluir.style.marginLeft = "25%";
		                submitButtonExcluir.type = "submit";
						formExcluir.appendChild(submitButtonExcluir)
						container.appendChild(formExcluir)
						
						// Adiciona o container ao corpo da página
						document.body.appendChild(container);
						console.log(animal.dataCompra)
					});
				}

				// Chamar a função para renderizar os animais
				
				informaçõesAnimais();
			</script>
		</div>
	</div>
</body>
</html>