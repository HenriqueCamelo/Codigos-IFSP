<?php
include_once "cabecalho.php";
include_once "conf_meu.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<main>
<div class = "row">

<!--Formulário para pesquisa-->
<form action="" method="get">
   
<div class = "col s12 m6 push-m3">
<div class="input-field col s12"> 
Nome:
   <input type="text" name="txtNome" id="loginNome" value = "<?php if(isset($campo_form['txtNome'])) echo $campo_form['txtNome']?>" placeholder="Digite o Usuario do Funcionário">
   <br><br>
 </div>

 <div class="input-field col s12">
 Senha:
   <input type="text" name="txtSenha" id="loginSenha" value = "<?php if(isset($campo_form['txtSenha'])) echo $campo_form['txtSenha']?>" placeholder="Digite a Senha">
   <br><br>
 </div>
   <input type="submit" name="btnPesquisar" id="pesquisa" class = "btn blue">
   <input type="reset" name="btnLimpar" id="limpar" value="Limpar" class = "btn blue">
</form>
</div>

</div> 
</main>
</body>
</html>


<?php

$campos_form = filter_input_array(INPUT_GET, FILTER_DEFAULT);
session_start();
$teste = 1;


function erro()
{
    $_SESSION['tentativas'] = 1;
       
}

if(!empty($campos_form['btnPesquisar']))
{
    
    
    $dadoNome = "%".$campos_form['txtNome']."%"; 
    $dadoSenha = "%".$campos_form['txtSenha']."%"; 

    
    
    $sql = "SELECT * FROM tabfuncionarios WHERE funUsuario LIKE :nome AND funSenha like :senha";
    $consulta = $conexao->prepare($sql);
    $consulta->bindParam(':nome', $dadoNome);
    $consulta->bindParam(':senha', $dadoSenha);
    $consulta->bindParam(':senha', $dadoSenha);
    $consulta->execute();

    $contador = $consulta->rowcount();

    //echo "$contador";

    while($registro = $consulta->fetch(PDO::FETCH_ASSOC))
    {
        $teste = 0;  
    }

    if($teste == 0 )
    {
        echo "Deu Certo";
        header('location:listar_func.php');
    }else{
        echo "Deu erado";
        echo $_SESSION['tentativas'];
        $_SESSION['tentativas']++;
        
    }

       
       
    if($_SESSION['tentativas'] > 3)
    {
        erro();
        session_destroy();
        header('location:semaceso.php');
    }
}



include_once "rodape.php";

?>