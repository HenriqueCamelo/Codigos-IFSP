<?php
    require_once "cabecalho.php";
    require_once 'conf_meu.php';

    $codigo = $_POST['txtid'];
    $nome = $_POST['txtnome'];
    $cel = $_POST['txtcel'];
    $nasc = $_POST['txtnascimento'];
    $senha = $_POST['txtsenha'];
    $verif = $_POST['txtverificacao'];
    

    echo "<h3>Alterando Dados do Usuário</h3>";
    echo "<h5>Produto = $</h5>";

    //definindo a instrução SQL para alteração do registro
    $altera = $conexao->prepare('UPDATE tb_cadas SET cadNome = :usuario, cadCel = :celular, cadDataNasc = :date, cadSenha = :senha, cadVerificacao = :verificacao WHERE cadId = :cod');

    $altera->bindValue(':cod', $codigo);
    $altera->bindValue(':usuario', $nome);
    $altera->bindValue(':celular', $cel);
    $altera->bindValue(':date', $nasc);
    $altera->bindValue(':senha', $senha);
    $altera->bindValue(':verificacao', $verif);
    
    $altera->execute();

    echo "<div class = 'card'><br>";
    echo "<b> Nome      = </b>$nome<br> <b> Celular      = </b>$cel<br> <b> Data de Nascimento      = </b>$nasc<br> <b> Senha      = </b>$senha<br> <b> <b> Verificacao      = </b>$verif<br> <b>/";
    echo "</div>";

    echo "<a href = 'listagem_meu.php' class = 'btn blue'> Voltar </a>";

    include_once "rodape.php";
?>