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
    <meta name="viewport" content="width='device-width', initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <title>Erro</title>
</head>
<body>
<div class="logado">
    <?php
    echo "Perfil: ". $logado;
    echo "<br><a href = 'sair.php'> Sair </a>";
    ?>
</div>
    <div class="ilha">
        <table>
            <tr>
                <td>Erro na pesquisa! Elemento não encontrado!</td>
            </tr>
            <tr>
                <td><a href="menu.php">Voltar</a></td>
            </tr>
        </table>
    </div>
</body>
</html>