
<?php
include_once 'cabecalho.php';
include_once 'conf_meu.php';


function mostrarDados($linha)
{
   echo "<div class='col s12 m'>";
   echo "<div class='card'>";
   echo "<div class='card-image'>";
   echo "<td><img src='imagens/{$linha['livroImg']}.jpg'><br></div>";
   echo "<div class='card-content'><p>Descrição do Card 3</p></div>";
   echo "<div class='card-action'><a href='#' class='btn'>Botão 3</a></div></div>";
}



echo "<h3>Produtos para venda</h3>";

$consulta = $conexao->prepare('Select * from tb_livros');
$consulta->execute();
$f = $consulta->rowCount();

echo "<table class='responsive-table centered'>";
$li = 1;
echo "<tr>";
while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) {
   echo "<td><img src='imagens/{$linha['livroImg']}.jpg'><br>";
   echo "<a href='carrinho.php?codigo={$linha['livroId']}'>{$linha['livroDescr']}</a><br>";
   echo "R$ {$linha['livroPrec']}<br>";

   echo "<a href='carrinho.php?codigo={$linha['livroId']}' class='waves-effect waves-light btn'>Comprar";
   echo "<i class='small material-icons'>local_grocery_store</i></a>";
?>   

      <!--
  Sizes:
  tiny: 1rem
  small: 2rem
  medium: 4rem
  large: 6rem
  -->

  
   </td>
<?php
   $li++;
   if ($li == 4) {
      $li = 1;
      echo "</tr><tr>";
   }
}
echo "</table>";
include_once "rodape.php";
?>

