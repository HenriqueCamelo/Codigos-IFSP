<?php
include_once "cabecalho.php";
require_once "config.php";

$id = $_GET['id'];

$consulta = $conexao->prepare('SELECT * FROM tabalugar WHERE carProId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();
$consulta = $conexao->prepare('SELECT proDescricao FROM tabprodutos WHERE proId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);
$codigo = $id;
$desc = $linha['proDescricao'];

echo "<div class='excluir'>";
echo "<Br><h2>Excluir Produto?</h2>";
echo "<b>Codigo: </b>" . $codigo;
echo "<br><b>Produto: </b>" . $desc;
echo "<br><a href='excluir_alu_action.php?id=$codigo' class='btn'>Sim, excluir registro</a>";
echo "<a href='carrinho.php?codigo=' class='btn'>Carrinho</a>";
echo "</div>";
?>

<?php

include 'rodape.php';

?>