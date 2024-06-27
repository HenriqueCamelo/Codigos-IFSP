<?php
    require_once 'config.php';
    require_once "cabecalho.php";

    if(isset($_POST['btncadastrarfunc']))
    {
        $nomefunc = filter_input(INPUT_POST, 'txtnomefunc');
        $senhafunc = filter_input(INPUT_POST, 'txtsenhafunc');
        $emailfunc = filter_input(INPUT_POST, 'txtemailfunc');
        $cargofunc = filter_input(INPUT_POST, 'txtcargofunc');
        $usuariofunc = filter_input(INPUT_POST, 'txtusuariofunc');
        $fotofunc = filter_input(INPUT_POST, 'txtfotofunc');

        $sql = $conexao->prepare("INSERT into tabfuncionarios (funNome, funSenha, funEmail, funCargo, funUsuario, funFoto) VALUES (:nomefunc, :senhafunc, :emailfunc, :cargofunc, :usuariofunc, :fotofunc)");
        $sql->bindValue(':nomefunc', $nomefunc);
        $sql->bindValue(':senhafunc', $senhafunc);
        $sql->bindValue(':emailfunc', $emailfunc);
        $sql->bindValue(':cargofunc', $cargofunc);
        $sql->bindValue(':usuariofunc', $usuariofunc);
        $sql->bindValue(':fotofunc', $fotofunc);

        $sql->execute();
        header('Location:listar_funcionarios.php');
    }
    echo "Nome: $nomefunc <br> Email: $emailfunc <br> Usuario: $usuariofunc";
?>

<?php
include 'rodape.php';
?>