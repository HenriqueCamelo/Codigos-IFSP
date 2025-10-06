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
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
    
<% 
	int contadorAnimal = 0;
	float contadorVacina = 0;	
	float totalPeso = 0;
	float despesaTotal= 0;
	long idadeSemanas = 0;
	long idadeSemanasTotal = 0;
	float numerodeDespesas = 0;
	int semanaInterv1 = 0;
	int semanaInterv2 = 0;
	int semanaInterv3 = 0;
	int semanaInterv4 = 0;
	
	float pesoInterv1 = 0;
	float pesoInterv2 = 0;
	float pesoInterv3 = 0;
	float pesoInterv4 = 0;
	
	DBQuery query = new DBQuery("animal","idAnimal, dataNascimentoAnimal","idAnimal");
	ResultSet rs = query.select("idAnimal > 0");
	while (rs != null && rs.next()){
		String idAnimal = rs.getString("idAnimal");
		contadorAnimal++;
		Date dataNascimentoAnimal = rs.getDate("dataNascimentoAnimal");
		LocalDate localDateNascimento = dataNascimentoAnimal.toLocalDate();
		Period periodo = Period.between(localDateNascimento, LocalDate.now());
		int idadeAnos = periodo.getYears(); // Idade em anos
		idadeSemanas = ChronoUnit.WEEKS.between(localDateNascimento, LocalDate.now());
		idadeSemanasTotal = idadeSemanasTotal + ChronoUnit.WEEKS.between(localDateNascimento, LocalDate.now());
		if(idadeSemanas < 7){
			semanaInterv1++;
		}
		if(idadeSemanas > 7 && idadeSemanas < 17){
			semanaInterv2++;
		}
		if(idadeSemanas > 18 && idadeSemanas < 72){
			semanaInterv3++;
		}
		if(idadeSemanas > 72){
			semanaInterv4++;
		}
	}
	if (rs != null) {
	    rs.close();
	}
	
	DBQuery queryVac = new DBQuery("vacinaAnimal","idVacinaAnimal","idVacinaAnimal");
	ResultSet rs2 = queryVac.select("idVacinaAnimal > 0");
	while (rs2 != null && rs2.next()){
		String idAnimal = rs2.getString("idVacinaAnimal");
		contadorVacina++;
	}
	if (rs2 != null) {
	    rs2.close();
	}
	
	DBQuery queryPes = new DBQuery("peso","pesoAnimal","idPeso");
	ResultSet rs3 = queryPes.select("idPeso > 0");
	while (rs3 != null && rs3.next()){
		float pesoAnimal = rs3.getFloat("pesoAnimal");
		totalPeso = totalPeso + pesoAnimal;
		if(pesoAnimal < 6){
			pesoInterv1++;
		}
		if(pesoAnimal > 0.6 && pesoAnimal < 1.2){
			pesoInterv2++;
		}
		if(pesoAnimal >1.2 && pesoAnimal < 1.8){
			pesoInterv3++;
		}
		if(pesoAnimal > 1.8 && pesoAnimal < 2.4){
			pesoInterv4++;
		}
	}
	if (rs3 != null) {
	    rs3.close();
	}
	
	DBQuery queryDes = new DBQuery("despesas","valor","idDespesa");
	ResultSet rs4 = queryDes.select("idDespesa > 0");
	while (rs4 != null && rs4.next()){
		float pesoAnimal = rs4.getFloat("valor");
		numerodeDespesas++;
		despesaTotal = despesaTotal + pesoAnimal;
	}
	if (rs4 != null) {
	    rs4.close();
	}
	float mediaDespesa = despesaTotal/numerodeDespesas;
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
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- Importação do Chart.js -->
</head>
<body>
		<div class="container ">
			<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
				
				<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser" href="MenuPrincipal.jsp">Voltar</a>
			    <h2 class="pb-2">Relatório</h2>
			    <h6 class="pb-2 border-bottom"> 
			    	<a href='MenuPrincipal.jsp' class='text-decoration-none text-black'>Menu Principal</a> >  Relatório 
			    </h6>
				</div>
			
				<!-- Informações numéricas -->
				<p> Número de galinhas: <%= contadorAnimal %></p>
				<p> Número de vacinas: <%= contadorVacina %></p>
				<p> Total de peso: <%= totalPeso %></p>
				<p> Total despesa: <%= despesaTotal %></p>
				<p> Média de despesa: <%= mediaDespesa %></p>
			
				<!-- Gráfico de Pizza: Distribuição da idade -->
				<h4>Distribuição da Idade em Semanas</h4>
				<canvas id="idadeChart"></canvas>

				<!-- Gráfico de Barras: Distribuição do Peso -->
				<h4>Distribuição do Peso por Intervalo</h4>
				<canvas id="pesoChart"></canvas>

				<!-- Gráfico de Linha: Evolução das Despesas -->
				<h4>Evolução das Despesas</h4>
				<canvas id="despesaChart"></canvas>
			</div>
		</div>

<script>
	// Dados vindos do JSP
	var idadeData = [<%= semanaInterv1 %>, <%= semanaInterv2 %>, <%= semanaInterv3 %>, <%= semanaInterv4 %>];
	var pesoData = [<%= pesoInterv1 %>, <%= pesoInterv2 %>, <%= pesoInterv3 %>, <%= pesoInterv4 %>];
	var despesaTotal = <%= despesaTotal %>;
	var mediaDespesa = <%= mediaDespesa %>;

	// Gráfico de Pizza: Distribuição da Idade
	var ctxIdade = document.getElementById('idadeChart').getContext('2d');
	new Chart(ctxIdade, {
	    type: 'pie',
	    data: {
	        labels: ['0-7 semanas', '7-17 semanas', '18-72 semanas', '+72 semanas'],
	        datasets: [{
	            data: idadeData,
	            backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#4CAF50']
	        }]
	    }
	});

	// Gráfico de Barras: Distribuição do Peso
	var ctxPeso = document.getElementById('pesoChart').getContext('2d');
	new Chart(ctxPeso, {
	    type: 'bar',
	    data: {
	        labels: ['0 - 0,6kg', '0,6 - 1,2kg', '1,2 - 1,8kg', '1,8 - 2,4kg'],
	        datasets: [{
	            label: 'Quantidade',
	            data: pesoData,
	            backgroundColor: ['#FF5733', '#33FF57', '#3357FF', '#F4C542']
	        }]
	    }
	});

	// Gráfico de Linha: Evolução das Despesas
	var ctxDespesa = document.getElementById('despesaChart').getContext('2d');
	new Chart(ctxDespesa, {
	    type: 'line',
	    data: {
	        labels: ['Total de Despesas', 'Média de Despesa'],
	        datasets: [{
	            label: 'Valor R$',
	            data: [despesaTotal, mediaDespesa],
	            borderColor: '#42A5F5',
	            fill: false
	        }]
	    }
	});
</script>

</body>
</html>
