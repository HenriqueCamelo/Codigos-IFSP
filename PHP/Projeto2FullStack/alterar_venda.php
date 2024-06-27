<?php
require_once 'config.php';
include 'cabecalho.php';

$codigo = $_GET['id'];
$consulta = $conexao->prepare('SELECT * FROM tb_vendas where vendaNum = :code');
$consulta->bindValue(':code', $codigo);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        
    <title>Alterar Produto</title>
</head>
<body>
    <?php echo "Cadastro: {$linha['vendaNum']}";?>
    <form action="alterar_venda_action.php" method = "post">

            <!--código do produto-->
            <input type="hidden" name="txtvnum" value="<?php echo "{$linha['vendaNum']}"?>">
    
            <!--Tipo do produto-->   
            <div class="input-field col s12">
            <label for="tipo">Tipo do produto: </label><br>
            <input type="text" name="txtvtipo" id="tipo"  value = "<?php  echo "{$linha['vendaTipo']}"?>">
            </div>
    
            <!--Preço do produto-->
            <div class="input-field col s12">
               <label for="preco">Preço: </label><br>
               <input type="number" name="txtvpreco" id="preco" value = "<?php  echo "{$linha['vendaPreco']}"?>">
            </div>

            <!--Quantidade de produtos-->
            <div class="input-field col s12">
               <label for="qnt">Quantidade do produto: </label><br>
               <input type="number" name="txtvqnt" id="qnt" value = "<?php  echo "{$linha['vendaQnt']}"?>">
            </div>

            <!--Fornecedor do Produto-->
            <div class="input-field col s12">
               <label for="dia">Dia: </label><br>
               <input type="date" name="txtvdia" id="dia" value = "<?php  echo "{$linha['vendaDia']}"?>">
            </div>



            <!--botões de controle -->
         <button type="submit" class="btn" name="btncadastrar">Alterar </button>
         <a href="lista_venda.php" class="btn green">Listar compras</a>




    
    </form>
</body>
</html>

<?php

include 'rodape.php';

?>