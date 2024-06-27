<?php
require_once "config.php";
require_once "cabecalho.php";
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
   <meta charset="UTF-8">
   <title>Cadastro de Clientes</title>
</head>
<body>
   <div class="row">
      <div class="col s12 m6 push-m3">
        <h3 class="light">Cadastro de funcionarios</h3>
        <form action="cadastrar_funcionarios.php" method="post">

               <div class="input-field col s12">
               <label for="nomefunc">Nome: </label><br>
               <input type="text" name="txtnomefunc" id="nomefunc">
               </div>

               <div class="input-field col s12">
               <label for="senhafunc">Senha: </label><br>
               <input type="text" name="txtsenhafunc" id="senhafunc" maxlength="6">
               </div>

               <div class="input-field col s12">
               <label for="emailfunc">Email: </label><br>
               <input type="email" name="txtemailfunc" id="emailfunc">
               </div>
 
               <div class="input-field col s12">
               <label for="cargofunc">Cargo: </label><br>
               <input type="text" name="txtcargofunc" id="cargofunc">
               </div>

               <div class="input-field col s12">
               <label for="usuariofunc">Usuario: </label><br>
               <input type="text" name="txtusuariofunc" id="usuariofunc">
               </div>

               <div class="input-field col s12">
               <label for="fotofunc">Foto: </label><br>
               <input type="text" name="txtfotofunc" id="fotofunc">
               </div>


               
            <button type="submit" class="btn" name="btncadastrarfunc">Cadastrar </button>
            <a href="listar_funcionarios.php" class="btn green">Listar Funcionarios</a>
            <a href="form_consulta_funcionario.php" class="btn green">Consultar Funcionarios</a>
            <a href='botoes.php' class='btn'>Listar funcionalidades</a>
        </form>
        </div>
    </div>
</body>
</html>

<?php
include 'rodape.php';
?>