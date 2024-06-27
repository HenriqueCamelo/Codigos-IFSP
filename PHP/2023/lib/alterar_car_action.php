<?php
    require_once 'conf_meu.php';

    $codigo = $_POST['txtid'];
    $qtd = $_POST['txtqtd'];

    //definindo a instrução SQL para alteração do registro
    $altera = $conexao->prepare('UPDATE tabcarrinho SET carQtde = :qtd WHERE carProId = :cod');

    $altera->bindValue(':cod', $codigo);
    $altera->bindValue(':qtd', $qtd);

    $altera->execute();

    header("Location: carrinho.php?codigo=");

?>

