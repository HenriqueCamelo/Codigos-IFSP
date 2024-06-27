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
        <form action="../model/inserirproduto.php" method= "POST">
        <h1>Cadastro de produto</h1>
            <table>
            <tr>
            <td>Produto:</td>
            <td><input type="text" name="cxproduto" required></td>
            </tr>
            <tr>
            <td>Data de validade:</td>
            <td><input type="date" name= "cxdatavalidade" required></td>
            </tr>
            <tr>
            <td>Quantidade:</td>
            <td><input type="number" name= "cxqtd" required></td>
            </tr>
            <tr>
            <td>Valor:</td>
            <td><input type="number" name= "cxvalor" required></td>
            </tr>
            <tr>
            <td><input type="submit" value = "Gravar" class="submit"></td>

           
        </form>

        <td><a href="../model/listarproduto.php">Listar Produtos </a></td>
        </tr>
        <tr>
        <td><a href="menu.php">Voltar</a></td>
        </tr>
            </table>
    </div>
</body>
</html>