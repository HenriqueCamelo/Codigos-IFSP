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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <title>Sucesso</title>
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
<?php

    if($_POST['cxproduto']!="")
    {
        include_once '../factory/conexao.php';
        
        $produto = $_POST['cxproduto'];
        $datavalidade = $_POST['cxdatavalidade'];
        $qtde = $_POST['cxqtd'];
        $valor = $_POST['cxvalor'];
        $sql = "insert into tbproduto(produto,datavalidade,qtde,valor) values('$produto', '$datavalidade', '$qtde', '$valor')";
        $query = mysqli_query($conn, $sql);
        echo "<tr><td>Dados cadastrados com sucesso!</td></tr>";


    }
    else
    {

        echo"Dados não cadastrados";
    }


    echo' <tr><td><a href="../view/menu.php">Voltar</a></td></tr>';

?>
</table>
</div>
</body>
</html>