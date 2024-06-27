<?php
include_once "cabecalho.php";
require_once "config.php";

$id = $_GET['id'];


$consulta = $conexao->prepare('SELECT * FROM tb_produto WHERE prodId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);

$codigo = $id;
$tipo = $linha['prodTipo'];
$preco = $linha['prodPreco'];
$qnt = $linha['prodQnt'];
$forn = $linha['prodForn'];
$uni = $linha['prodUnidadeLoja'];

echo "<div class= 'row'>";
echo "<div class='col s12 m6 push-m3'>";
echo "<h2>Excluir Produto ?</h2>";
echo "<b>Codigo = </b>$codigo<br> 
      <b>Tipo = </b>$tipo<br> 
      <b>Preco = </b>$preco<br> 
      <b>Quantidade = </b>$qnt<br> 
      <b>Fornecedor = </b>$forn<br> 
      <b>Unidade = </b>$uni<br>";

echo "<a href = 'exclui_prod_action.php?id=$codigo' class = 'btn'> Sim, excluir registro </a>";
echo "<br><a href = 'lista_prod.php' class = 'btn'> Voltar </a>";
echo "</div></div>";
?>

<?php

include 'rodape.php';

?>