<?php
include_once "cabecalho.php";
require_once "conf_meu.php";

$id = $_GET['id'];


$consulta = $conexao->prepare('SELECT * FROM tb_livros WHERE livroId = :id');
$consulta->bindValue(':id', $id);
$consulta->execute();

$linha = $consulta->fetch(PDO::FETCH_ASSOC);

$codigo = $id;
$nome = $linha['livroNome'];
$edit = $linha['livroEdi'];
$autor = $linha['livroAut'];
$data = $linha['livroDataLan'];
$imge = $linha['livroImg'];
$descr = $linha['livroDescr'];
$preco = $linha['livroPrec'];

echo "<div class= 'row'>";
echo "<div class='col s12 m6 push-m3'>";
echo "<h2>Excluir Produto ?</h2>";
echo "<b>Codigo = </b>$codigo<br>";
echo  "<b>Nome = </b>$nome<br>"; 
echo  "<b>Editora = </b>$edit<br>"; 
echo  "<b>Autor = </b>$autor<br>"; 
echo  "<b>Imagem = </b>$imge<br>";
echo  "<b>Descricao = </b>$descr<br>";
echo  "<b>Preço = </b>$preco<br>";
      

echo "<a href = 'excluir_livro_action_meu.php?id=$codigo' class = 'btn'> Sim, excluir usuario </a>";
echo "<br><a href = 'lista.php' class = 'btn blue'> Voltar </a>";
echo "</div></div>";

include_once "rodape.php";