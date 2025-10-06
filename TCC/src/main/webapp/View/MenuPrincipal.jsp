<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>
<!DOCTYPE html>
<html>
<head>
  <title>Menu</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-success">
		<div class="container-fluid">
			<a class="navbar-brand mx-auto" href="#">GranjaManagements</a>
			<form action="<%= request.getContextPath() %>/LogoutServlet" method="get">
    			<button type="submit" class="btn btn-danger">Sair</button>
			</form>
		</div>
	</nav>

	<% 
        // Recupera o tipo de usuário armazenado na sessão
        Integer tipoUsuario = (Integer) session.getAttribute("tipoUsuario");
        boolean isTipoZero = (tipoUsuario != null && tipoUsuario == 0); // Verifica se o tipo é 0 (usuário regular)
    %>

	<div class="p-4 p-md-5 text-white bg-dark">
		<div class="col-md-6 px-0">
			<% 
				// Recupera o nome do usuário armazenado na sessão
				String nomeFazenda = (String) session.getAttribute("nomeFazenda");
			%>
			
			<!-- Exibe o nome do usuário no topo do menu -->
			<% if (nomeFazenda != null) { %>
				<h1 class="display-4 fst-italic">Fazenda de <%= nomeFazenda %>!</h1>
			<% } %>
			
			
			<% 
				// Recupera o nome do usuário armazenado na sessão
				String nomeUsuario = (String) session.getAttribute("nome");
			%>
			
			<!-- Exibe o nome do usuário no topo do menu -->
			<% if (nomeUsuario != null) { %>
				<p class="lead my-3">Bem-vindo, <%= nomeUsuario %>!</p>
			<% } %>
		</div>
	</div>

	<div class="container px-4 py-5" id="hanging-icons">
		<h2 class="pb-2 border-bottom">Gerenciamento</h2>
		<div class="row g-4 py-5 row-cols-1 row-cols-lg-3 justify-content-center">
			<div class="col container d-flex align-items-center justify-content-center bg-white shadow-lg rounded border border-1 btn m-1 p-5">
				<a href="MenuAnimais.jsp" class="text-decoration-none">
					<div class="icon-square flex-shrink-0 me-3">🐔</div>
					<div class="text-dark">
						<h2>Animais</h2>
					</div>
				</a>
			</div>

			<%-- Verifica o tipo de usuário antes de mostrar as opções --%>
			<% if (!isTipoZero) { %>
				<div class="col container d-flex align-items-center justify-content-center bg-white shadow-lg rounded border border-1 btn m-1 p-5">
					<a href="Relatorio.jsp" class="text-decoration-none">
						<div class="icon-square flex-shrink-0 me-3">📊</div>
						<div class="text-dark">
							<h2>Relatórios</h2>
						</div>
					</a>
				</div>

				<div class="col container d-flex align-items-center justify-content-center bg-white shadow-lg rounded border border-1 btn m-1 p-5">
					<a href="MenuFuncionarios.jsp" class="text-decoration-none">
						<div class="icon-square flex-shrink-0 me-3">👨‍🌾👩‍🌾</div>
						<div class="text-dark">
							<h2>Funcionarios</h2>
						</div>
					</a>
				</div>

				<div class="col container d-flex align-items-center justify-content-center bg-white shadow-lg rounded border border-1 btn m-1 p-5">
					<a href="MenuDespesas.jsp" class="text-decoration-none">
						<div class="icon-square flex-shrink-0 me-3">🧾</div>
						<div class="text-dark">
							<h2>Despesas</h2>
						</div>
					</a>
				</div>
			<% } %>  <!-- Fim do if para esconder as opções de tipo 0 -->

		</div>
	</div>

</body>
</html>
