<?php
require_once "cabecalho.php";
require_once 'conf_meu.php';

if(isset($_POST['btncadastrar']))
{
    $nome = filter_input(INPUT_POST,'txtnome');
    $senha = filter_input(INPUT_POST,'txtsenha');
    $email = filter_input(INPUT_POST,'txtemail');
    $cargo = filter_input(INPUT_POST,'txtcargo');
    $usuario= filter_input(INPUT_POST,'txtusuario');
    $foto = filter_input(INPUT_POST,'txtfoto');

    $sql = $conexao->prepare("INSERT into tabfuncionarios (funNome, funSenha, funEmail, funCargo, funUsuario, funFoto) VALUES (:nome,:senha,:email,:cargo,:usuario,:foto)");
    $sql->bindValue(':nome', $nome);
    $sql->bindValue(':senha', $senha);
    $sql->bindValue(':email', $email);
    $sql->bindValue(':cargo',$cargo);
    $sql->bindValue(':usuario',$usuario);
    $sql->bindValue(':foto',$foto);

    $sql->execute();
    header('Locatio: listar_func.php');
}
    echo " $nome $senha $email $cargo  $usuario $foto <br>";

    echo '<a href="listar_func.php" class="btn green">Listar funcionarios</a> ';




    include_once "rodape.php";
?>