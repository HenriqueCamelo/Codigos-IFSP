<!DOCTYPE html>
<html lang="pt-br">
<head>
<?php
        session_start();
        if(!isset($_SESSION['login']) == true && !isset($_SESSION['senha']) == true){
            header('location: ../index.php');
        }

        $logado = $_SESSION['login'];
    ?>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <title>Exibir cliente</title>
</head>
<body>
<div class="logado">
    <?php
    echo "Perfil: ". $logado;
    echo "<br><a href = '../view/sair.php'> Sair </a>";
    ?>
</div>
<h1>Listagem de cliente</h1>
    <div class="ilha">
        <?php
        include_once "../factory/conexao.php";
        $pesqnome = $_POST["cxpesquisacliente"];
        $consultar = "select * from tbcliente where nome='$pesqnome'";
        $executar = mysqli_query($conn, $consultar);
        $linha = mysqli_fetch_array($executar);
       
        if($linha['nome'] == NULL){
            header("Location: ../view/erro.php");
        }

        ?>
        <form>
            <table>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="cxnome" value = "<?php echo $linha['nome'] ?>" disabled></td>
                <td rowspan="2" class="delete"><a href="excluircliente.php?id=<?php echo $linha['cod'];?>" >❌</a></td>
                </tr>
                <tr>
                    <td>E_mail:</td>
                    <td><input type="text" name= "cxemail" value = "<?php echo $linha['email'] ?>" disabled></td>
                </tr>
            <br>
        </form>
        <tr>
            <td><a href="../view/menu.php">Voltar</a><td>
        </tr>
    </table>
    </div>
</body>
</html>