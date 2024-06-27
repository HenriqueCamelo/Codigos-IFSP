<?php

include 'cabecalho.php';

?>

<main>
<div style = "margin:10px">
<form action="" method="get">
        Pesquisar por:
        <input type = "text" name = "txtPesquisar" id = "pesquisar" value ="<?php  if(isset($campos_form['txtPesquisar'])) echo $campos_form['txtPesquisar']?>" placeholder = "Digite o Nome" required>
        <br><br>
        <input type="submit" name = "btnPesquisar" id ="pesquisaProduto">
        <input type="reset" name = "btnLimpar" id ="limpar" value = "Limpar">

        <?php

        echo "<style>
        .botoes{
        justify-content: center;
        display: grid;
        grid-template-columns: 200px 200px;
        }
        </style>";

        echo "<div class='botoes'>";
        echo "<a href='lista_prod.php' class='btn green'>Voltar</a>";
        echo "<a href='../botoes.php' class='btn'>Listar funcionalidades</a>";
        echo "</div>";
        ?>
</form>
</div>
</main>

<?php
include_once 'config.php';

echo "<h1>Consultar Fornecedor<h1>";
$campos_form = filter_input_array(INPUT_GET, FILTER_DEFAULT);

if(!empty($campos_form['btnPesquisar']))
{
        $dado = "%".$campos_form['txtPesquisar']."%";
        
        $sql = "SELECT * FROM tb_produto WHERE prodForn like :valor ORDER BY prodForn";
        $consulta = $conexao->prepare($sql);
        $consulta->bindParam(':valor', $dado);
        $consulta->execute();

        while($registro = $consulta->fetch(PDO::FETCH_ASSOC))
        {
                extract($registro);
                echo "ID: $prodId<br>";
                echo "Tipo: $prodTipo<br>";
                echo "Preço: $prodPreco<br>";
                echo "Quantidade: $prodQnt<br>";
                echo "Fornecedor: $prodForn<br>";
                echo "Unidade: $prodUnidadeLoja<br>";
                echo "<hr>";
        }
}
else
{

}       
?>

<?php

include 'rodape.php';

?>