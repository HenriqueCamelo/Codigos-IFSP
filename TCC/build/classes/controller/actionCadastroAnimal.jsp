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
				
		String nomeAn = request.getParameter("nomeAn");
		
		String sexoAn = request.getParameter("sexoAn");
		
// 		Date dataNascAn = (Date) request.getSession().getAttribute("dataNascAn");
		
		String dataNascAn = request.getParameter("dataNascAn");

		String fotoAn = request.getParameter("fotoAn");
		
		String paiAn = request.getParameter("paiAn");
		
		String maeAn = request.getParameter("maeAn");
		
		String vendedorAn = request.getParameter("vendedorAn");
		
		String precoAn = request.getParameter("precoAn");
		
		//Date dataCompraAn = (Date) request.getSession().getAttribute("dataCompraAn");
		String dataCompraAn = request.getParameter("dataCompraAn");
		
		String dadosExtraAn = request.getParameter("dadosExtraAn");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ou outro formato desejado
		
		DBQuery query = new DBQuery("animal","nomeAnimal,sexoAnimal,dataNascimentoAnimal,foto,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra","idAnimal");
		
		String[] novoanimal = {
				nomeAn,
				sexoAn,
				dataNascAn,
				fotoAn,
				paiAn,
				maeAn,
				vendedorAn,
				precoAn,
				dataCompraAn,
				dadosExtraAn
			};
		query.insert(novoanimal);
	%>
</body>
</html>