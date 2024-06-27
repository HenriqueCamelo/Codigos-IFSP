<?php
try{
    $conexao = new PDO ('mysql:host=localhost;dbname=lojatenis','root', '');
    $conexao-> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    //echo  'Conectado ao banco de dados <br>';
}catch(PDOException $e){
    echo 'Erro de conexao com bancos de dados: '. $e->getMessage();
}



?>