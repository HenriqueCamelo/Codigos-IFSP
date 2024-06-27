<?php
include_once "cabecalho.php";
require_once "config.php";

$codigo = $_GET['id'];
echo "Código =".$codigo;

$exclui = $conexao->prepare('DELETE FROM tabalugar WHERE carProId = :id');
$exclui->bindValue(':id', $codigo);
$exclui->execute();
header('Location: alugar.php?codigo=');

?>

<?php

include 'rodape.php';

?>