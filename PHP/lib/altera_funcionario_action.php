<?php
require_once "cabecalho.php";
require_once "conf_meu.php";


$codigo = $_POST['txtId'];
$nome = $_POST['txtNome'];
$email = $_POST['txtEmail'];
$senha = $_POST['txtSenha'];
$cargo = $_POST['txtCargo'];
$usuario = $_POST['txtUsuario'];
$foto = $_POST['txtFoto'];



echo "<h3>Alterando Dados do Funcionário</h3>";

echo "<h5>Funcionário = $codigo</h5>";



$altera = $conexao ->prepare('UPDATE tabfuncionarios SET funNome = :nome, funEmail = :email, funSenha = :senha, funCargo = :cargo, funFoto = :foto, funUsuario = :usuario WHERE funId = :cod');
$altera->bindValue(':cod', $codigo);
$altera->bindValue(':nome', $nome);
$altera->bindValue(':senha', $senha);
$altera->bindValue(':email', $email);
$altera->bindValue(':cargo', $cargo);
$altera->bindValue(':usuario', $usuario);
$altera->bindValue(':foto', $foto);
$altera->execute();

    echo"<div class='card'><br>";

    echo "<b>Código     = </b>$codigo<br>
    <b>Nome       = </b>$nome<br>
    <b>Senha       = </b>$senha<br>
    <b>Email       = </b>$email<br>
    <b>Cargo       = </b>$cargo<br>
    <b>Usuario       = </b>$usuario<br>
    <b>Foto       = </b>$foto<br>";
    
    echo"</div>";

    echo "<a href='listar_func.php' class='btn blue'>Voltar</a>";

    include_once "rodape.php";
?>