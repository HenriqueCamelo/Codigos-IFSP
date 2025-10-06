<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
  <title>Vacinas</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

<div class="container">
  <div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
    <div class="container px-4 pb-3 pt-3" id="hanging-icons">
      <a id="linkCadUser" href="MenuAnimais.jsp">voltar</a>
      <h2 class="pb-2">Vacinas</h2>
      <h6 class="pb-2 border-bottom"> 
        <a href='MenuPrincipal.jsp' class='text-decoration-none text-black'>Menu Principal</a> > 
        <a href='MenuAnimais.jsp' class='text-decoration-none text-black'>Animais</a> > Vacinas 
      </h6>
      <br>
      <a id="linkCadUser" class="btn btn-danger" href="CadastrarVacina.jsp"> + Cadastrar Vacina</a>
    </div>

    <!-- TOOLTIP para vacinas -->
    <div id="vacinaTooltip" class="card shadow p-3 bg-light" 
         style="display:none; position:absolute; z-index:999; width:250px;">
      <strong>Carregando vacinas...</strong>
    </div>

    <!-- Tooltip para animais -->
    <div id="animalTooltip" class="card shadow p-3 bg-light" 
         style="display:none; position:absolute; z-index:999; width:250px;">
      <strong>Carregando animais...</strong>
    </div>

    <div id="vacinasArea" class="container mx-auto">
      <form action="/TCC/ServeltAnimal?acao=vacina" method="post">

        <!-- ID Animal como select -->
        <div class="mb-3 mt-3">
          <label for="idAn">Id Animal:</label>
			<select class="form-control bg-light" id="idAn" name="idAn" required>
			  <option value="">Selecione o animal</option>
			</select>
        </div>

        <!-- Data da Vacina -->
        <div class="mb-3">
          <label for="dataVac">Data:</label>
          <input type="date" class="form-control bg-light" id="dataVac" name="dataVac" required>
        </div>

        <!-- Vacina como select -->
        <div class="mb-3">
          <label for="vacina">Vacina:</label>
			<select class="form-control bg-light" id="vacina" name="vacina" required>
			  <option value="">Selecione a vacina</option>
			</select>
        </div>

        <br>
        <button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50">Salvar</button>
        <br>
        <input id="linkCadUser" style="margin-left:25%" class="btn btn-danger my-2 w-50 " href="#" type="reset" value="Cancelar">
      </form>
    </div>
  </div>
</div>

<!-- Script para preencher selects e mostrar tooltips -->
<script>
  $(document).ready(function () {
    const $animalSelect = $('#idAn');
    const $animalTooltip = $('#animalTooltip');

    // Carrega animais no select e tooltip
    $.ajax({
      url: '/TCC/ServeltAnimal?acao=formAnimal',
      type: 'POST',
      dataType: 'json',
      success: function (lista) {
        if (lista.length === 0) {
          $animalTooltip.html('<p>Nenhum animal cadastrado.</p>');
        } else {
          let html = '<ul>';
          lista.forEach(function (animal) {
            html += '<li>ID: ' + animal.idAnimal + ' - ' + animal.nomeAnimal + '</li>';
            $animalSelect.append(
              $('<option>', {
                value: animal.idAnimal,
                text: animal.idAnimal + ' - ' + animal.nomeAnimal
              })
            );
          });
          html += '</ul>';
          $animalTooltip.html(html);
        }
      },
      error: function () {
        $animalTooltip.html('<p class="text-danger">Erro ao carregar animais.</p>');
      }
    });

    // Tooltip
    $animalSelect.on('mouseenter', function () {
      const offset = $animalSelect.offset();
      const height = $animalSelect.outerHeight();
      $animalTooltip.css({ top: offset.top + height + 5, left: offset.left }).fadeIn();
    });
    $animalSelect.on('mouseleave', function () {
      $animalTooltip.fadeOut();
    });
  });
</script>

<script>
  $(document).ready(function () {
    const $vacinaSelect = $('#vacina');
    const $vacinaTooltip = $('#vacinaTooltip');

    // Carrega vacinas no select e tooltip
    $.ajax({
      url: '/TCC/ServeltAnimal?acao=formVacina',
      type: 'POST',
      dataType: 'json',
      success: function (lista) {
        if (lista.length === 0) {
          $vacinaTooltip.html('<p>Nenhuma vacina cadastrada.</p>');
        } else {
          let html = '<ul>';
          lista.forEach(function (vacina) {
            html += '<li>ID: ' + vacina.idVacina + ' - ' + vacina.nomeVacina + '</li>';
            $vacinaSelect.append(
              $('<option>', {
                value: vacina.idVacina,
                text: vacina.idVacina + ' - ' + vacina.nomeVacina
              })
            );
          });
          html += '</ul>';
          $vacinaTooltip.html(html);
        }
      },
      error: function () {
        $vacinaTooltip.html('<p class="text-danger">Erro ao carregar vacinas.</p>');
      }
    });

    // Tooltip
    $vacinaSelect.on('mouseenter', function () {
      const offset = $vacinaSelect.offset();
      const height = $vacinaSelect.outerHeight();
      $vacinaTooltip.css({ top: offset.top + height + 5, left: offset.left }).fadeIn();
    });
    $vacinaSelect.on('mouseleave', function () {
      $vacinaTooltip.fadeOut();
    });
  });
</script>


</body>
</html>
