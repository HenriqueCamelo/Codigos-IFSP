<?php
require_once "cabecalho.php";
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">
   <!-- Compiled and minified CSS -->

   <!--Import Google Icon Font-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <title>Cadastro</title>
</head>
<body>

      <div>
        <h3 class="light">Cadastro</h3>
        <form action="cadastrar_clientes.php" method="post">
            <div class="input-field col s12">

               <label for="nome">Nome: </label><br>
               <input type="text" name="txtnome" id="nome">
            </div>
            <div class="input-field col s12">
               <label for="fone">Telefone: </label><br>
               <input type="text" name="txtfone" id="fone">
            </div>
            <div class="input-field col s12">
               <label for="data">Data Nascimento: </label><br>
               <input type="date" name="txtdatanasc" id="data">
            <div class="input-field col s12">
               <label for="cpf">CPF: </label><br>
               <input type="number" name="txtcpf" id="cpf" >
            </div>
            <div class="input-field col s12">
               <label for="cep">CEP: </label><br>
               <input type="number" name="txtcep" id="cep" >
            </div>
            <div class="input-field col s12">
               <label for="email">E-Mail: </label><br>
               <input type="email" name="txtemail" id="email">
            </div>
            <div class="input-field col s12">
               <label for="senha">Senha: </label><br>
               <input type="password" name="txtsenha" id="senha">
            </div>
            <div class="input-field col s12">
               <label for="repsenha">Repetir senha: </label><br>
               <input type="password" name="txtrepsenha" id="repsenha">
            </div>

            </div>
            <button type="submit" class="btn" name="btncadastrar">Cadastrar </button>
            <a href="form_login_clientes.php" class="btn green">Já tenho conta - Fazer Login</a>
        </form>

</body>
</html>

<?php
include 'rodape.php';
?>