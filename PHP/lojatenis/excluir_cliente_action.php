<?php
include_once "cabecalho.php";
require_once "configuracao.php";


$codigo = $_GET['id'];
echo "codigo = ".$codigo;




$exclui = $conexao->prepare('DELETE FROM tabclientes WHERE cliId=:id');
$exclui->bindValue(':id', $codigo);
$exclui->execute();
header('Location: listar.php');




//include_once "rodape.php";


?>
