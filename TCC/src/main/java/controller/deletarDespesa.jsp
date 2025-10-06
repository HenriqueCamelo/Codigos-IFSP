<%@page import="java.sql.ResultSet"%>
<%@page import="database.DBQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
	String idDespesaStr = request.getParameter("id");
	int idDespesa = Integer.parseInt(idDespesaStr);
	
	DBQuery dbQueryFornDes = new DBQuery("fornecedordespesa", "idFornecedorDespesa, idDespesa", "idFornecedorDespesa");
	ResultSet rs1 = dbQueryFornDes.select("idDespesa = " + idDespesa);
	
	String idFornecedorDespesa = "";
	
	if (rs1 != null && rs1.next()) {
        idFornecedorDespesa = rs1.getString("idFornecedorDespesa");
    }

    if (rs1 != null) {
        rs1.close();
    }
	
	String [] deletarForneDespesa = {
			idFornecedorDespesa,
			idDespesaStr
	};
	
	dbQueryFornDes.delete(deletarForneDespesa);
	
	DBQuery dbQueryDes = new DBQuery("despesas", "idDespesa", "idDespesa");
	ResultSet rs2 = dbQueryDes.select("idDespesa = " + idDespesa);
	
	String [] deletarDespesa = {
		idDespesaStr
	};
	
	dbQueryDes.delete(deletarDespesa);
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