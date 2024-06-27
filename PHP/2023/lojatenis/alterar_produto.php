<?php
require_once 'configuracao.php';

$codigo = $_GET['id'];
$consulta = $conexao->prepare('SELECT * FROM tabprodutos where proId = :code');
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
    <?php echo "Cadastro: {$linha['proId']}";?>
    <form action="alterar_produto_action.php" method = "post">

            <!--código do produto-->
            <input type="hidden" name="txtid" value="<?php echo "{$linha['proId']}"?>">
    
            <!--Tipo do produto-->   
            <div class="input-field col s12">
            <label for="tipo">Descrição do produto: </label><br>
            <input type="text" name="txtdesc" id="descr"  value = "<?php  echo "{$linha['proDescricao']}"?>">
            </div>
    
            <!--Preço do produto-->
            <div class="input-field col s12">
               <label for="img">Imagem: </label><br>
               <input type="text" name="txtimg" id="img" value = "<?php  echo "{$linha['proImagem']}"?>">
            </div>

            <!--Quantidade de produtos-->
            <div class="input-field col s12">
               <label for="qnt">Preço: </label><br>
               <input type="number" name="txtpreco" id="preco" value = "<?php  echo "{$linha['proPreco']}"?>">
            </div>

            

           

            <!--botões de controle -->
         <button type="submit" class="btn" name="btncadastrar">Alterar </button>
         <a href="lista.php" class="btn green">Listar produto</a>




    
    </form>
</body>
</html>