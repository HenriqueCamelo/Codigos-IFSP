<%@page import="java.sql.ResultSet"%>
<%@page import="database.DBQuery"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Editar Animal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<% 
    	String idAnimalStr = request.getParameter("idAnimal");
    	int idAnimal = Integer.parseInt(idAnimalStr);	
	
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
		
		DBQuery query = new DBQuery("animal","idAnimal,nomeAnimal,sexoAnimal,dataNascimentoAnimal,foto,paiAnimal,maeAnimal,vendedor,precoAnimal,dataCompra,dadosExtra","idAnimal");
		
		String[] editaranimal = {
				idAnimalStr,
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
		query.update(editaranimal);
	%>
</body>
</html>