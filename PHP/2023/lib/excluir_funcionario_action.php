<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$codigo = $_GET['id'];
echo "codigo = ".$codigo;

$exclui = $conexao->prepare('DELETE FROM tabfuncionarios WHERE funId=:id');
$exclui->bindValue(':id', $codigo);
$exclui->execute();
header('Location: listar_func.php');


include_once "rodape.php";


?>
