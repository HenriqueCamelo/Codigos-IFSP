<?php

include 'cabecalho.php';

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">
   <!-- Compiled and minified CSS -->
   <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
   <link rel="stylesheet" href="css/estilos.css">
    --><!--Import Google Icon Font-->
   <!-- <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <title>Sysexemplo - Cadastro de Clientes</title>
 --></head>
<body>
   <div class="row">
      <div class="col s12 m6 push-m3">
         <h3 class="light">Produto </h3>
         <form action="#" method="post">
            
            <!--Tipo do produto-->   
            <div class="input-field col s12">
            <label for="tipo">Tipo do produto: </label><br>
            <!-- <input type="radio" name="txtipo" id="Monociclo">Monociclo
            <input type="radio" name="txtipo" id="Bicicleta">Bicicleta
            <input type="radio" name="txtipo" id="Triciclo">Triciclo
            <input type="radio" name="txtipo" id="Quadriciclo">Quadriciclo
            <input type="radio" name="txtipo" id="Quintociclo">Quintociclo -->
            <input type="text" name="txtipo" id="tipo">
            </div>

            <!--Preço do produto-->
            <div class="input-field col s12">
               <label for="preco">Preço: </label><br>
               <input type="number" name="txtpreco" id="preco">
            </div>

            <!--Quantidade de produtos-->
            <div class="input-field col s12">
               <label for="qnt">Quantidade do produto: </label><br>
               <input type="number" name="txtqnt" id="qnt">
            </div>

            <!--Fornecedor do Produto-->
            <div class="input-field col s12">
               <label for="forn">Fornecedor do produto: </label><br>
               <input type="text" name="txtforn" id="forn">
            </div>

            <!--Unidade em que o produto foi fornecido-->
            <div class="input-field col s12">
               <label for="unidade">Local da unidade em que o produto foi vendido: </label><br>
               <input type="number" name="txtunidade" id="unidade">
            </div>
            <br>
            <style>
            .botoes{
            justify-content: center;
            display: grid;
            grid-template-columns: 200px 200px 200px;
           }
             </style>
            <div class="botoes">
            <button type="submit" class="btn" name="btncadastrar">Cadastrar </button>            
            <a href="lista_prod.php" class="btn green">Listar produtos</a>         
            <a href="../botoes.php" class="btn">Listar funcionalidades</a>
            </div>
            <br>
            </form> </div></body></html>
            <?php

if(isset($_POST['btncadastrar'])){
   header('Location: lista_prod.php');
}

            ?>

<?php

include 'rodape.php';

?>