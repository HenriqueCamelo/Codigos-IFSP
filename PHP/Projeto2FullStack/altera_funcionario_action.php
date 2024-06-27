<?php
require_once "config.php";

require_once "cabecalho.php";

$codigo = $_POST['txtidfunc'];
$nomefunc = $_POST['txtnomefunc'];
$emailfunc = $_POST['txtemailfunc'];
$senhafunc = $_POST['txtsenhafunc'];
$cargofunc = $_POST['txtcargofunc'];
$usuariofunc = $_POST['txtusuariofunc'];
$fotofunc = $_POST['txtfotofunc'];



echo "<h3>Alterando Dados do Funcionário</h3>";

echo "<h5>Funcionário = $codigo</h5>";



$altera = $conexao ->prepare('UPDATE tabfuncionarios SET funNome = :nomefunc, funEmail = :emailfunc, funSenha = :senhafunc, funCargo = :cargofunc, funFoto = :fotofunc, funUsuario = :usuariofunc WHERE funId = :cod');
$altera->bindValue(':nomefunc', $nomefunc);
$altera->bindValue(':senhafunc', $senhafunc);
$altera->bindValue(':emailfunc', $emailfunc);
$altera->bindValue(':cargofunc', $cargofunc);
$altera->bindValue(':usuariofunc', $usuariofunc);
$altera->bindValue(':fotofunc', $fotofunc);
$altera->execute();

    echo"<div class='card'><br>";

    echo "<b>Código     = </b>$codigo<br>
    <b>Nome       = </b>$nomefunc<br>
    <b>Senha       = </b>$senhafunc<br>
    <b>Email       = </b>$emailfunc<br>
    <b>Cargo       = </b>$cargofunc<br>
    <b>Usuario       = </b>$usuariofunc<br>
    <b>Foto       = </b>$fotofunc<br>";
    
    echo"</div>";

    echo "<a href='listar_funcionarios.php' class='btn'>Listagem de funcionários</a>";
?>

<?php

include 'rodape.php';

?>