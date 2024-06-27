<?php
include 'config.php'; 
include 'cabecalho.php';
?>


<!DOCTYPE html>
<html lang="pt-br">
<head>

   <meta charset="UTF-8">
   
   <title>Login de Funcionários</title>

   

</head>

<body>


<main>
      <div>

        <h3 class="light">Login de Funcionários</h3>

        <form action="#" method="post">
            
            <div class="input-field col s12">
               <label for="usuario">Usuário: </label><br>
               <input type="text" name="txtloginusuariofunc" id="loginusuariofunc">

            <div class="LGFsenha">
               <label for="data">Senha: </label><br>
               <input type="password" name="txtloginsenhafunc" id="loginsenhafunc" maxlength="10">
            </div>

            <button type="submit" class="btn" name="confirmar">Confirmar</button>
            <button type="submit" class="btn" name="cancelar">Cancelar</button>
        </form>
</main>



 
</body>
</html>


<?php

include_once 'config.php';

if(isset($_POST['cancelar']))
  {
    header('Location:cancelarlogin.php');
  }

if(isset($_POST['confirmar']))
{
    session_start(); 
    function erro()
    {
        $_SESSION['erro'] = 0;
    }

    if(isset($_POST['cancelar']))
    {
        erro();
        session_destroy();
        header('Location:cancelarlogin.php');
    }

    $usuario = filter_input(INPUT_POST, 'txtloginusuariofunc'); 
    $senha = filter_input(INPUT_POST, 'txtloginsenhafunc'); 

    $sql = "SELECT * from tabfuncionarios WHERE funUsuario LIKE :usuario AND funSenha LIKE :senha";
    $consulta = $conexao->prepare($sql);
    $consulta->bindParam(':usuario', $usuario);
    $consulta->bindParam(':senha', $senha);
    $consulta->execute();
    


    $sucesso = false;

    while ($registro = $consulta->fetch(PDO::FETCH_ASSOC)) 
    {
        $sucesso = true;
    }

    if (!$sucesso) 
    {
        echo "Erro no login!";

        $_SESSION['erro'] += 1;
    } 
    else 
    {
        header('Location: botoes.php');

    }

    if ($_SESSION['erro'] == 3) 
    {
        erro();
        session_destroy();
        header('Location: bloqueioLogin.php');

        
    }

}
?>


<?php

include 'rodape.php';

?>