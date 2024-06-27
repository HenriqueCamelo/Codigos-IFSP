<?php
include_once "cabecalho.php";
include_once "conf_meu.php";
?>

<div style="margin:10px;">
   <!--Formulário para pesquisa-->
   <form action="" method="get">
      Pesquisar por:
      <input type="text" name="txtPesquisar" id="pesquisar" value = "<?php if(isset($campo_form['txtPesquisar'])) echo $campo_form['txtPesquisar']?>" placeholder="Digite o Título">
      <br><br>
      <input type="submit" name="btnPesquisar" id="pesquisaCliente" class = "btn">
      <input type="reset" name="btnLimpar" id="limpar" value="Limpar" class = "btn">

   </form>
</div>

<?php
echo '<div style="margin:10px;">'; 
echo '<a href="lista.php" class="btn blue">Voltar</a><br>'; 


$campos_form = filter_input_array(INPUT_GET, FILTER_DEFAULT);

if(!empty($campos_form['btnPesquisar']))
{
    $dado = "%".$campos_form['txtPesquisar']."%"; 

    $sql = "SELECT * FROM tb_livros WHERE livroNome LIKE :valor ORDER BY livroNome";
    $consulta = $conexao->prepare($sql);
    $consulta->bindParam(':valor', $dado);
    $consulta->execute();

    while($registro = $consulta->fetch(PDO::FETCH_ASSOC))
    {
        extract($registro);
        echo "ID: $livroId <br>";
        echo "Nome: $livroNome <br>";
        echo "Editora = $livroEdi<br>";
        echo "Autor = $livroAut<br> ";
        echo "Data = $livroDataLan<br>";
        echo "Imagem = $livroImg<br>";
        echo "Descrição = $livroDescr<br>";
        echo "Preço = $livroPrec<br>";
        echo "<br>";
    }



}


echo "</div>";

include_once "rodape.php";
?>