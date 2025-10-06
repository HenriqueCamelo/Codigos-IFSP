<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>

<% 
		// Recupera o nome do usuário armazenado na sessão
		String nomeFazenda = (String) session.getAttribute("nomeFazenda");
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
		    		<a class="navbar-brand mx-auto " href="#">GranjaManagements</a>
		  		</div>
		</nav>
		
		<div class="container ">
			<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
				
			<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="MenuFuncionarios.jsp">voltar</a>
			    <h2 class="pb-2">Cadastro Funcionário</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuFuncionarios.jsp'class='text-decoration-none text-black'>Menu Funcionarios</a> > Cadastrar Funcionário </h6>
			</div>
				
				<div class="mb-3 mt-3">
					 <form action="/TCC/ServletFuncionario?acao=cadastrarfuncionario" method="post">
					    <label for="nomeFuncionario">Nome Funcionario:</label>
					    <input type="text" class="form-control bg-light" id="nomeFuncionario" placeholder="Insira o nome do funcionario" name="nomeFuncionario" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					  	
					    
					    <div class="mb-3">
						  <label for="sexoFuncionario">Sexo:</label>
						  <select class="form-control bg-light" id="sexoFuncionario" name="sexoFuncionario" required>
						    <option value="">Selecione</option>
						    <option value="masculino">Masculino</option>
						    <option value="feminino">Feminino</option>
						  </select>
						</div>
					    
					    <input type="hidden" class="form-control bg-light" value="<%= nomeFazenda %>" id="fazendaFuncionario" name="fazendaFuncionario" required>
					    					    
					    <label for="nascFuncionario">Data de Nascimento:</label>
					    <input type="date" class="form-control bg-light" id="nascFuncionario" placeholder="Data de nascimento" name="nascFuncionario" required>
					  	
					  	<label for="cpfFuncionario">CPF:</label>
					    <input type="text" class="form-control bg-light" id="cpfFuncionario" placeholder="Insira o CPF" name="cpfFuncionario" required pattern="\d{11}" maxlength="11" title="Digite exatamente 11 números do CPF, sem pontos ou traços.">
					    
					  	<label for="bancoFuncionario">Banco:</label>
					    <input type="text" class="form-control bg-light" id="bancoFuncionario" placeholder="Insira o numero do banco do funcionario" name="bancoFuncionario" required pattern="\d{10}" maxlength="10" title="Digite exatamente 10 números do seu banco, sem pontos ou traços.">
					    
					    <label for="telFuncionario">Telefone:</label>
					    <input type="text" class="form-control bg-light" placeholder="Insira o telefone do funcionario" id="telFuncionario" placeholder="" name="telFuncionario" required pattern="\d{9}" maxlength="9" title="Digite exatamente 9 números do telefone, sem pontos ou traços.">
					    
					  	
					  	<br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    	<input id="linkCadUser" style="margin-left:25%" class="btn btn-danger my-2 w-50 " href="#" type="reset" value="Cancelar">
					  </form> 
				</div>
			</div>
		</div>
</body>
</html>