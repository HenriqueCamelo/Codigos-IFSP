<%@page import="java.sql.ResultSet"%>
<%@page import="database.DBQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String idAn = request.getParameter("idAn");
	
	String dataPes = request.getParameter("dataPes");
	
	String pesagem = request.getParameter("pesagem");
	
	DBQuery query = new DBQuery("peso","idAnimal,dataPesagem,pesoAnimal","idPeso");
	
	String[] novapesagem = {
			idAn,
			dataPes,
			pesagem
		};	
		
	query.insert(novapesagem);

	%>
</body>
</html>