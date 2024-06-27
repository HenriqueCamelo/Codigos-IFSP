<?php
 include_once "cabecalho.php";
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        
    <title>Forms Cadastro de Livro</title>
</head>
<body>
    <main>
    <div class = "row">
        <div class = "col s12 m6 push-m3">
        <h1> Cadastro de Livro</h1>
        
        <form action="cadastrar_livro_meu.php" method = "post">  
        
            <div class = "input-field col s12">
            <label for="lnome">Insira o nome do livro: </label>
            <input type="text" name = "txtnome" id ="lnome" >
            </div>

            <div class = "input-field col s12">
            <label for="edit">Insira a editora: </label>
            <input type="text" name = "txtedit" id ="edit" >
            </div>

            <div class = "input-field col s12">
            <label for="autor">Insira o nome do autor: </label>
            <input type="text" name = "txtauto" id ="autor" >
            </div>

            <div class = "input-field col s12">
            <label for="date">Insira a data de lançamento: </label>
            <input type="date" name = "txtdata" id ="data" >
            </div>

            <div class = "input-field col s12">
            <label for="imge">Insira uma imagem: </label>
            <input type="text" name = "txtimge" id ="imge" >
            </div>

            <div class = "input-field col s12">
            <label for="descr">Insira a descrição: </label>
            <input type="text" name = "txtdescr" id ="descr" >
            </div>

            <div class = "input-field col s12">
            <label for="preco">Insira o preço: </label>
            <input type="text" name = "txtpreco" id ="preco" >
            </div>

            
            <button type = "submit" class = "btn" name = "btncadastro">Cadastrar</button>
            <a href="lista.php" class = "btn blue">Voltar</a>

        </form>
        </div>

    </div>
    </main>
</body>
</html>

<?php
include_once "rodape.php";
?>