<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">
   <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
   <link rel="stylesheet" href="css/estilos.css">
   <!--Import Google Icon Font-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <title>Sysexemplo - Cadastro de Clientes</title>
</head>
</html>

<?php 
require_once "configuracao.php";
include_once "cabecalho.php";

$codigo = $_POST['txtid'];
$nome = $_POST['txtnome'];
$fone = $_POST['txtfone'];
$data = $_POST['txtdatanasc'];

echo "<h3>Alterando Dados do Cliente<h3>";
echo "<h5>Cliente = $codigo<h5>";

$altera = $conexao->prepare('UPDATE tabclientes SET cliNome = :nome, cliTelefone = :fone, cliDataNasc=:nasc WHERE cliId = :cod');
$altera->bindValue(":cod", $codigo);
$altera->bindValue(":nome", $nome);
$altera->bindValue(":fone", $fone);
$altera->bindValue(":nasc", $data );
$altera->execute();

echo "<div class= 'card'><br>";
echo "<b>Nome      =</b>$nome<br>";
 "<b>Telefone      =</b>$nome<br>";
 "<b>Data Nasc      =</b>$nome<br>";
echo "</div>";

echo "<a href='listar.php' class = 'btn'> Listagem de clientes </a> ";

//include_once "rodape.php";
?>