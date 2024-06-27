<?php
include_once "cabecalho.php";
require_once "configuracao.php";

$id = $_GET['id'];


$consulta = $conexao->prepare('SELECT * FROM tabprodutos WHERE proId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);

$codigo = $id;
$desc = $linha['proDescricao'];
$img = $linha['proImagem'];
$preco = $linha['proPreco'];


echo "<div class= 'row'>";
echo "<div class='col s12 m6 push-m3'>";
echo "<h2>Excluir Produto ?</h2>";
echo "<b>Codigo = </b>$codigo<br> 
      <b>Descrição = </b>$desc<br> 
      <b>Imagem = </b>$img<br> 
      <b>Preco = </b>$preco<br>";
  

echo "<a href = 'exclui_produto_action.php?id=$codigo' class = 'btn'> Sim, excluir registro </a>";
echo "<br><a href = 'lista.php' class = 'btn'> Voltar </a>";
echo "</div></div>";
?>