<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$id = $_GET['id'];
$consulta = $conexao->prepare('SELECT * FROM tabfuncionarios WHERE funId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);

$codigo = $id;
$nome = $linha['funNome'];
$senha = $linha['funSenha'];
$email = $linha['funEmail'];
$cargo = $linha['funCargo'];
$usuario = $linha['funUsuario'];
$foto = $linha['funFoto'];


 //  echo "{$linha['cli_nome']}";
echo "<div class='row'>";

echo "<div class='col s12 m6 push-m3'>";

echo "<h2>Excluir funcionario?</h2>";

echo "<b>Código     = </b>$codigo<br>
      <b>Nome       = </b>$nome<br>
      <b>Senha       = </b>$senha<br>
      <b>Email       = </b>$email<br>
      <b>Cargo       = </b>$cargo<br>
      <b>Usuario       = </b>$usuario<br>
      <b>Foto       = </b>$foto<br>";



echo "<a href='listar_func.php' class='btn'>Listagem de funcionarios</a>";

echo "<a href='excluir_funcionario_action.php?id=$codigo' class='btn red'>Sim, excluir registro.</a>";

echo "</div></div></div>";

include_once "rodape.php";

?>
