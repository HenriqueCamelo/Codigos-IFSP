<?php
require_once 'configuracao.php';

if(isset($_POST['btncadastrar']))
{
    $desc = filter_input(INPUT_POST,'txtdescricao');
    $img = filter_input(INPUT_POST,'txtimagem');
    $preco = filter_input(INPUT_POST,'txtpreco');

    $sql = $conexao->prepare("INSERT into tabprodutos (proId, proDescricao, proPreco) VALUES (:descricao,:imagem,:preco)");
    $sql->bindValue(':descricao', $desc);
    $sql->bindValue(':imagem', $img);
    $sql->bindValue(':preco', $preco);
    $sql->execute();
    header('Locatio: lista_produtos.php');
}
    echo " $desc $img $preco ";

    echo '<a href="lista_produtos.php" class="btn green">Listar produtos</a>'







?>