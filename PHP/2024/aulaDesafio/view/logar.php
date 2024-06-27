<?php 
    include_once "../factory/conexao.php";
    session_start();

if(isset($_POST['cxlogin']) && !empty($_POST['cxlogin']) && isset($_POST['cxsenha']) && !empty($_POST['cxsenha']) && isset($_POST['cxusu']) && !empty($_POST['cxusu']))
{

    require "../control/funcionarios.php";

    $f = new Funcionarios();

        $login = $_POST['cxlogin'];
        $senha = $_POST['cxsenha'];
        $usuario = $_POST['cxusu'];

    if($f->entrar($login, $senha, $usuario) == true)
    {
        if(isset($_SESSION['idAnselmo'])){
            header("Location: telaPrincipal.php"); 
            
        }
        else
        {
            header("Location: teladeErro.php");
        }
        
    }
    else
    {
        header("Location: teladeErro.php");  
    }
}
else
{
        header("Location: ../index.php");  
}


?>