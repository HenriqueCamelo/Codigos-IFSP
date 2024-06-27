<?php
include 'cabecalho.php';
include_once 'config.php';


$consulta = $conexao->prepare('Select * from tabfuncionarios');
$consulta->execute();
?>
<title>Lista de funcionarios</title>
</head>


<body>
   <h2>Listagem de funcionarios</h2>
   <table>
      <tr>
         <th>Código</th>
         <th>Nome</th>
         <th>Senha</th>
         <th>Email</th>
         <th>Cargo</th>
         <th>Usuario</th>
         <th>Foto</th>

         <th colspan="2">Ações</th>
      </tr>

      <?php
      while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) 
      {
         echo "<tr><td>{$linha['funId']}</td>";
         echo "<td>{$linha['funNome']}</td>";
         echo "<td>{$linha['funSenha']}</td>";
         echo "<td>{$linha['funEmail']}</td>";
         echo "<td>{$linha['funCargo']}</td>";
         echo "<td>{$linha['funUsuario']}</td>";
         echo "<td>{$linha['funFoto']}</td>";

   
         echo "<td><a href='altera_funcionario.php?id={$linha['funId']}' class='btn'><i class='material-icons'>Editar</i></a></td>";
         echo "<td><a href='excluir_funcionario.php?id={$linha['funId']}' class='btn'><i class='material-icons'>Remover</i></a></td></tr>";
    
      }
      echo "</table>";

      echo "<div class='botoes'>";
      echo "<a href='botoes.php' class='btn'>Listar funcionalidades</a>";
      echo "<a href='form_cadastrar_funcionarios.php' class='btn'>Adicionar funcionario</a>";
      echo "</div>";
?>

<?php
include 'rodape.php';
?>