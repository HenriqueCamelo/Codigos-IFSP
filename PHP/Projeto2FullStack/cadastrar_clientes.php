<?php

    require_once "cabecalho.php";
    require_once 'config.php';
    session_start();

    if(isset($_POST['btncadastrar'])){

        $_SESSION['nome'] = filter_input(INPUT_POST, 'txtnome');
        $fone = filter_input(INPUT_POST, 'txtfone');
        $data = filter_input(INPUT_POST, 'txtdatanasc');
        $cep = filter_input(INPUT_POST, 'txtcep');
        $cpf = filter_input(INPUT_POST, 'txtcpf');
        $email = filter_input(INPUT_POST, 'txtemail');
        $repsenha = filter_input(INPUT_POST, 'txtrepsenha');
        $_SESSION['senha'] = filter_input(INPUT_POST, 'txtsenha');


        if(strcmp($repsenha, $_SESSION['senha']) !== 0){
            echo"<br>Erro: As senhas devem coincidir!";
            echo"<a href='form_cadastrar_clientes.php' class='btn green'>Voltar</a>";
         }else{
        
        $sql = $conexao->prepare("INSERT into tb_clientes (cliNome, cliFone, cliNasc, cliCEP, cliCPF, cliEmail, cliRepSenha, cliSenha) VALUES (:nome, :fone, :date, :cep, :cpf, :email, :repsenha, :senha)");
        $sql->bindValue(':nome',  $_SESSION['nome']);
        $sql->bindValue(':fone', $fone);
        $sql->bindValue(':date', $data);
        $sql->bindValue(':cep', $cep);
        $sql->bindValue(':cpf', $cpf);
        $sql->bindValue(':email', $email);
        $sql->bindValue(':repsenha', $repsenha);
        $sql->bindValue(':senha', $_SESSION['senha']);

        $sql->execute();
        header('Location:form_login_clientes.php');
        
    }

}
?>

<?php
include 'rodape.php';
?>