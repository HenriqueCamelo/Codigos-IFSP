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
	
	int pesoInterv1 = 0;
	int pesoInterv2 = 0;
	int pesoInterv3 = 0;
	int pesoInterv4 = 0;
	
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
		if(idadeSemanas < 6){
			semanaInterv1++;
		}
		if(idadeSemanas > 6 && idadeSemanas < 9){
			semanaInterv2++;
		}
		if(idadeSemanas > 9 && idadeSemanas < 11){
			semanaInterv3++;
		}
		if(idadeSemanas > 11 && idadeSemanas < 12){
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
		if(pesoAnimal > 6 && pesoAnimal < 9){
			pesoInterv2++;
		}
		if(pesoAnimal > 9 && pesoAnimal < 11){
			pesoInterv3++;
		}
		if(pesoAnimal > 11 && pesoAnimal < 12){
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
</head>
<body>
		<div class="container ">
			<div class="container p-4 bg-light mt-3 border rounded-4">	
				
				<div class="container p-3 rounded-3">
					<h3>Informações Animal</h3>
				</div>
			
				<p> Número de galinhas: <%= contadorAnimal %></p>
				<p> Número de vacinas: <%= contadorVacina %></p>
				<p> Total de peso: <%= totalPeso %></p>
				<p> Total peso: <%= pesoInterv1 %></p>
				<p> Total peso: <%= pesoInterv2 %></p>
				<p> Total peso: <%= pesoInterv3 %></p>
				<p> Total peso: <%= pesoInterv4 %></p>
				<p> Total despesa: <%= despesaTotal %></p>
				<p> Total idade em semanas: <%= idadeSemanasTotal %></p>
				<p> Total idade em semanas: <%= semanaInterv1 %></p>
				<p> Total idade em semanas: <%= semanaInterv2 %></p>
				<p> Total idade em semanas: <%= semanaInterv3 %></p>
				<p> Total idade em semanas: <%= semanaInterv4 %></p>
				<p> Media despesa: <%= mediaDespesa %></p>
			
			</div>
		</div>
</body>
</html>