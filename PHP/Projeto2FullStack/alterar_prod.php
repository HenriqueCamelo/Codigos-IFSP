<?php
require_once 'config.php';
include 'cabecalho.php';

$codigo = $_GET['id'];
$consulta = $conexao->prepare('SELECT * FROM tb_produto where prodId = :code');
$consulta->bindValue(':code', $codigo);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    
    <title>Alterar Produto</title>
</head>
<body>
   <main>
    <?php echo "Cadastro: {$linha['prodId']}";?>
    <form action="alterar_prod_action.php" method = "post">

            <!--código do produto-->
            <input type="hidden" name="txtid" value="<?php echo "{$linha['prodId']}"?>">
    
            <!--Tipo do produto-->   
            <div class="input-field col s12">
            <label for="tipo">Tipo do produto: </label><br>
            <input type="text" name="txtipo" id="tipo"  value = "<?php  echo "{$linha['prodTipo']}"?>">
            </div>
    
            <!--Preço do produto-->
            <div class="input-field col s12">
               <label for="preco">Preço: </label><br>
               <input type="number" name="txtpreco" id="preco" value = "<?php  echo "{$linha['prodPreco']}"?>">
            </div>

            <!--Quantidade de produtos-->
            <div class="input-field col s12">
               <label for="qnt">Quantidade do produto: </label><br>
               <input type="number" name="txtqnt" id="qnt" value = "<?php  echo "{$linha['prodQnt']}"?>">
            </div>

            <!--Fornecedor do Produto-->
            <div class="input-field col s12">
               <label for="forn">Fornecedor do produto: </label><br>
               <input type="text" name="txtforn" id="forn" value = "<?php  echo "{$linha['prodForn']}"?>">
            </div>

            <!--Unidade em que o produto foi fornecido-->
            <div class="input-field col s12">
               <label for="unidade">Local da unidade em que o produto foi vendido: </label><br>
               <input type="number" name="txtunidade" id="unidade" value = "<?php  echo "{$linha['prodUnidadeLoja']}"?>">
            </div>


            <!--botões de controle -->
         <button type="submit" class="btn" name="btncadastrar">Alterar </button>
         <a href="lista_prod.php" class="btn green">Listar produtos</a>




    
    </form>
</main>
</body>
</html>

<?php

include 'rodape.php';

?>