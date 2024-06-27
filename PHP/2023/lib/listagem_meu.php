<?php
include_once 'cabecalho.php';
require_once 'conf_meu.php';

$consulta = $conexao->prepare('Select * from tb_cadas');
$consulta->execute();
?>
<title>Lista de clientes</title>
</head>


<body>
   <h2>Listagem de clientes</h2>
   <table>
      <tr>
         <th>Código</th>
         <th>Nome</th>
         <th>Celular</th>
         <th>Data Nasc.</th>
         <th>Senha.</th>
         <th>verificacao.</th>
         <th colspan="2">Ações</th>
      </tr>
      <?php
      while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) {
         echo "<tr><td>{$linha['cadId']}</td>";
         echo "<td>{$linha['cadNome']}</td>";
         echo "<td>{$linha['cadCel']}</td>";
         echo "<td>{$linha['cadDataNasc']}</td>";
         echo "<td>{$linha['cadSenha']}</td>";
         echo "<td>{$linha['cadVerificacao']}</td>";
         echo "<td><a href='alterar_cliente_meu.php?id={$linha['cadId']}' class='btn-floating orange'><i class='material-icons'>edit</i></a></td>";
         echo "<td><a href='excluir_cliente_meu.php?id={$linha['cadId']}' class='btn-floating blue'><i class='material-icons'>delete</i></a></td></tr>";
      }
      echo "</table>";
      
      echo '<div style="margin:10px;">';
      echo "<a href='form_cad_clientes_meu.php' class='btn'>Adicionar cliente</a>";
      echo "<a href='consulta_cadas.php' class='btn'>Consultar clientes</a>";
      echo "<a href='listar_func.php' class='btn blue'>Voltar</a>";
      echo "</div>";
      
      include_once "rodape.php";
      ?>