<?php
include_once "cabecalho.php";
require_once "config.php";

$id = $_GET['id'];

$consulta = $conexao->prepare('SELECT * FROM tabcarrinho WHERE carProId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();
$consulta = $conexao->prepare('SELECT proDescricao FROM tabprodutos WHERE proId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);
$codigo = $id;
$desc = $linha['proDescricao'];

echo "<div class='excluir'><br>";
echo "<h2>Excluir Produto?</h2>";
echo "<b>Codigo: </b>" . $codigo;
echo "<Br><b>Produto: </b>" . $desc;
echo "<br><a href='excluir_car_action.php?id=$codigo' class='btn'>Sim, excluir registro</a>";
echo "<a href='carrinho.php?codigo=' class='btn'>Carrinho</a>";
echo "</div>";
?>

<?php

include 'rodape.php';

?>