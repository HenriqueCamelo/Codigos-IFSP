<?php
include_once "cabecalho.php";
include_once "configuracao.php";

echo "<h2>Carrinho de compra</h2>";
// Adiciona produto ao carrinho
if (isset($_GET['codigo'])) {
   $livroId = $_GET['codigo'];
   $quant = 1;

   // Verifica se o produto já está no carrinho
   $stmt = $conexao->prepare("SELECT * FROM tabcarrinho WHERE carProId = :livroId");
   $stmt->bindParam(':livroId', $livroId);
   $stmt->execute();
   
?>
   <table>
      <tr>
         <th>Item</th>
         <th>Produto</th>
         <th>Quantidade</th>

      </tr>

   <?php
   if ($stmt->rowCount() > 0) {
      // Atualiza a quantidade se o produto já estiver no carrinho
      $row = $stmt->fetch(PDO::FETCH_ASSOC);
      $quant += $row['carQtde'];
      $stmt = $conexao->prepare("UPDATE tabcarrinho SET carQtde = :qt WHERE carProId = :prod");
   } else {
      // Adiciona o produto ao carrinho se não estiver lá
      $stmt = $conexao->prepare("INSERT INTO tabcarrinho (carProId, carQtde ) VALUES (:prod, :qt)");
   }

   $stmt->bindParam(':livroId', $livroId);
   $stmt->bindParam(':qt', $quant);
   $stmt->execute();
}
/* listando os dados adicionados ao carrinho
   */
$sql = "SELECT tabcarrinho.*, tabprodutos.livroDescr AS descricao FROM tabcarrinho INNER JOIN tb_livros ON tabcarrinho.carProId = tb_livros.livroId";

$stmt = $conexao->prepare($sql);
$stmt->execute();
while ($linha = $stmt->fetch(PDO::FETCH_ASSOC)) {
   echo "<tr><td>{$linha['carId']}</td>";
   echo "<td>{$linha['descricao']}</td>";
   echo "<td>{$linha['carQtde']}</td></tr>";
}
echo "</table>";

include_once "rodape.php";
?>

