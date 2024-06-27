<?php
include_once "cabecalho.php";
require_once "config.php";

$codigo = $_GET['id'];
echo "codigo =".$codigo;

$exclui = $conexao->prepare('DELETE FROM tb_produto WHERE prodId = :id');
$exclui->bindValue(':id', $codigo);
$exclui->execute();
header('Location: lista_prod.php');

?>

<?php

include 'rodape.php';

?>