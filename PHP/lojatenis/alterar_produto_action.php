<?php
    require_once 'configuracao.php';

    $codigo = $_POST['txtid'];  
    $desc = $_POST['txtdesc'];
    $img = $_POST['txtimg'];
    $preco = $_POST['txtpreco'];    

    echo "<h3>Alterando Dados</h3>";
    echo "<h5>Produto = $</h5>";

    //definindo a instrução SQL para alteração do registro
    $altera = $conexao->prepare('UPDATE tabprodutos SET proDescricao = :descr, proImagem = :img, proPreco = :preco WHERE proId = :cod');

    $altera->bindValue(':cod', $codigo);
    $altera->bindValue(':descr', $desc);
    $altera->bindValue(':img', $img);
    $altera->bindValue(':preco', $preco);
    
    
    $altera->execute();

    echo "<div class = 'card'><br>";
    echo "<b> Descricao      = </b>$desc<br> <b> Imagem      = </b>$img<br> <b> Preço     = </b>$preco<br>  <b>/";
    echo "</div>";

    echo "<a href = 'lista.php' class = 'btn'> Voltar </a>";
?>