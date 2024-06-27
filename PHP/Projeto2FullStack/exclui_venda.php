<?php
include_once "cabecalho.php";
require_once "config.php";

$id = $_GET['id'];


$consulta = $conexao->prepare('SELECT * FROM tb_vendas WHERE vendaNum = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);

$num = $id;
$tipo = $linha['vendaTipo'];
$preco = $linha['vendaPreco'];
$quantidade = $linha['vendaQnt'];
$data = $linha['vendaDia'];


echo "<div class= 'row'>";
echo "<div class='col s12 m6 push-m3'>";
echo "<h2>Excluir Produto ?</h2>";
echo "<b>Codigo = </b>$num<br> 
      <b>Tipo = </b>$tipo<br> 
      <b>Preco = </b>$preco<br> 
      <b>Quantidade = </b>$quantidade<br> 
      <b>Data = </b>$data<br>";
      

echo "<a href = 'exclui_venda_action.php?id=$num' class = 'btn'> Sim, excluir compra </a>";
echo "<br><a href = 'lista_venda.php' class = 'btn'> Voltar </a>";
echo "</div></div>";
?>

<?php

include 'rodape.php';

?>