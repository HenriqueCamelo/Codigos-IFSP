<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$codigo = $_GET['id'];
$consulta = $conexao->prepare('SELECT * FROM tb_cadas where cadId = :code');
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
    <?php echo "Cadastro: {$linha['cadId']}"; ?>
    <form action="alterar_cliente_action_meu.php" method = "post">
            
            <!--código do usuario-->
            <input type="hidden" name="txtid" value="<?php echo "{$linha['cadId']}"?>">
            
            <!--nome do usuario-->
            <div class="input-field col s12">
                <label for="nome">Nome: </label><br>
                <input type="text" name="txtnome" id="usuario" value="<?php echo "{$linha['cadNome']}"?>">
            </div>
            
            <!--Celular do usuario-->
            <div class=" input-field col s12">
                <label for="fone">Celular: </label><br>
                <input type="text" name="txtcel" id="celular" value="<?php echo "{$linha['cadCel']}"?>">
            </div>
            
            <!--data de nascimento do usuario-->
            <div class=" input-field col s12">
                <label for="data">Data Nascimento: </label><br>
                <input type="date" name="txtnascimento" id="data" value="<?php echo "{$linha['cadDataNasc']}"?>">
            </div>

            <!--Senha do usuario-->
            <div class=" input-field col s12">
                <label for="senha">Senha: </label><br>
                <input type="text" name="txtsenha" id="senha" value="<?php echo "{$linha['cadSenha']}"?>">
            </div>

            <!--Verificação da senha-->
            <div class=" input-field col s12">
                <label for="verificacao">Verificação: </label><br>
                <input type="text" name="txtverificacao" id="verificacao" value="<?php echo "{$linha['cadVerificacao']}"?>">
            </div>

            <!--botões de controle -->
         <button type=" submit" class="btn" name="btncadastro">Alterar </button>
         <a href="listagem_meu.php" class="btn blue">Voltar</a>




    </form>
    </main>
</body>
</html>

<?php
include_once "rodape.php";
?>