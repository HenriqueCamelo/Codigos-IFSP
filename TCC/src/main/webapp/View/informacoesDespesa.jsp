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
  <title>Informações Despesa</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
		<div class="container ">
			<div class="container p-4 bg-light mt-3 border rounded-4">	
				
				
				
				<div class="container p-3 rounded-3">
					<h3>Informações Despesa</h3>
				</div>
				
				<a  class="p-3 my-3 w-100" href="MenuDespesas.jsp">Voltar</a>
				<script>
				async function InfomaçõesDespesa() {
					const response = await fetch("/TCC/ServeletDespesa?acao=listaDespesas", {
						method: "POST",
					});
					
					const listaDespesas = await response.json();
					
					listaDespesas.forEach((despesa) => {
					      
					      // Criação do container principal
					      const container = document.createElement("div");
					      container.className = "container p-4 bg-light mt-3 border rounded-4";
	
					      // Data da Compra
					      const dataCompra = document.createElement("h5");
					      dataCompra.textContent = `Data da Compra:`+despesa.dataCompra;
					      container.appendChild(dataCompra);
	
					      // Fornecedor
					      const fornecedor = document.createElement("p");
					      fornecedor.textContent = `Fornecedor: ` + despesa.idFornecedor;
					      container.appendChild(fornecedor);
	
					      // Endereço
					      const endereco = document.createElement("p");
					      endereco.textContent = `Endereço: ` + despesa.endereco;
					      container.appendChild(endereco);
	
					      // Cidade
					      const cidade = document.createElement("p");
					      cidade.textContent = `Cidade: ` + despesa.cidade;
					      container.appendChild(cidade);
	
					      // Bairro
					      const bairro = document.createElement("p");
					      bairro.textContent = `Bairro: ` + despesa.bairro;
					      container.appendChild(bairro);
	
					      // CNPJ/CPF
					      const cnpjCpf = document.createElement("p");
					      cnpjCpf.textContent = `CNPJ/CPF: ` + despesa.CNPJCPF;
					      container.appendChild(cnpjCpf);
	
					      // Valor
					      const valor = document.createElement("p");
					      valor.textContent = `Valor: ` + despesa.valor;
					      container.appendChild(valor);
	
					      // Número de Parcelas
					      const numeroParcelas = document.createElement("p");
					      numeroParcelas.textContent = `Número de Parcelas: ` + despesa.numeroParcelas;
					      container.appendChild(numeroParcelas);
	
					      // Botão de Editar
					      const botaoEditar = document.createElement("a");
					      botaoEditar.textContent = "Editar";
					      botaoEditar.href = `editarDespesa.jsp?id=` + despesa.idDespesa+`&dataCompra=`+despesa.dataCompra+`&idFornecedor=`+despesa.idFornecedor+`&endereco=`+despesa.endereco+`&cidade=`+despesa.cidade+`&CNPJCPF=`+despesa.CNPJCPF+`&valor=`+despesa.valor+`&numeroParcelas=`+despesa.numeroParcelas+`&bairro=`+despesa.bairro;
					      botaoEditar.className = "btn btn-danger my-2 w-50";
					      botaoEditar.style.marginLeft = "25%";
					      container.appendChild(botaoEditar);
	
					      // Botão de Deletar
					      const formExcluir = document.createElement("form");
					      formExcluir.method = "POST";
					      formExcluir.action = "/TCC/ServeletDespesa?acao=deletarDespesa&id=" + despesa.idDespesa;
					      const submitButtonExcluir = document.createElement("button");
					      submitButtonExcluir.textContent = "Deletar";
					      submitButtonExcluir.className = "btn btn-warning my-2 w-50";
					      submitButtonExcluir.style.marginLeft = "25%";
					      submitButtonExcluir.type = "submit";
					      formExcluir.appendChild(submitButtonExcluir);
					      
					      container.appendChild(formExcluir);
					      
					      // Adiciona o container ao corpo da página
					      document.body.appendChild(container);
					      console.log(despesa.dataCompra)
					    });
					
				}
				
				InfomaçõesDespesa();
				</script>
				
				
			</div>
		</div>
</body>
</html>
