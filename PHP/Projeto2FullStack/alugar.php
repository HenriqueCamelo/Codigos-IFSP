<?php
include 'config.php'; 
include 'cabecalho.php';


echo "<h2>Produtos Alugados</h2>";
// Adiciona produto ao carrinho
if (isset($_GET['codigo'])) {
   $proId = $_GET['codigo'];
   $quant = 1;

   // Verifica se o produto já está no carrinho
   $stmt = $conexao->prepare("SELECT * FROM tabalugar WHERE carProId = :proId");
   $stmt->bindParam(':proId', $proId);
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
      $stmt = $conexao->prepare("UPDATE tabalugar SET carQtde = :qt WHERE carProId = :proId");
   } else {
      // Adiciona o produto ao carrinho se não estiver lá
      $stmt = $conexao->prepare("INSERT INTO tabalugar (carProId, carQtde ) VALUES (:proId, :qt)");
   }

   $stmt->bindParam(':proId', $proId);
   $stmt->bindParam(':qt', $quant);
   $stmt->execute();
}
/* listando os dados adicionados ao carrinho
   */
$sql = "SELECT tabalugar.*, tabprodutos.proDescricao AS descricao FROM tabalugar INNER JOIN tabprodutos ON tabalugar.carProId = tabprodutos.proId";

$stmt = $conexao->prepare($sql);
$stmt->execute();
while ($linha = $stmt->fetch(PDO::FETCH_ASSOC)) {
   echo "<tr><td>{$linha['carId']}</td>";
   echo "<td>{$linha['descricao']}</td>";
   echo "<td>{$linha['carQtde']}</td>";
   echo "<td>{$linha['carHoras']}</td>";
   echo "<td><a href='alterar_alu.php?id={$linha['carProId']}' class='btn'><i class='material-icons'>Editar</i></a></td>";
   echo "<td><a href='excluir_alu.php?id={$linha['carProId']}' class='btn'><i class='material-icons'>Remover</i></a></td></tr>";
}
echo "</table>";

echo '<a href="lista_produtos.php">Voltar</a>';

include_once "rodape.php";
?>

