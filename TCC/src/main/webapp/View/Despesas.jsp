<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="model.SessaoUtil" %>
<%@ page import="model.MensagemUtil" %>
<%
if (!SessaoUtil.verificaSessaoValida(request, response)) {
    return; // Impede a continuação do processamento se a sessão for inválida
}
%>

<%
    String status = request.getParameter("status");
    String erro = request.getParameter("msg");
    out.print(MensagemUtil.gerarAlerta(status, erro));
%>

<% 
		// Recupera o nome do usuário armazenado na sessão
		String nomeFazenda = (String) session.getAttribute("nomeFazenda");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Despesas</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
		
		<br>
		
		<div class="container ">
			<div class="container p-4 bg-white mt-5 border-4 border-top border-success shadow-lg">	
				
				<div class="container px-4 pb-3 pt-3" id="hanging-icons">
			    <a id="linkCadUser"  href="MenuDespesas.jsp">voltar</a>
			    <h2 class="pb-2">Adicionar Despesa</h2>
			    <h6 class="pb-2 border-bottom"> <a href= 'MenuPrincipal.jsp'class='text-decoration-none text-black'>Menu Principal</a> > <a href= 'MenuDespesas.jsp'class='text-decoration-none text-black'>Menu Despesas</a> > Adicionar Despesas </h6>
				</div>
			
				<!-- Tooltip de fornecedor -->
				<div id="fornecedorTooltip" class="card shadow p-3 bg-light"
				     style="display:none; position:absolute; z-index:999; width:300px;">
				  <strong>Carregando fornecedor...</strong>
				</div>
				
				<div  id="inserirDespesa" class="container mx-auto ">
						<form action="/TCC/ServeletDespesa?acao=cadastrardespesa" method="post"> 
					
					    <div class="mb-3">
					      <label for="dataCompraDes">Data de Compra:</label>
					      <input type="date" class="form-control bg-light" id="dataCompraDes" placeholder="Insira a data" name="dataCompraDes" required>
					    </div>
					    
					    <div class="mb-3">
						  <label for="fornecedorDes">Fornecedor:</label>
						  <select class="form-control bg-light" id="fornecedorDes" name="fornecedorDes" required>
						    <option value="">Selecione um fornecedor</option>
						  </select>
						</div>
					    
					    <div class="mb-3">
					      <label for="enderecoDes">Endereço:</label>
					      <input type="text" class="form-control bg-light" id="enderecoDes" placeholder="Digite o endereço" name="enderecoDes" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    </div>
					    
					    <div class="mb-3">
					    <label for="cidadeDes">Cidade:</label>
					      <input type="text" class="form-control bg-light" id="cidadeDes" placeholder="Digite a cidade " name="cidadeDes" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    </div>
					    
					    <div class="mb-3">
					    <label for="bairroDes">Bairro:</label>
					      <input type="text" class="form-control bg-light" id="bairroDes" placeholder="Digite o bairro " name="bairroDes" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    </div>
					    
					    <div class="mb-3">
					    <label for="CPFCNPJDes">CNPJ/CPF:</label>
					      <input type="text" class="form-control bg-light" id="CPFCNPJDes" placeholder="Digite o CPF ou CNPJ " name="CPFCNPJDes" required  pattern="\d{11}" maxlength="11" title="Digite exatamente 11 números do CPF, sem pontos ou traços.">
					    </div>
					    
					    <div class="mb-3">
					    <label for="valorDes">Valor:</label>
					      <input type="number" class="form-control bg-light" id="valorDes" placeholder="Digite o valor da despesa " name="valorDes" required>
					    </div>
					    
					    <div class="mb-3">
					    <label for="numParcelasDes">Número de Parcelas:</label>
					      <input type="number" class="form-control bg-light" id="numParcelasDes" placeholder="Digite o numero de parcelas " name="numParcelasDes" required>
					    </div>
					    
					    <div class="mb-3">
					    <label for="fazendaDespesa">Confirme com o nome de sua fazenda(nome da fazenda):</label>
					    <input type="text" class="form-control bg-light" id="fazendaDespesa" placeholder="" value="<%= nomeFazenda %>" name="fazendaDespesa" required pattern="[a-zA-Z0-9\s]+" title="Não use caracteres especiais.">
					    </div>
												
					<br><button id="btnLogin" style="margin-left:25%" type="submit" class="btn btn-success my-2 w-50 ">Salvar</button>
				    <input id="linkCadUser" style="margin-left:25%" class="btn btn-danger my-2 w-50 " href="#" type="reset" value="Cancelar">
							
					</form> 
				</div>
			</div> 
		</div>
		
<script>
$(document).ready(function () {
  const $selectFornecedor = $('#fornecedorDes');
  const $tooltipFornecedor = $('#fornecedorTooltip');

  // Carregar fornecedores
  $.ajax({
    url: '/TCC/ServletFornecedor?acao=formFornecedor',
    type: 'POST',
    dataType: 'json',
    success: function (lista) {
      if (lista.length === 0) {
        $selectFornecedor.append('<option disabled>Nenhum fornecedor disponível</option>');
      } else {
        lista.forEach(f => {
          $selectFornecedor.append(
            $('<option>', {
              value: f.idFornecedor, // <- será enviado no POST
              text: f.nomeFornecedor + ' (' + f.idFornecedor + ')'
            }).data('info', f) // <- anexa o objeto ao option
          );
        });
      }
    },
    error: function () {
      $selectFornecedor.append('<option disabled>Erro ao carregar fornecedores</option>');
    }
  });

  // Mostrar tooltip com dados do fornecedor selecionado
  $selectFornecedor.on('mouseenter', function () {
    const offset = $selectFornecedor.offset();
    const height = $selectFornecedor.outerHeight();
    const fornecedorSelecionado = $selectFornecedor.find('option:selected').data('info');

    if (fornecedorSelecionado) {
      const html = `
        <strong>${fornecedorSelecionado.nomeFornecedor}</strong><br>
        CPF/CNPJ: ${fornecedorSelecionado.cpfCnpj}<br>
        Cidade: ${fornecedorSelecionado.cidade}<br>
        Bairro: ${fornecedorSelecionado.bairro}<br>
        Endereço: ${fornecedorSelecionado.endereco}
      `;
      $tooltipFornecedor.css({
        top: offset.top + height + 5,
        left: offset.left
      }).html(html).fadeIn();
    }
  }).on('mouseleave', function () {
    $tooltipFornecedor.fadeOut();
  });
});
</script>
</body>
</html>