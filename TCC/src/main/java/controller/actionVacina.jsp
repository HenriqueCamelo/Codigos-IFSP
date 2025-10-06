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
	
	String dataVac = request.getParameter("dataVac");
	
	String vacina = request.getParameter("vacina");
	
	DBQuery query = new DBQuery("vacinaAnimal","idAnimal,dataVacina,idVacina","idVacinaAnimal");
	
	String[] novavacina = {
			idAn,
			dataVac,
			vacina
		};	
		
	query.insert(novavacina);

	
	
	%>
</body>
</html>