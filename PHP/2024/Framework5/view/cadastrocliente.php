<!DOCTYPE html>
<html lang="pt-br">
<head>

<?php
        session_start();
        if(!isset($_SESSION['login']) == true && !isset($_SESSION['senha']) == true){
            header('location: ../index.php');
        }

        $logado = $_SESSION['login'];
    ?>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <title>Cadastro do cliente</title>
</head>
<body>
<div class="logado">
    <?php
    echo "Perfil: ". $logado;
    echo "<br><a href = 'sair.php'> Sair </a>";
    ?>
</div>
    <div class="ilha">
        
        <form action="../model/inserircliente.php" method= "POST">
            <h1>Cadastro de cliente</h1>
            <table>
            <tr>
            <td>Nome:</td>
            <td><input type="text" name="cxnome" required></td>
            </tr>
            <tr>
            <td>E-mail:</td>
            <td><input type="email" name= "cxemail" required></td>
            </tr>
            <tr>
            <td><input type="submit" value = "Gravar" class="submit"></td>
        </form>

        <td><a href="../model/listarcliente.php">Listar clientes</a></td>
        </tr>

        <tr>
        <td><a href="menu.php">Voltar</a></td>
        <tr>
        </table>

    </div>


</body>
</html>