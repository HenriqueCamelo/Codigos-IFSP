<?php
try{
    $conexao = new PDO ('mysql:host=localhost;dbname=projeto2fullstack','root', '');
    $conexao-> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}catch(PDOException $e){
    echo 'Erro de conexao com bancos de dados: '. $e->getMessage();
}



?>