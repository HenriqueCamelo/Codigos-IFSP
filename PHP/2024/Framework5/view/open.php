<?php
    include_once "../factory/conexao.php";
    session_start();

    $login = $_POST['logemail'];
    $senha = $_POST['logsenha'];

    $sql = "select * from tbusuario where email = '$login' AND senha = '$senha' ";
    $res = mysqli_query($conn, $sql);

    if(mysqli_num_rows($res) > 0){
        $_SESSION['login'] = $login;
        $_SESSION['senha'] = $senha;
        echo"<script>
            alert('Seja bem vindo!');
            window.location.href = 'menu.php';
        </script>";
    }else{
        unset($_SESSION['login']);
        unset($_SESSION['senha']);

        header("Location: errologin.php");

    }

?>