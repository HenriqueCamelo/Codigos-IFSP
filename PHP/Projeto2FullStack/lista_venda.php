<?php
include_once 'config.php';
include_once 'cabecalho.php';

$consulta = $conexao->prepare('Select * from tb_vendas');
$consulta->execute();
?>
<title>Lista de Vendas</title>
</head>


<body>
   <h2>Listagem de compra</h2>
   <table>
      <tr>
         <th>Tipo</th>
         <th>Preco</th>
         <th>Quantidade</th>
         <th>Data Venda</th>
         <th colspan="2">Ações</th>
      </tr>
      <?php
      while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) {
         echo "<tr><td>{$linha['vendaTipo']}</td>";
         echo "<td>{$linha['vendaPreco']}</td>";
         echo "<td>{$linha['vendaQnt']}</td>";
         echo "<td>{$linha['vendaDia']}</td>";
         echo "<td><a href='alterar_venda.php?id={$linha['vendaNum']}' class='btn-floating orange'><i class='material-icons'>edit</i></a></td>";
         echo "<td><a href='exclui_venda.php?id={$linha['vendaNum']}' class='btn-floating blue'><i class='material-icons'>delete</i></a></td></tr>";
      }
      echo "</table>";
      echo "<a href='vendas.php' class='btn'>Adicionar compra</a>";
   
      ?>

<?php

include 'rodape.php';

?>