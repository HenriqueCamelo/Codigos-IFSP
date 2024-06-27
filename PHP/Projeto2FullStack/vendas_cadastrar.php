<?php
require_once 'config.php';
include 'cabecalho.php';

if(isset($_POST['btncadastrar']))
{
    $tipo = filter_input(INPUT_POST,'txtvtipo');
    $preco = filter_input(INPUT_POST,'txtvpreco');
    $quantidade = filter_input(INPUT_POST,'txtvqnt');
    $data = filter_input(INPUT_POST,'txtvdata');

    $sql = $conexao->prepare("INSERT into tb_vendas (vendaTipo, vendaPreco, vendaQnt, vendaDia) VALUES (:ventipo,:venpreco,:venqnt,:date)");
    $sql->bindValue(':ventipo', $tipo);
    $sql->bindValue(':venpreco', $preco);
    $sql->bindValue(':venqnt', $quantidade);
    $sql->bindValue(':date', $data);
    $sql->execute();
    header('Locatio: lista_venda.php');
}
    echo " $tipo $preco $quantidade $data";

    echo '<a href="lista_venda.php" class="btn green">Ver compras</a>'

?>

<?php

include 'rodape.php';

?>