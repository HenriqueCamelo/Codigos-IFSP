<?php
try{
    $conexao = new PDO('mysql:host=localhost;dbname=livraria', 'root', '');
    $conexao-> setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
    echo 'Conexão estabelecida com sucesso ! <br>';
}catch(PDOException $e){
    echo 'Erro de conexão com o banco de dados: '. $e->getMEssage();
}

?>