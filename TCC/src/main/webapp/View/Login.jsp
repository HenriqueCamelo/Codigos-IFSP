<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String status = request.getParameter("status");
    if ("sucesso".equals(status)) {
%>
        <script type="text/javascript">
            alert("Ação realizado com sucesso!");
        </script>
<%
    } else if ("erro".equals(status)) {
%>
        <script type="text/javascript">
            alert("Erro ao ao fazer login. Verifique dados ou se esta cadastrado !");
        </script>
<%
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

  <!-- Validação JavaScript -->
  <script>
    function validarFormulario() {
      const email = document.getElementById("email").value;
      const senha = document.getElementById("senha").value;
      
      const regex = /['"<>#$%^&*()+=]/; // Expressão regular para verificar caracteres especiais

      if (regex.test(email) || regex.test(senha)) {
        alert("Por favor, não use caracteres especiais como ' \" < > # $ % ^ & * ( ) + =.");
        return false;  // Impede o envio do formulário
      }
      return true;
    }
  </script>
</head>
<body class="bg-success">
   
    <div class="container">
	    <div id="frmLoginArea" class="container p-4 bg-white mt-5 rounded shadow-lg">
	    
	    <div class="container">
	    <p class= "text-center my-5">	    
	    	<img class="p-1 img-thumbnail" src="https://img.icons8.com/ios-filled/24/000000/chicken.png" alt="Logo Galinha">
	    	<h10 class= "text-center">GranjaManagements</h10>
	    </p>
	    </div>
    	
    	<p class= "text-center fs-1">Bem-vindo de volta!</p>
    	<p class= "text-center text-body-tertiary fs-6">Insira suas informações para continuar</p>
	    
	      <!-- Formulário com validação antes do envio -->
	      <form action="/TCC/LoginServlet" method="post" onsubmit="return validarFormulario()">
	          
	          <div class="mb-3 mt-3">
	              <label for="email">Email:</label>
	              <input type="email" class="form-control" id="email" name="email" required>
	          </div>
	          
	          <div class="mb-3">
	              <label for="senha">Senha:</label>
	              <input type="password" class="form-control" id="senha" name="senha" required>
	          </div>
	          
	          <button type="submit" style="margin-left:25%" class="btn btn-success w-50">Entrar</button>
	      	  <br><a style="margin-left:25%" type="button" class="btn btn-light text-primary w-50 fs-6" href="CadastroUsuario.jsp">Cadastrar Usuário </a>
	      	
	      </form>
	    </div>
	</div>
    <!-- Exibição de erro -->
    <% if(request.getParameter("erro") != null) { %>
        <p style="color: red;">Email ou senha inválidos!</p>
    <% } %>
</body>
</html>
