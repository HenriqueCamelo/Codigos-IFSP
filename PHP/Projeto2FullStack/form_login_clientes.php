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
   <title>Login</title>
</head>
<body>
  <main>

      <div class="col s12 m6 push-m3">
        <h3 class="light">Login</h3>
        <form action="#" method="post">
            
            <div class="input-field col s12">
               <label for="nome">Nome: </label><br>
               <input type="text" name="txtnome" id="nome">

            <div class="input-field col s12">
               <label for="senha">Senha: </label><br>
               <input type="password" name="txtsenha" id="senha" maxlength="10">
            </div>


            <button type="submit" class="btn" name="btnlogin">Login </button>
            <button type="submit" class="btn" name="btncadastrar">Não tenho conta - Cadastrar </button>
        </form>

</main>
</body>
</html>

<?php
  require_once 'config.php';

  if(isset($_POST['btncadastrar'])){
  header('Location:form_cadastrar_clientes.php');
  }

if(isset($_POST['btnlogin'])){
    session_start(); 
    function erro(){
    $_SESSION['erro'] = 0;
    }

    if(isset($_POST['btncadastrar'])){
      erro();
      session_destroy();
      header('Location:form_cadastrar_clientes.php');
      }

    $Nome = filter_input(INPUT_POST, 'txtnome'); 
    $senha = filter_input(INPUT_POST, 'txtsenha'); 

    $sql = "SELECT * from tb_clientes WHERE cliNome LIKE :Nome AND cliSenha LIKE :senha";
    $consulta = $conexao->prepare($sql);
    $consulta->bindParam(':Nome', $Nome);
    $consulta->bindParam(':senha', $senha);
    $consulta->execute();
    
    $teste = 1;

    while($registro = $consulta->fetch(PDO::FETCH_ASSOC)){
        $teste = 0;
      }

    if($teste == 1){

      $_SESSION['erro'] = $_SESSION['erro'] + 1;
        echo "Erro no login!";


    } else {
      erro();
      session_destroy();
      header('Location:lista_produtos.php');
    }

    if($_SESSION['erro'] == 3){

        erro();
        session_destroy();
        header('Location:sem_acesso.php');
    }
}

?>
<?php

include 'rodape.php';

?>