<?php
        require_once('../factory/conexao.php'); 
        $conn = new Caminho();
      
        $consulta = "select *from usuarios";  

        $resultado = $conn->getConn()->prepare($consulta); // Executa a consulta SQL e armazena o resultado na variável $resul.
        $resultado->execute();   
    
        while ($cont = $resultado->fetch(PDO::FETCH_ASSOC)) {
        // Inicia um loop para percorrer cada registro retornado pela consulta.

            echo $cont['id_usuario'] . ' - ' . $cont['nome'] ; // Exibe o ID e o nome do usuário.

            echo '<a href="../model/excluirusuario.php?id='.$cont['id_usuario'].'">X</a>'; // Exibe um link para excluir o usuário, passando o ID do usuário como parâmetro na URL.
        
            echo '<img src="../fotos/'.$cont['foto'].'" alt="descrição da imagem" class="fotos"><br>'; // Exibe uma imagem usando o nome da foto armazenado no banco de dados.
        
            echo "<hr/ >";
        
        }

?>
