<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$codigo = $_GET['id'];
echo "Código =".$codigo;

$exclui = $conexao->prepare('DELETE FROM tabcarrinho WHERE carProId = :id');
$exclui->bindValue(':id', $codigo);
$exclui->execute();
header('Location: carrinho.php?codigo=');

?>

<?php

include 'rodape.php';

?>