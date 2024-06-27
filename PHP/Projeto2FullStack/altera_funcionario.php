<?php
require_once "config.php";
require_once "cabecalho.php";

$codigo = $_GET['id'];
$consulta = $conexao->prepare('SELECT * FROM tabfuncionarios WHERE funId = :code');
$consulta->bindValue(':code', $codigo);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">
   <!-- Compiled and minified CSS -->

   <!--Import Google Icon Font-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <title>Cadastro de Funcionários</title>
</head>
<body>
<main>

   <div>
      <h3 class="light">Alterando Funcionários</h3>

      <?php echo "Funcionário: {$linha['funId']}"; ?>

      <form action="altera_funcionario_action.php" method="post">
         <!--código do cliente-->

         <input type="hidden" name="txtidfunc" value="<?php echo "{$linha['funId']}"; ?>">
         <!--nome do cliente-->

         <div class="input-field col s12">
            <label for="nomefunc">Nome: </label><br>
            <input type="text" name="txtnomefunc" id="nomefunc" value="<?php echo "{$linha['funNome']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="senhafunc">Senha: </label><br>
            <input type="text" name="txtsenhafunc" id="senhafunc" value="<?php echo "{$linha['funSenha']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="emailfunc">Email: </label><br>
            <input type="email" name="txtemailfunc" id="emailfunc" value="<?php echo "{$linha['funEmail']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="cargofunc">Cargo: </label><br>
            <input type="text" name="txtcargofunc" id="cargofunc" value="<?php echo "{$linha['funCargo']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="fotofunc">Foto: </label><br>
            <input type="text" name="txtfotofunc" id="fotofunc" value="<?php echo "{$linha['funFoto']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="usuariofunc">Usuario: </label><br>
            <input type="text" name="txtusuariofunc" id="usuariofunc" value="<?php echo "{$linha['funUsuario']}"; ?>">
         </div>


         <!--botões de controle -->
         <button type=" submit" class="btn" name="btnalterar">Alterar </button>
         <a href="listar_funcionarios.php" class="btn green">Listar Funcionarios</a>
      </form>



<main>
</body>
</html>

<?php

include 'rodape.php';

?>