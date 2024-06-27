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
    <title>Menu</title>
</head>
<body>

</div>
    <section id="principal">
    <h1>Menu principal</h1>
        <a href="cadastrocliente.php">Cadastrar cliente</a><br><br>
        <a href="../model/listarcliente.php">Listar Todos os Clientes</a><br><br>
        <a href="../view/pesquisanomeclientetela.php">Consultar Clientes por Nome</a><br><br>
<hr>
        <a href="cadastroproduto.php">Cadastrar produto</a><br><br>
        <a href="../model/listarproduto.php">Listar Todos os Produtos</a><br><br>
        <a href="../view/pesquisaprodutotela.php">Consultar Produtos por Nome</a>
        
<br><bR>



    </section>


</body>
</html>