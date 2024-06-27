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
        
    <title>Forms Cadastro de Cliente</title>
</head>
<body>
    <main>
    <div class = "row">
        
        <div class = "col s12 m6 push-m3">
        <h1> Cadastro de Cliente</h1>
        
        <form action="cadastrar_cliente_meu.php" method = "post">  
        
            
            <div class="input-field col s12">
            <label for="usuario">Insira o nome para seu usuario: </label>
            <input type="text" name = "txtnome" id ="usuario" >
            </div>
            
            <div class="input-field col s12">
            <label for="celular">Insira o número de seu celular: </label>
            <input type="text" name = "txtcel" id ="celular" >
            </div>
            
            <div class="input-field col s12">
            <label for="data">Insira sua data de nascimento: </label>
            <input type="date" name = "txtnascimento" id ="data" >
            </div>
            
            <div class="input-field col s12">
            <label for="senha">Insira uma senha: </label>
            <input type="text" name = "txtsenha" id ="senha" >
            </div>
            
            <div class="input-field col s12">
            <label for="verificacao">Insira sua senha novamente: </label>
            <input type="text" name = "txtverificacao" id ="verificacao" >
            </div>
            
            <button type = "submit" class = "btn" name = "btncadastro">Cadastrar</button>
            <a href="listagem_meu.php" class = "btn blue">Voltar</a>

        </form>
        </div>

    </div>
    </main>
</body>
</html>

<?php
    include_once "rodape.php";
?>