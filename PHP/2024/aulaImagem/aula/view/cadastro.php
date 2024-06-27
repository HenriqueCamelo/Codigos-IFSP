<!DOCTYPE html>
<html lang="pt-br">
    <head>
    <meta charset="utf-8">
    <title>Cadastro de usuários</title>
    <style>
        .fotos {
            width: 300px;
            height: 200px;
        }
    </style>

    </head>

    <body>
        <h1>Cadastrar Usuário</h1>
        <form action="../model/inserireexibir.php" method="post" enctype="multipart/form-data" name="cadastro" >
            <br>
            Nome:<br>
            <input type="text" name="nome"><br><br>
            Senha:<br>
            <input type="password" id="senha" name="senha">
            <br><br>
            Escolha uma imagem:
            <input type="file" name="foto" id="foto"><br><br>
            <input type="submit" id="bmitBtn" name="Cadastrar" value="Cadastrar">
        </form>
    </body>
</html>
