<%@page import="java.sql.ResultSet"%>
<%@page import="database.DBQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import=" java.time.LocalDate"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	
	String idDespesa = "";
	
	String dataCompraDes = request.getParameter("dataCompraDes");
	
	String fornecedorDes = request.getParameter("fornecedorDes");
	
	String enderecoDes = request.getParameter("enderecoDes");
	
	String cidadeDes = request.getParameter("cidadeDes");
	
	String bairroDes = request.getParameter("bairroDes");
	
	String CPFDes = request.getParameter("CPFCNPJDes");
	
	String valorDes = request.getParameter("valorDes");
	
	String numParcelasDes = request.getParameter("numParcelasDes");
	
	
	DBQuery query = new DBQuery("despesas","dataCompra,idFornecedor,endereco,cidade,bairro,CNPJCPF,valor,numeroParcelas","idDespesa");

	String[] novadespesa = {
			dataCompraDes,
			fornecedorDes,
			enderecoDes,
			cidadeDes,
			bairroDes,
			CPFDes,
			valorDes,
			numParcelasDes
		};	
		
	query.insert(novadespesa);
	
	DBQuery querydes = new DBQuery("despesas","idDespesa","idDespesa");
	
	ResultSet rs1 = querydes.select("idDespesa =(SELECT MAX(idDespesa) FROM despesas)");
	
	if (rs1 != null && rs1.next()) {
		idDespesa = rs1.getString("idDespesa");
	}
	if (rs1 != null) {
	    rs1.close();
	}
	
	DBQuery queryfordes = new DBQuery("fornecedorDespesa","idFornecedor,idDespesa","idFornecedorDespesa");
	
	String[] novafordespesa = {
			fornecedorDes,
			idDespesa
		};
	
	queryfordes.insert(novafordespesa);
	
	%>
</body> 
</html> 