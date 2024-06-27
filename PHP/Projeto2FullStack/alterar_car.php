<?php
require_once 'config.php';
include 'cabecalho.php';

$codigo = $_GET['id'];

echo $codigo;

$consulta = $conexao->prepare('SELECT * FROM tabcarrinho where carProId = :code');
$consulta->bindValue(':code', $codigo);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>

    <form action="alterar_car_action.php" method = "post">

            <!--código do produto-->
            <input type="hidden" name="txtid" value="<?php echo "{$linha['carProId']}"?>">
    
            <!--Tipo do produto-->   
            <div class="qtd">
            <label for="qtd">Tipo do produto: </label><br>
            <input type="number" name="txtqtd" id="qtd"  value = "<?php echo "{$linha['carQtde']}"?>">
            </div>

            <!--botões de controle -->
         <button type="submit" class="btn" name="btncadastrar">Alterar</button>
         <a href="carrinho.php?codigo=" class="btn">Carrinho</a>

    </form>
</body>
</html>

<?php

include 'rodape.php';

?>