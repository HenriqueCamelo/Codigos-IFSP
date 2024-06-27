<?php
include_once 'cabecalho.php';

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">
   <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
   <link rel="stylesheet" href="css/estilos.css">
   <!--Import Google Icon Font-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <title>Sysexemplo - Cadastro de Clientes</title>
</head>
<body>
<main>
   <div class="row">
      <div class="col s12 m6 push-m3">
         <h3 class="light">Cadastro de clientes</h3>
         <form action="cadastrar_cliente.php" method="post">
            

               <label for="nome">Nome: </label><br>
               <input type="text" name="txtnome" id="nome">

            
               <label for="fone">Telefone: </label><br>
               <input type="text" name="txtfone" id="fone">
            
            
               <label for="data">Data Nascimento: </label><br>
               <input type="date" name="txtdatanasc" id="data">

            
            <button type="submit" class="btn" name="btncadastrar">Cadastrar </button>            
            <a href="listar.php" class="btn green">Listar clientes</a>         
         </form> 
      </div>
</main>     
</body>
</html>

<?php
include_once "rodape.php";
?>

