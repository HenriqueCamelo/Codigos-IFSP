<%@page import="java.sql.ResultSet"%>
<%@page import="database.DBQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import=" java.time.LocalDate"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String idDespesaStr = request.getParameter("idDespesa");
    int idDespesa = Integer.parseInt(idDespesaStr);
	
	String dataCompraDes = request.getParameter("dataCompra");
	
	String fornecedorDes = request.getParameter("idFornecedor");
	
	String enderecoDes = request.getParameter("endereco");
	
	String cidadeDes = request.getParameter("cidade");
	
	String bairroDes = request.getParameter("bairro");
	
	String CPFDes = request.getParameter("CPF");
	
	String valorDes = request.getParameter("valor");
	
	String numParcelasDes = request.getParameter("numParcelas");
		
	DBQuery query = new DBQuery("despesas","idDespesa,dataCompra, idFornecedor, endereco, cidade, bairro, CNPJCPF, valor, numeroParcelas","idDespesa");
	
	String[] atualizardespesa = {
			idDespesaStr,
			dataCompraDes,
			fornecedorDes,
			enderecoDes,
			cidadeDes,
			bairroDes,
			CPFDes,
			valorDes,
			numParcelasDes,
		};	
		
	query.update(atualizardespesa);
	
	DBQuery query3 = new DBQuery("fornecedordespesa","idFornecedorDespesa, idFornecedor,idDespesa","idFornecedorDespesa");
	
	ResultSet rs = query3.select("idDespesa = " + idDespesa);
	
	String idFornecedorDespesa = "";
	
    if (rs != null && rs.next()) {
        idFornecedorDespesa = rs.getString("idFornecedorDespesa");
    }

    if (rs != null) {
        rs.close();
    }	
	String[] atualizarfornecedordespesa = {
			idFornecedorDespesa,
			fornecedorDes,
			idDespesaStr
		};	
	
	query3.update(atualizarfornecedordespesa);

	%>
</body>
</html>