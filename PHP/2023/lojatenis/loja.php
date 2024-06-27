<?php
include_once 'cabecalho.php';

?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">
   <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
   <link rel="stylesheet" href="css/estilos.css">
   <!--Import Google Icon Font-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <title>Sysexemplo - Cadastro de produto</title>
</head>
<body>
   <main> 
   <div class="row">
      <div class="col s12 m6 push-m3">
         <h3 class="light">Cadastro de produto</h3>
         <form action="cadastrar_produto.php" method="post">
            
            <div class="input-field col s12">
               <label for="descricacao">Descriçaõ: </label><br>
               <input type="text" name="txtdescricao" id="descricacao">


            </div>
            <div class="input-field col s12">
               <label for="imagem">Imagem: </label><br>
               <input type="text" name="txtimagem" id="imagem">
            </div>
            <div class="input-field col s12">
               <label for="preco">Preço: </label><br>
               <input type="text" name="txtpreco" id="preco">


            </div>
            <button type="submit" class="btn" name="btncadastrar">Cadastrar </button>            
            <a href="lista_produtos.php" class="btn green">Listar clientes</a>         
         </form> 
      </div>
</main>
</body>
</html>
<?php
include_once 'rodape.php';

?>