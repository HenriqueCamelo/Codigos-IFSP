<?php
include 'config.php'; 
include 'cabecalho.php';
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loja de Tênis</title>
</head>
<body>
    
<section class="produtos">
    <div class="linha">
        <?php
        // Consulta ao banco de dados para obter informações dos produtos
        $consulta = $conexao->prepare('SELECT proId, proDescricao, proPreco FROM tabprodutos');
        $consulta->execute();

        while ($linha = $consulta->fetch(PDO::FETCH_ASSOC)) {
            $nome = $linha['proDescricao'];
            $preco = $linha['proPreco'];
            $id = $linha['proId'];
        ?>
        <article class="produto">
            <img src="../dbexemplo/Imgs/tenis<?php echo $id; ?>.jpg" alt="<?php echo $nome; ?>">
            <h2><?php echo $nome; ?></h2>
            <span class="preco">R$<?php echo $preco; ?></span>
            <button onclick="adicionarAoCarrinho('<?php echo $nome; ?>', <?php echo $preco; ?>, <?php echo $id; ?>)">Comprar 🛒</button>
        </article>
        <?php } ?>
    </div>
</section>

    <script>
        // Modificação: Adicionei a função adicionarAoCarrinho ao arquivo index.php
        function adicionarAoCarrinho(nome, preco, idProduto) {
            window.location.href = 'carrinho.php?codigo=' + idProduto;
        }
    </script>

    <?php
    include 'rodape.php';
    ?>
</body>
</html>
