<?php
    require_once "cabecalho.php";
    require_once 'conf_meu.php';

    $codigo = $_POST['txtid'];  
    $nome = $_POST['txtnome'];
    $edit = $_POST['txtedit'];
    $autor = $_POST['txtautor'];
    $data = $_POST['txtdata'];
    $imge = $_POST['txtimge'];
    $descr = $_POST['txtdescr'];
    $preco = $_POST['txtpreco'];

    echo "<h3>Alterando Dados do Livro</h3>";
    echo "<h5>Produto = $</h5>";

    //definindo a instrução SQL para alteração do registro
    $altera = $conexao->prepare('UPDATE tb_livros SET livroNome = :lnome, livroEdi = :edit, livroAut = :autor, livroDataLan = :date, livroImg = :imge, livroDescr = :descr, livroPrec = :preco WHERE livroId = :cod');

    $altera->bindValue(':cod', $codigo);
    $altera->bindValue(':lnome', $nome);
    $altera->bindValue(':edit', $edit);
    $altera->bindValue(':autor', $autor);
    $altera->bindValue(':date', $data);
    $altera->bindValue(':imge', $imge);
    $altera->bindValue(':descr', $descr);
    $altera->bindValue(':preco', $preco);
    
    $altera->execute();

    echo "<div class = 'card'><br>";
    echo "<b> Nome      = </b>$nome<br> <b> Editora      = </b>$edit<br> <b> Autor     = </b>$autor<br> <b> Data de lançamento      = </b>$data<br> <b> <b> Capa do livro      = </b>$imge<br> <b> <b> Descrição do livro      = </b>$descr<br> <b> <b> Preco do livro      = </b>$preco<br> <b><b>/";
    echo "</div>";

    echo "<a href = 'lista.php' class = 'btn blue'> Voltar </a>";

    require_once "rodape.php";
?>