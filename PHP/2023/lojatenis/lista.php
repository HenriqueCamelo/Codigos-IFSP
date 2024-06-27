<?php
include_once 'configuracao.php';
include_once 'cabecalho.php';

$consulta = $conexao->prepare('Select * from tabprodutos');
$consulta->execute();
?>
<title>Lista de clientes</title>
</head>


<body>
   <h2>Listagem de produtos</h2>
   <table>
      <tr>
         <th>Código</th>
         <th>Descriçaõ</th>
         <th>Imagem</th>
         <th>Preco</th>
         <th colspan="2">Ações</th>
      </tr>
      <?php
      while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) {
         echo "<tr><td>{$linha['proId']}</td>";
         echo "<td>{$linha['proDescricao']}</td>";
         echo "<td>{$linha['proImagem']}</td>";
         echo "<td>{$linha['proPreco']}</td>";
         echo "<td><a href='alterar_produto.php?id={$linha['proId']}' class='btn-floating orange'><i class='material-icons'>edit</i></a></td>";
         echo "<td><a href='exclui_produto.php?id={$linha['proId']}' class='btn-floating blue'><i class='material-icons'>delete</i></a></td></tr>";
      }
      echo "</table>";
      echo "<a href='loja.php' class='btn'>Adicionar produto</a>";
   
      ?>