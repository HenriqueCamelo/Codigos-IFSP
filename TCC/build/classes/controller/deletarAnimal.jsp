<%@page import="java.sql.ResultSet"%>
<%@page import="database.DBQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String idAnimalStr = request.getParameter("id");
	int idAnimal = Integer.parseInt(idAnimalStr);
	
	DBQuery dbQuery = new DBQuery("animal", "idAnimal", "idAnimal");
	ResultSet rs = dbQuery.select("idAnimal = " + idAnimal);
	
	String [] deletarAnimal = {
		idAnimalStr
	};
	
	dbQuery.delete(deletarAnimal);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>