<?php
include_once 'cabecalho.php';
include_once 'conf_meu.php';

$consulta = $conexao->prepare('Select * from tabfuncionarios');
$consulta->execute();
?>
<title>Lista de funcionarios</title>
</head>


<body>
   <h2>Listagem de funcionario</h2>
   <table>
      <tr>
         
         <th>Nome</th>
         <th>Senha</th>
         <th>Email.</th>
         <th>Cargo.</th>
         <th>Usuario.</th>
         <th>Foto.</th>
         <th colspan="2">Ações</th>
      </tr>
      <?php
      while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) {
         echo "<tr><td>{$linha['funId']}</td>";
         echo "<td>{$linha['funNome']}</td>";
         echo "<td>{$linha['funSenha']}</td>";
         echo "<td>{$linha['funEmail']}</td>";
         echo "<td>{$linha['funCargo']}</td>";
         echo "<td>{$linha['funUsuario']}</td>";
         echo "<td>{$linha['funFoto']}</td>";
         echo "<td><a href='alterar_func_meu.php?id={$linha['funId']}' class='btn-floating orange'><i class='material-icons'>edit</i></a></td>";
         echo "<td><a href='exclui_func_meu.php?id={$linha['funId']}' class='btn-floating blue'><i class='material-icons'>delete</i></a></td></tr>";
      }
      
      echo "</table>";
      
      echo '<div style="margin:10px;">';
      echo "<a href='form_cad_func.php' class='btn'>Adicionar Funcionario</a>";
      echo "<a href='consulta_func.php' class='btn'>Consultar funcionario</a>";
      echo "<a href='listagem_meu.php' class='btn'>Lista de Clientes</a>";
      echo "<a href='lista.php' class='btn'>Lista de Livros</a>";
      echo "<a href='lista_produtos.php' class='btn'>Verificar Loja</a>";
      echo "</div>";
      
      include_once "rodape.php";
      ?>