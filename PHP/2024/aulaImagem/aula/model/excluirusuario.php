<?php
require_once '../factory/conexao.php';

$cod = $_GET['id'];

$conn = new caminho();
$query = "DELETE FROM usuarios WHERE id_usuario = :id ";

$resultado = $conn->getConn()->prepare($query);

$resultado->bindParam(':id',$cod);

if($resultado->execute()) {
    echo "
        <script>
                alert('Dados excluído com sucesso');
                location.href = 'exibirfotos.php';
        </script>
    ";
}
else
{
    echo "
        <script>
                alert('Dados não excluido com sucesso');
                location.href = 'exibirfotos.php';
        </script>
    ";
}

?>
