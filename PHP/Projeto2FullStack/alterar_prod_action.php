<?php
    require_once 'config.php';
    include 'cabecalho.php';

    $codigo = $_POST['txtid'];
    $tipo = $_POST['txtipo'];
    $preco = $_POST['txtpreco'];
    $qnt = $_POST['txtqnt'];
    $forn = $_POST['txtforn'];
    $unidade = $_POST['txtunidade'];

    echo "<h3>Alterando Dados do Produto</h3>";
    echo "<h5>Produto = $</h5>";

    //definindo a instrução SQL para alteração do registro
    $altera = $conexao->prepare('UPDATE tb_produto SET prodTipo = :tipo, prodPreco = :preco, prodQnt = :qnt, prodForn = :forn, prodUnidadeLoja = :unidade WHERE prodId = :cod');

    $altera->bindValue(':cod', $codigo);
    $altera->bindValue(':tipo', $tipo);
    $altera->bindValue(':preco', $preco);
    $altera->bindValue(':qnt', $qnt);
    $altera->bindValue(':forn', $forn);
    $altera->bindValue(':unidade', $unidade);
    $altera->execute();

    echo "<div class = 'card'><br>";
    echo "<b> Tipo      = </b>$tipo<br> <b> Preço      = </b>$preco<br> <b> Quantidade      = </b>$qnt<br> <b> Fornecedor      = </b>$forn<br> <b> Local Unidade      = </b>$unidade<br>";
    echo "</div>";

    echo "<a href = 'lista_prod.php' class = 'btn'> Voltar </a>";
?>

<?php

include 'rodape.php';

?>