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
<h1>Listagem de produtos</h1>
    <div class="ilha">
       
    <table>
        <?php
        include_once "../factory/conexao.php";
        
        $consultar = "select *from tbproduto";
        $executar = mysqli_query($conn, $consultar);
        while($linha = mysqli_fetch_array($executar))
        {

        
        ?>

        <form>
          
                <tr>
                    <td>Produto:</td>
                    <td><input type="text" name="prod" value = "<?php echo $linha['produto'] ?>"/ disabled></td>
                    <td rowspan="4"><a href="excluirproduto.php?id=<?php echo $linha['codigo'];?>">❌</a></td>
                </tr>
                <tr> 
                    <td>Quantidade:</td>
                    <td><input type="text" name= "qtde" value = "<?php echo $linha['qtde'] ?>"/ disabled></td>
                </tr>
                <tr>
                    <td>Data de validade: </td>
                    <td><input type="text" name= "dataval" value = "<?php echo $linha['datavalidade'] ?>"/ disabled></td>
                </tr>
                <tr>
                    <td>Quantidade:</td>
                    <td><input type="text" name= "valor" value = "<?php echo $linha['valor'] ?>"/ disabled></td>
                </tr>
            
                <tr><td colspan="3"><hr></td></tr>
          
        </form>

        <?php
        }
        ?>
            <tr>
                <td><a href="../view/menu.php">Voltar</a></td>
            </tr>
        </table>
    </div>
</body>
</html>