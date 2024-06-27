<?php
include_once "cabecalho.php";
require_once "config.php";

$num = $_GET['id'];
echo "num =".$num;

$exclui = $conexao->prepare('DELETE FROM tb_vendas WHERE vendaNum = :id');
$exclui->bindValue(':id', $num);
$exclui->execute();
header('Location: lista_venda.php');

?>

<?php

include 'rodape.php';

?>