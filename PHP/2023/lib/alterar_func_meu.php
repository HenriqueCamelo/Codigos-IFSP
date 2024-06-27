<?php
require_once "cabecalho.php";
require_once "conf_meu.php";

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
   
   <title>Cadastro de Funcionários</title>
</head>
<body>
<main>
<div class="row">
   <div class="col s12 m6 push-m3">
      <h3 class="light">Alterando Funcionários</h3>

      <?php echo "Funcionário: {$linha['funId']}"; ?>
      <form action="altera_funcionario_action.php" method="post">
         <!--código do cliente-->

         <input type="hidden" name="txtId" value="<?php echo "{$linha['funId']}"; ?>">
         <!--nome do cliente-->

         <div class="input-field col s12">
            <label for="nome">Nome: </label><br>
            <input type="text" name="txtNome" id="nome" value="<?php echo "{$linha['funNome']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="senha">Senha: </label><br>
            <input type="text" name="txtSenha" id="senha" value="<?php echo "{$linha['funSenha']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="email">Email: </label><br>
            <input type="email" name="txtEmail" id="email" value="<?php echo "{$linha['funEmail']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="cargo">Cargo: </label><br>
            <input type="text" name="txtCargo" id="cargo" value="<?php echo "{$linha['funCargo']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="foto">Foto: </label><br>
            <input type="text" name="txtFoto" id="foto" value="<?php echo "{$linha['funFoto']}"; ?>">
         </div>

         <div class="input-field col s12">
            <label for="usuario">Usuario: </label><br>
            <input type="text" name="txtUsuario" id="usuario" value="<?php echo "{$linha['funUsuario']}"; ?>">
         </div>


         <!--botões de controle -->
         <button type=" submit" class="btn" name="btnalterar">Alterar </button>
         <a href="listar_func.php" class="btn blue">Voltar</a>
      </form>


   </div>
</main>

</body>
</html>

<?php
require_once "rodape.php";
?>