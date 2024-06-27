<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$codigo = $_GET['id'];
echo "codigo =".$codigo;

$exclui = $conexao->prepare('DELETE FROM tb_cadas WHERE cadId = :id');
$exclui->bindValue(':id', $codigo);
$exclui->execute();
header('Location: listagem_meu.php');


include_once "rodape.php";
?>