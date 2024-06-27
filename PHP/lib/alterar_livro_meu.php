<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$codigo = $_GET['id'];
$consulta = $conexao->prepare('SELECT * FROM tb_livros where livroId = :code');
$consulta->bindValue(':code', $codigo);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);
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
        
    <title>Alterar Cadastro</title>
</head>
<body>
    <main>
    <?php echo "Cadastro: {$linha['livroId']}"; ?>
    <form action="alterar_livro_action_meu.php" method = "post">
            
            <!--código do usuario-->
            <input type="hidden" name="txtid" value="<?php echo "{$linha['livroId']}"?>">
            
            <!--nome do usuario-->
            <div class="input-field col s12">
                <label for="lnome">Nome do livro: </label><br>
                <input type="text" name="txtnome" id="lnome" value="<?php echo "{$linha['livroNome']}"?>">
            </div>
            
            <!--Celular do usuario-->
            <div class=" input-field col s12">
                <label for="edit">Editora do livro: </label><br>
                <input type="text" name="txtedit" id="edit" value="<?php echo "{$linha['livroEdi']}"?>">
            </div>
            
            <!--data de nascimento do usuario-->
            <div class=" input-field col s12">
                <label for="text">Autor do livro: </label><br>
                <input type="text" name="txtautor" id="autor" value="<?php echo "{$linha['livroAut']}"?>">
            </div>

            <!--Senha do usuario-->
            <div class=" input-field col s12">
                <label for="data">Data de lançamento: </label><br>
                <input type="date" name="txtdata" id="data" value="<?php echo "{$linha['livroDataLan']}"?>">
            </div>

            <div class=" input-field col s12">
                <label for="imge">Capa do livro: </label><br>
                <input type="text" name="txtimge" id="imge" value="<?php echo "{$linha['livroImg']}"?>">
            </div>

            <div class=" input-field col s12">
                <label for="descr">Descricao do livro: </label><br>
                <input type="text" name="txtdescr" id="descr" value="<?php echo "{$linha['livroDescr']}"?>">
            </div>

            <div class=" input-field col s12">
                <label for="descr">Preço do livro: </label><br>
                <input type="text" name="txtpreco" id="preco" value="<?php echo "{$linha['livroPrec']}"?>">
            </div>

            <!--botões de controle -->
         <button type=" submit" class="btn" name="btncadastro">Alterar </button>
         <a href="lista.php" class="btn blue">Voltar</a>




    </form>
    </main>
</body>
</html>

<?php
include_once "rodape.php"
?>