<?php
require_once 'config.php';
include 'cabecalho.php';

if(isset($_POST['btncadastrar']))
{
    $tipo = filter_input(INPUT_POST,'txtipo');
    $preco = filter_input(INPUT_POST,'txtpreco');
    $qnt = filter_input(INPUT_POST,'txtqnt');
    $forn = filter_input(INPUT_POST,'txtforn');
    $unidade = filter_input(INPUT_POST,'txtunidade');

    $sql = $conexao->prepare("INSERT into tb_produto (prodTipo, prodPreco, prodQnt, prodForn, prodUnidadeLoja) VALUES (:tipo,:preco,:qnt, :forn, :unidade)");
    $sql->bindValue(':tipo', $tipo);
    $sql->bindValue(':preco', $preco);
    $sql->bindValue(':qnt', $qnt);
    $sql->bindValue(':forn', $forn);
    $sql->bindValue(':unidade', $unidade);
    $sql->execute();
    header('Locatio: listar.php');
}
    echo " $tipo $preco $qnt $forn $unidade";

    echo '<a href="lista_prod.php" class="btn green">Listar clientes</a>'

?>

<?php

include 'rodape.php';

?>