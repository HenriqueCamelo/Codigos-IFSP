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
<main>
      <div>
         <h3 class="light">Produto </h3>
         <form action="vendas_cadastrar.php" method="post">
            
            <!--Tipo do produto-->   
            <div class="input-field col s12">
            <label for="tipo">Tipo do produto: </label><br>
            <!-- <input type="radio" name="txtipo" id="Monociclo">Monociclo
            <input type="radio" name="txtipo" id="Bicicleta">Bicicleta
            <input type="radio" name="txtipo" id="Triciclo">Triciclo
            <input type="radio" name="txtipo" id="Quadriciclo">Quadriciclo
            <input type="radio" name="txtipo" id="Quintociclo">Quintociclo -->
            <input type="text" name="txtvtipo" id="ventipo">
            </div>

            <!--Preço do produto-->
            <div class="input-field col s12">
               <label for="preco">Preço: </label><br>
               <input type="number" name="txtvpreco" id="venpreco">
            </div>

            <!--Quantidade de produtos-->
            <div class="input-field col s12">
               <label for="qnt">Quantidade do produto: </label><br>
               <input type="number" name="txtvqnt" id="venqnt">
            </div>

            <!--Fornecedor do Produto-->
            <div class="input-field col s12">
               <label for="vendata">Data da compra: </label><br>
               <input type="date" name="txtvdata" id="vendata">
            </div>

            
            <style>
            .botoes{
            justify-content: center;
            display: grid;
            grid-template-columns: 200px 200px;
            }
            </style>

            <div class="botoes">
            <button type="submit" class="btn" name="btncadastrar">Comprar </button>            
            <a href="lista_venda.php" class="btn green">Listar compras</a>        
            </div>
            <br><br>
            </form>
         </main>
         </body>
         </html>
<?php

include 'rodape.php';

?>