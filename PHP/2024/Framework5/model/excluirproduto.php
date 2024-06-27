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
    echo "<br><a href = '../sair.php'> Sair </a>";
    ?>
</div>
<div class="ilha">    
<table>

<?php
    include_once '../factory/conexao.php';

    $cod=$_GET["id"];
    $excluir = "delete from tbproduto where codigo='$cod'";

    $executar = mysqli_query($conn, $excluir);

    if($executar){
        echo"<script>alert('Produto excluido com sucesso');</script>";
        echo' <tr><td><a href="../view/menu.php">Voltar</a></td></tr>';
    }else{
        echo"<script>alert('Dado não encontrado');</script>";
    }
?>

</table>
</div>
</body>
</html>