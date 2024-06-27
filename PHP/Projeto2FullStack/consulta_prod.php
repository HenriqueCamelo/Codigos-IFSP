<?php
 include_once 'config.php';

echo "<h1>Consulta Fornecedor</h1>";
$dado = '%a%';

$sql = "SELECT * FROM tb_produto WHERE prodTipo LIKE '$dado' ORDER BY prodTipo";
$consulta = $conexao->prepare($sql);
$consulta->execute();

//exibição de resultados
while($registro = $consulta->fetch(PDO::FETCH_ASSOC))
{
    echo "<pre>";
    var_dump($registro);
    echo "</pre>";

} 

?>

<?php

include 'rodape.php';

?>