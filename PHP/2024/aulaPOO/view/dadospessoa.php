<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <?php
        include_once "../control/pessoa.php";    
    ?>
</head>
<body>
    
    <?php
        $dados = new Pessoa; // Pessoa é uma classe, $dados é uma variavel do tipo objeto, recebe o que vem da classe
        echo "<h1>Original</h1>";
        echo $dados->nome;
        echo $dados->idade;
        echo "<h1>Reutilização das variaveis</h1>";
        echo $dados->nome = "Anselomo<br>";
        echo $dados->idade = "50<br>";
        echo "<br>";
        echo $dados->email;
        echo "<h1>Exibir função</h1>";
        $dados->exibirnome();
        echo "<h1>Exibir Atividade</h1>";
        $dados->exibirnome();
        echo "<h1>Exibir Aluno</h1>";
        $dados->cadastroAluno();
        echo "<h1>Exibir Professor</h1>";
        $dados->cadastroProfessor();
        echo "<h1>Exibir Pendente</h1>";
        $dados->cadastroPendente();


    ?>


</body>
</html>