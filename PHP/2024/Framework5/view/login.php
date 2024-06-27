<html lang="PT-br">
<head>


    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
</head>
<body>

    <div class="ilha">
    <form method="POST" action="open.php">
    <h1>Acesso ao sistema</h1>
        <table>
            <tr>
                <td>Digite seu email: </td>
                <td><input type="email" name="logemail" required></td>
            </tr>
            <tr>
                <td>Digite sua senha: </td>
                <td><input type="password" name="logsenha" required></td>
            </tr>
            <tr>
                <td><input type="submit" value="Acessar" class="submit"></td>
            </tr>
            </table>
        <figure id="cadeado">
        <img src="img/cadeado.png" class="figura1">
        </figure>

    
    </form>
    </div>
</body>
</html>