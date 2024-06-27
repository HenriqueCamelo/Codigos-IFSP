<html lang="en">
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
    <title>Pesquisa Cliente</title>
</head>
<body>
<div class="logado">
    <?php
    echo "Perfil: ". $logado;
    echo "<br><a href = 'sair.php'> Sair </a>";
    ?>
</div>
    <div class="ilha">
        <form method="POST" action="../model/pesquisanomecliente.php">
        <h1>Pesquisa de clientes</h1>
            <table>
                <tr>
                    <td>Digite o nome completo: </td>
                    <td><input type="text" name="cxpesquisacliente" required><td>
                </tr>
                <tr>
                    <td><input type="submit" value="Pesquisar" class="submit"></td>
                
        </form>
        <td><a href="menu.php">Voltar</a></td>
        </tr>

    </table>
</body>
</html>