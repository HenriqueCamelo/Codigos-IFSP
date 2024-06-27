<?php
 include_once "cabecalho.php";
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
   <title>Sysexemplo - Cadastro de funcionario</title>
</head>
<body>
   <main>
   <div class="row">
         
         <div class="col s12 m6 push-m3">
         <h3 class="light">Cadastro de funcionarios</h3>
         <form action="cadastrar_func.php" method="post">
         
            
            <div class="input-field col s12">
               <label for="nome">Nome: </label><br>
               <input type="text" name="txtnome" id="nome">
            </div>
            
            <div class="input-field col s12">
               <label for="senha">Senha: </label><br>
               <input type="text" name="txtsenha" id="senha">
            </div>
            
            <div class="input-field col s12">
               <label for="data">Email: </label><br>
               <input type="text" name="txtemail" id="email">
            </div>

            <div class="input-field col s12">
               <label for="data">Cargo: </label><br>
               <input type="text" name="txtcargo" id="cargo">
            </div>

            <div class="input-field col s12">
               <label for="data">Usuario: </label><br>
               <input type="text" name="txtusuario" id="usuario">
            </div>

            <div class="input-field col s12">
               <label for="data">Foto: </label><br>
               <input type="text" name="txtfoto" id="foto">
            </div>


            <button type="submit" class="btn" name="btncadastrar">Cadastrar </button>            
            <a href="listar_func.php" class="btn blue">Voltar</a>         
         </form> 
      </div>
   </div>
   </main>
</body>
</html>

<?php
include_once "rodape.php";
?>