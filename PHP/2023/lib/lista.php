<?php
include_once 'cabecalho.php';
include_once 'conf_meu.php';

$consulta = $conexao->prepare('Select * from tb_livros');
$consulta->execute();
?>
<title>Lista de livros</title>
</head>


<body>
   <h2>Listagem de livros</h2>
   <table>
      <tr>
         <th>Código</th>
         <th>Nome</th>
         <th>Editora</th>
         <th>Autor</th>
         <th>Lançamento</th>
         <th>Imagem</th>
         <th>Descrição</th>
         <th>Preço</th>
         
         <th colspan="2">Ações</th>
      </tr>
      <?php
      while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) {
         echo "<tr><td>{$linha['livroId']}</td>";
         echo "<td>{$linha['livroNome']}</td>";
         echo "<td>{$linha['livroEdi']}</td>";
         echo "<td>{$linha['livroAut']}</td>";
         echo "<td>{$linha['livroDataLan']}</td>";
         echo "<td>{$linha['livroImg']}</td>";
         echo "<td>{$linha['livroDescr']}</td>";
         echo "<td>{$linha['livroPrec']}</td>";
         echo "<td><a href='alterar_livro_meu.php?id={$linha['livroId']}' class='btn-floating orange'><i class='material-icons'>edit</i></a></td>";
         echo "<td><a href='excluir_livro_meu.php?id={$linha['livroId']}' class='btn-floating blue'><i class='material-icons'>delete</i></a></td></tr>";
      }
      echo "</table>";
      
      echo '<div style="margin:10px;">';
      echo "<a href='form_cad_livro_meu.php' class='btn'>Adicionar Livro</a>";
      echo "<a href='consulta_livro.php' class='btn'>Consultar Livro</a>";
      echo "<a href='listar_func.php' class='btn blue'>Voltar</a>";
      echo "</div>";
      
      include_once "rodape.php";
      ?>