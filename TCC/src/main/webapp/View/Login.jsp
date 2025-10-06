<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
	  <div class="container-fluid">
	    <a class="navbar-brand mx-auto text-bg-primary" href="#">Logo</a>
	  </div>
	</nav>
    

	<div  id="frmLoginArea" class="container mx-auto ">
	
	    <form action="/TCC/LoginServlet" method="post">
	        
	    <div class="mb-3 mt-3">
	        <label for="email">Email:</label>
	        <input type="email" class="form-control" id="email" name="email" required>
		</div>
		
		<div class="mb-3">
	        <label for="senha">Senha:</label>
	        <input type="password" class="form-control" id="senha" name="senha" required>
		</div>
	        <button type="submit" style="margin-left:25%" class="btn btn-success w-50 ">Entrar</button>
	    
	    
	    </form>
	</div>
    <% if(request.getParameter("erro") != null) { %>
        <p style="color: red;">Email ou senha inválidos!</p>
    <% } %>
</body>
</html>
