<html lang="pt-BR">
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
    <title>Pesquisar Produto</title>
</head>
<body>
<div class="logado">
    <?php
    echo "Perfil: ". $logado;
    echo "<br><a href = 'sair.php'> Sair </a>";
    ?>
</div>
    <div class="ilha">
            <form method="POST" action="../model/pesquisaproduto.php">
            <h1>Pesquisa de produto</h1>
                <table>
                    <tr>
                        <td>Digite o nome do produto: </td>
                        <td><input type="text" name="cxpesquisaproduto" required></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Pesquisar" name="pesquisa" class="submit"></td>
            </form>
                        <td><a href="menu.php">Voltar</a></td>
                    </tr>
                </table>
    </div>
</body>
</html>