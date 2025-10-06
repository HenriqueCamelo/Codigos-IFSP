<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Informações Funcionarios</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="container ">
			<div class="container p-4 bg-light mt-3 border rounded-4">	
				
				
				
				<div class="container p-3 rounded-3">
					<h3>Informações Funcionarios</h3>
				</div>
				
				<a  class="p-3 my-3 w-100" href="MenuPrincipal.jsp">Voltar</a>
				<a  class="p-3 my-3 w-100" href="CadastrarFuncionario.jsp">Adicionar</a>
				
				<script>
    async function InfomaçõesFuncionario() {
        const response = await fetch("/TCC/ServletFuncionario?acao=listaFuncionario", {
            method: "POST",
        });

        const listaFuncionarios = await response.json();

        listaFuncionarios.forEach((funcionario) => {
              
            // Criação do container principal
            const container = document.createElement("div");
            container.className = "container p-4 bg-light mt-3 border rounded-4";

            // Nome do Funcionário
            const nomeFuncionario = document.createElement("h5");
            nomeFuncionario.textContent = `Nome: ` + funcionario.nomefun;
            container.appendChild(nomeFuncionario);

            // Sexo
            const sexo = document.createElement("p");
            sexo.textContent = `Sexo: ` + funcionario.sexo;
            container.appendChild(sexo);

            // Data de Nascimento
            const dataNascimento = document.createElement("p");
            dataNascimento.textContent = `Data de Nascimento: ` + funcionario.dataNascimento;
            container.appendChild(dataNascimento);

            // CPF
            const cpf = document.createElement("p");
            cpf.textContent = `CPF: ` + funcionario.CPF;
            container.appendChild(cpf);

            // Banco
            const banco = document.createElement("p");
            banco.textContent = `Banco: ` + funcionario.banco;
            container.appendChild(banco);

            // Telefone
            const telefone = document.createElement("p");
            telefone.textContent = `Telefone: ` + funcionario.telefone;
            container.appendChild(telefone);

            // Botão de Editar
            const botaoEditar = document.createElement("a");
            botaoEditar.textContent = "Editar";
            botaoEditar.href = `editarFuncionario.jsp?id=` + funcionario.idFuncionario +
                                `&nomefun=` + funcionario.nomefun +
                                `&sexo=` + funcionario.sexo +
                                `&dataNascimento=` + funcionario.dataNascimento +
                                `&CPF=` + funcionario.CPF +
                                `&banco=` + funcionario.banco +
                                `&telefone=` + funcionario.telefone;
            botaoEditar.className = "btn btn-danger my-2 w-50";
            botaoEditar.style.marginLeft = "25%";
            container.appendChild(botaoEditar);

            // Botão de Deletar
            const formExcluir = document.createElement("form");
            formExcluir.method = "POST";
            formExcluir.action = "/TCC/ServletFuncionario?acao=deletarFuncionario&id=" + funcionario.idFuncionario;
            const submitButtonExcluir = document.createElement("button");
            submitButtonExcluir.textContent = "Deletar";
            submitButtonExcluir.className = "btn btn-warning my-2 w-50";
            submitButtonExcluir.style.marginLeft = "25%";
            submitButtonExcluir.type = "submit";
            formExcluir.appendChild(submitButtonExcluir);
            
            container.appendChild(formExcluir);
            
            // Adiciona o container ao corpo da página
            document.body.appendChild(container);
            console.log(funcionario.nomefun);
        });
    }

    InfomaçõesFuncionario();
</script>
				
			</div>
	</div>

</body>
</html>