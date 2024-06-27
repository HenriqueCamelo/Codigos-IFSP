<?php
    require_once 'config.php';
    include 'cabecalho.php';

    $codigo = $_POST['txtvnum'];
    $tipo = $_POST['txtvtipo'];
    $preco = $_POST['txtvpreco'];
    $qnt = $_POST['txtvqnt'];
    $data = $_POST['txtvdia'];
    

    echo "<h3>Alterando Dados da Venda</h3>";
    echo "<h5>Produto = $</h5>";

    //definindo a instrução SQL para alteração do registro
    $altera = $conexao->prepare('UPDATE tb_vendas SET vendaTipo = :tipo, vendaPreco = :preco, vendaQnt = :qnt, vendaDia = :date WHERE vendaNum = :cod');

    $altera->bindValue(':cod', $codigo);
    $altera->bindValue(':tipo', $tipo);
    $altera->bindValue(':preco', $preco);
    $altera->bindValue(':qnt', $qnt);
    $altera->bindValue(':date', $data);
    
    $altera->execute();

    echo "<div class = 'card'><br>";
    echo "<b> Tipo      = </b>$tipo<br> <b> Preço      = </b>$preco<br> <b> Quantidade      = </b>$qnt<br> <b> Data      = </b>$data<br> <b> /";
    echo "</div>";

    echo "<a href = 'lista_venda.php' class = 'btn'> Voltar </a>";
?>

<?php

include 'rodape.php';

?>