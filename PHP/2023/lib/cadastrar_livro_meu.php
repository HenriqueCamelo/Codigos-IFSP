<?php
require_once "cabecalho.php";
require_once 'conf_meu.php';

if(isset($_POST['btncadastro']))
{
    $nome = filter_input(INPUT_POST,'txtnome');
    $edit = filter_input(INPUT_POST,'txtedit');
    $autor = filter_input(INPUT_POST,'txtauto');
    $data = filter_input(INPUT_POST,'txtdata');
    $imge = filter_input(INPUT_POST,'txtimge');
    $descr = filter_input(INPUT_POST,'txtdescr');
    $preco = filter_input(INPUT_POST,'txtpreco');
    

    $sql = $conexao->prepare("INSERT into tb_livros(livroNome,livroEdi,livroAut,livroDataLan, livroImg, livroDescr, livroPrec) VALUES (:lnome,:edit,:autor,:date, :imge, :descr, :preco)");
    $sql->bindValue(':lnome', $nome);
    $sql->bindValue(':edit', $edit);
    $sql->bindValue(':autor', $autor);
    $sql->bindValue(':date',$data);
    $sql->bindValue(':imge',$imge);
    $sql->bindValue(':descr',$descr);
    $sql->bindValue(':preco',$preco);
    
    $sql->execute();
    header('Location: lista.php');
}
echo "$nome $edit $autor $data $imge $descr $preco";

include_once "rodape.php";
?>