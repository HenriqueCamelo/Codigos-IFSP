<?php
include_once 'config.php';
include 'cabecalho.php';

$consulta = $conexao->prepare('SELECT * from tb_produto');
$consulta->execute();
?>
<title>Lista de Produtos</title>
</head>

<body>
   <h2>Listagem de Produtos a vender</h2>
   <table>
      <tr>
         <th>Código</th>
         <th>Tipo</th>
         <th>Preco</th>
         <th>Quantidade</th>
         <th>Fornecedor</th>
         <th>UnidadeLocal</th>
         
         <th colspan="2">Ações</th>
      </tr>
      <?php
      while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) 
      {
         echo "<tr><td>{$linha['prodId']}</td>";
         echo "<td>{$linha['prodTipo']}</td>";
         echo "<td>{$linha['prodPreco']}</td>";
         echo "<td>{$linha['prodQnt']}</td>";
         echo "<td>{$linha['prodForn']}</td>";
         echo "<td>{$linha['prodUnidadeLoja']}</td>";
         echo "<td><a href='alterar_prod.php?id={$linha['prodId']}' '><i class='btn'>Editar</i></a></td>";
         echo "<td><a href='exclui_prod.php?id={$linha['prodId']}' '><i class='btn'>Deletar</i></a></td></tr>";
      }

      echo "<style>
      .botoes{
         justify-content: center;
      display: grid;
  grid-template-columns: 200px 200px 200px;
      }
      </style>";

      echo "</table>";
      echo "<div class='botoes'>";
      echo "<a href='produto.php' class='btn'>Adicionar produto</a>";
      echo "<a href='consultar.php' class='btn'>Consultar fornecedor</a>";
      echo "<a href='../botoes.php' class='btn'>Listar funcionalidades</a>";
      echo "</div>";
      ?>

<?php

include_once 'rodape.php';

?>