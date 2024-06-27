<?php
require_once "cabecalho.php";
require_once 'conf_meu.php';

if(isset($_POST['btncadastro']))
{
    $nome = filter_input(INPUT_POST,'txtnome');
    $celular = filter_input(INPUT_POST,'txtcel');
    $data = filter_input(INPUT_POST,'txtnascimento');
    $senha = filter_input(INPUT_POST,'txtsenha');
    $verificacao = filter_input(INPUT_POST,'txtverificacao');

    $sql = $conexao->prepare("INSERT into tb_cadas(cadNome,cadCel,cadDataNasc,cadSenha,cadVerificacao) VALUES (:usuario,:celular,:date,:senha,:verificacao)");
    $sql->bindValue(':usuario', $nome);
    $sql->bindValue(':celular', $celular);
    $sql->bindValue(':date', $data);
    $sql->bindValue(':senha',$senha);
    $sql->bindValue(':verificacao',$verificacao);
    $sql->execute();
    header('Location: index.html');
}
echo "$nome $celular $data $senha $verificacao";

require_once "rodape.php";
?>