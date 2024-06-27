<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela Principal</title>
    <?php
        session_start();
        if(!isset($_SESSION['idAnselmo']) == true ){
            header('location: ../index.php');
        }

        
    ?>
</head>
<body>
        BEM VINDO DE VOLTA
</body>
</html>