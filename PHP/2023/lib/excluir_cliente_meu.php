<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$id = $_GET['id'];


$consulta = $conexao->prepare('SELECT * FROM tb_cadas WHERE cadId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);

$codigo = $id;
$nome = $linha['cadNome'];
$celular = $linha['cadCel'];
$data = $linha['cadDataNasc'];
$senha = $linha['cadSenha'];
$verificacao = $linha['cadVerificacao'];

echo "<div class= 'row'>";
echo "<div class='col s12 m6 push-m3'>";
echo "<h2>Excluir Produto ?</h2>";
echo "<b>Codigo = </b>$codigo<br> 
      <b>Nome = </b>$nome<br> 
      <b>Celular = </b>$celular<br> 
      <b>Data = </b>$data<br> 
      <b>Senha = </b>$senha<br> 
      <b>Verificacao = </b>$verificacao<br>";

echo "<a href = 'excluir_cliente_action_meu.php?id=$codigo' class = 'btn'> Sim, excluir usuario </a>";
echo "<br><a href = 'listagem_meu.php' class = 'btn blue'> Voltar </a>";
echo "</div></div>";

include_once "rodape.php";