


/* 1º Criar os objetos/arrays para os elementos: */
const array_img_produtos = document.querySelectorAll('.produtos')
const obj_div_exibe_desc = document.querySelector('#div_exibe_desc')

/* 2º Criar novos objetos para serem manipulados */
const obj_p_novo = document.createElement('p')

/* 3º Adicionar os eventos para chamar a função */
for ( obj_txt of array_img_produtos ) {
    obj_txt.addEventListener('click', 
        function() { FunExibeDescricao ( this.alt)}
    )
}
/* 4º Declarar a função para executar as ações: */
function FunExibeDescricao( param_alt ) {
    obj_p_novo.innerHTML = param_alt
    obj_p_novo.setAttribute('class', 'novo_p')    
    obj_div_exibe_desc.appendChild(obj_p_novo)
}


function clickMenu() {
    var menu = document.getElementById("itens");
    if (itens.style.display === "block") 
        itens.style.display = "none"
    else {
        itens.style.display = "block"
    }
}


function validarForms(){
    var nome = document.forms["form"]["nome"].value;
    {
        alert("\nCadastro feito, " + nome + "! \n\nSeja bem vindo ao melhor da tecnologia!" );
        return true;
    }
}
