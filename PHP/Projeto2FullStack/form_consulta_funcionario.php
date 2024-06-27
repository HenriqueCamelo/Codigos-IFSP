<?php

include_once 'config.php';
include_once "cabecalho.php";

echo "<h1>Consulta Funcionários</h1>";
$campos_form = filter_input_array(INPUT_GET, FILTER_DEFAULT);

if(!empty($campos_form['txtPesquisar']))
{

$dado = '%' . $campos_form['txtPesquisar'] . "%";

$sql = "SELECT * FROM tabfuncionarios WHERE funNome LIKE :valor ORDER BY funNome";
   $consulta = $conexao->prepare($sql);//resultados da consulta
   $consulta->bindParam(':valor',$dado);
   $consulta->execute();


//exibindo os resultados
while($registro = $consulta->fetch(PDO::FETCH_ASSOC))
{
  extract($registro);

  echo "ID: $funId <br>";
  echo "Nome: $funNome <br>";
  echo "Usuário: $funUsuario <br>";
  echo "Senha: $funSenha <br>";
  echo "Email: $funEmail <br>";
  echo "Cargo: $funCargo <br>";
  echo "Foto: $funFoto <br>";
  echo "<hr>";
}
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">

   <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
   <link rel="stylesheet" href="css/estilos.css">

   <!--Import Google Icon Font-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

<div style="margin:10px;">

   <!--Formulário para pesquisa-->
   <form action="" method="get">
      Pesquisar por:
      <input type="text" name="txtPesquisar" id="pesquisar" value="<?php if (isset($campos_form['txtPesquisar'])) echo $campos_form['txtPesquisar']; ?>" placeholder="Digite o valor">
      <br><br>
      
      <input type="submit" name="btnPesquisar" id="pesquisaCliente">
      <input type="reset" name="btnLimpar" id="limpar" value="Limpar">
      <a href='botoes.php' class='btn'>Listar funcionalidades</a>
      <a href='form_cadastrar_funcionarios.php' class='btn'>Adicionar funcionario</a>
   </form>

</div>

</body>
</html>

<?php
include 'rodape.php';
?>