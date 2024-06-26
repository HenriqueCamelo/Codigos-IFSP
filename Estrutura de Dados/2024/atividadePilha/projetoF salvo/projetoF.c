#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "projetoF.h"

//De forma geral, a grande maioria das funções aqui escritas foram retiradas das atividades e powerpoints mostradas em aulas.

struct elemento
{
    FUNCIONARIO dados;
    struct elemento *prox;
};

typedef struct elemento ELEM;

//o crialista foi retirado do powerpoint mostrado em aula.
Lista *crialista()
{
    Lista *li;
    li = (Lista*) malloc(sizeof(Lista));
    if(li != NULL)
    {
        *li = NULL;
    }
    return li;
}

//o listaCheia foi retirado do powerpoint mostrado em aula. Verifica se alista esta cheia.
int listaCheia(Lista *li)
{
    return 0;
}

//o listaVazia foi retirado do powerpoint mostrado em aula. Verifica se a lista esta vazia.
int listaVazia(Lista *li)
{
    if(li == NULL)
    {
        return 1;
    }
    if(*li == NULL)
    {
        return 1;
    }
    return 0;
}

//o apagaLista foi retirado do powerpoint mostrado em aula. Apaga alista por completo.
void apagaLista(Lista *li){
if(li != NULL)
{
    ELEM *no;
    while((*li) != NULL)
    {
        no = *li;
        *li = (*li)->prox;
        free(no);
    }
    free(li);
}
}

//o tamLista foi retirado do powerpoint mostrado em aula. Verifica o tamanho da lista.
int tamLista(Lista *li)
{
    if(li == NULL)
    {
        return 0;
    }
    int acum = 0;
    ELEM *no = *li;
    while(no != NULL)
    {
        acum++;
        no = no->prox;
    }
    return acum;
}

//o insere_lista_ordenada foi retirado do powerpoint mostrado em aula. Insere a struct funcionario a lista.
int insere_lista_ordenada(Lista *li, FUNCIONARIO fu)
{
    if(li == NULL)
    {
        return 0;
    }
    ELEM *no = (ELEM*) malloc(sizeof(ELEM));
    if(no == NULL)
    {
        return 0;
    }
    no->dados = fu;
    if(listaVazia(li))
    {
        no->prox = (*li);
        *li = no;
        return 1;
    }
    else
    {
        ELEM *ant, *atual= *li;
        while(atual != NULL && atual->dados.id< fu.id)
        {
            ant = atual;
            atual = atual->prox;
        }
        if(atual == *li)
        {
            no->prox = (*li);
            *li = no;
        }
        else
        no->prox = ant->prox;
        ant->prox = no;
    }
    return 1;
}

//o remove_lista foi retirado do powerpoint mostrado em aula. Removeo o usuario da lista a partir do número dado pelo usuario.
int remove_lista(Lista *li, int idp)
{
    if(li == NULL)
    {
        return 0;
    }
    ELEM *ant, *no = *li;
    while(no != NULL && no->dados.id != idp)
    {
        ant = no;
        no = no->prox;
    }
    if(no == NULL)
    {
        return 0;
    }
    if(no == *li)
    {
        *li = no->prox;
    }
    else
    {
        ant->prox = no->prox;
    }
    free(no);
    return 1;
}

//o consulta_lista_id foi retirado do powerpoint mostrado em aula. Consulta os dados do funcionário a partir do id dado pelo usuario.
int consulta_lista_id(Lista *li, int idp, FUNCIONARIO *fu)
{
    if(li == NULL)
    {
        return 0;
    }
    ELEM *no = *li;
    while(no != NULL && no->dados.id != idp)
    {
        no = no->prox;
    }
    if(no == NULL)
    {
        return 0;
    }
    else
    {
        *fu = no->dados;
        return 1;
    }
}

//o consulta_lista_pos foi retirado do powerpoint mostrado em aula. Conuslta od dados do funcionário a patir da posição dada pelo usuário.
int consulta_lista_pos(Lista *li, int posicao, FUNCIONARIO *fu)
{
    if(li == NULL || posicao <= 0)
    {
        return 0;
    }
    ELEM *no = *li;
    int i =  1;
    while(no != NULL && i<posicao)
    {
        no = no->prox;
        i++;
    }
    if(no == NULL)
    {
        return 0;
    }
    else
    {
        *fu = no->dados;
        return 1;
    }
}

// Esta função não foi retirada de nenhum powerpoint. De forma geral, ela funciona da mesma forma que outros coletadados de outras atividades.
//Nela cria-se uma struct teste de FUNCIONARIO que ira armazenar os dados com scanf() e fgets() junto de fflus().
//Ao final é devolvida essa struct teste para outra struct no main que irá utiliza-la para algo.
FUNCIONARIO coletadados()
{
    FUNCIONARIO teste;

    int i = 1;

    printf("Digite o Id do funcionário: ");
    scanf("%d", &teste.id);

    fflush(stdin);

    printf("\nDigite o nome do funcionário: ");
    fgets(teste.nome, 29, stdin);

    printf("\nDigite a empresa em que o funcionário trabalha: ");
    fgets(teste.empresa, 29, stdin);

    printf("\nDigite o departamento em que o funcionário trabalha: ");
    fgets(teste.departamento, 29, stdin);

    printf("\nDigite o telefone fixo do funcionário: ");
    scanf("%d", &teste.teleFixo);

    printf("\nDigite o celular do funcionário: ");
    scanf("%d", &teste.cel);

    fflush(stdin);

    printf("\nDigite o e-mail do funcionário: ");
    fgets(teste.email, 29, stdin);


    return teste;

}

//Esta função de impressão funciona da mesma forma que outras atividades apresentadas em sala.
//Nela, é criada uma struct de funcionario fu que servirá como um "recipiente" para receber os dados do funcionario que deseja ser mostrado
//Logo depois, o consulta_lista_id procura o funcionario com id desejado e, caso ele encontre, será imprimido os dados do indivíduo.
void impressao(Lista *li, int procura)
{
    int x;
    FUNCIONARIO fu;
    x = consulta_lista_id(li, procura, &fu);
                if(x)
                {
                    printf("\nConteúdo do Id %d:", procura);
                    printf("\nId: %d", fu.id);
                    printf("\nNome: %s", fu.nome);
                    printf("\nEmpresa: %s", fu.empresa);
                    printf("\nDepartamento: %s", fu.departamento);
                    printf("\nTelefone: %d", fu.teleFixo);
                    printf("\nCelular: %d", fu.cel);
                    printf("\nE-mail: %s\n", fu.email);

                }
                else
                {
                    printf("\nO Id: %d não foi encontrado\n", procura);
                }
}

//Funciona da mesma forma que a função impressão, a diferença é que esse usa a consulta por posição, e não a de id.

void impressao_pos(Lista *li, int procura)
{
    int x;
    FUNCIONARIO fu;
    x = consulta_lista_pos(li, procura, &fu);
                if(x)
                {
                    printf("\nConteudo do Id %d:", procura);
                    printf("\nId: %d", fu.id);
                    printf("\nNome: %s", fu.nome);
                    printf("\nEmpresa: %s", fu.empresa);
                    printf("\nDepartamento: %s", fu.departamento);
                    printf("\nTelefone: %d", fu.teleFixo);
                    printf("\nCelular: %d", fu.cel);
                    printf("\nE-mail: %s\n", fu.email);

                }
                else
                {
                    printf("\nO Id: %d não foi encontrado\n", procura);
                }
}


//Nesta função, é verificado se o inicio da lista é igual a zero ou nada.
//Logo após, cria-se um nó com o inicio da lista que andará por dentro do código até chegar ao fim que é o NULL. Também é criado um i que será utilizado no while.
//Caso o nó seja diferente de nulo e menor que a posição desejada, o nó irá para o próximo, tirará 1 de i, imprimirá os dados da posição,
// e por fim tira-se 1 da posição, indo para o próximo da lista.
 void mostra_lista(Lista *li, int tamanho)
{
if(li == NULL || tamanho <= 0)
{
 return 0;
}
ELEM *no = *li;
int i = 1;
while(no != NULL && i< tamanho)
{

    impressao_pos(li, i);
    i++;
    no = no->prox;
}

}


//Na função busca, cria-se um no com o inicio da lista em conjunto com uma string alvo.
//Enquanto o nó não chegar ao fim que o NULL, é copiado o nome do funcionário para dentro da string alvo com o strcpy
//Além disso, ainda enquanto o nó não chega ao fim, é verificado se a string busca, digitado pelo usuario, é igual a string alvo
// que contem os dados do funcinoario, caso sim, é impresso os dados, se não, não imprime. Ambas são convertidas para maiúscula para não ter problema com o case sensitive.
void busca(Lista *li, char busca[]){
    int x;
    ELEM *no = *li;
    char nome[50];
    while(no != NULL){
        strcpy(nome, no->dados.nome);
        if(strstr(strupr(nome),strupr(busca))){
            printf("\nId: %d", no->dados.id);
            printf("\nNome: %s", no->dados.nome);
            printf("\nEmpresa: %s", no->dados.empresa);
            printf("\nDepartamento: %s", no->dados.departamento);
            printf("\nTelefone: %d", no->dados.teleFixo);
            printf("\nCelular: %d", no->dados.cel);
            printf("\nE-mail: %s\n", no->dados.email);
        }
        no = no->prox;
    }
}

// Esta é função que salva os dados.
//No começo cria-se um nó que andará pelos dados.
// Declara-se o File p e em seguida abre ele, verificando se há algum erro.
// Enqunato o nó não chegar o fim, é escrevido os dados com o fwrite para o gravado e anda para o próximo dado.
// Caso aja algum erro, é mostrado, caso não, o arquico é fechado.
void salvamento(Lista *li)
{
    int gravado;
    ELEM *no = *li;

    FILE *p;
    p = fopen("arquivo.bin", "wb");
    if( p == NULL)
    {
        printf("ERRO na abertura!\n");
        system("pause");
        exit(1);
    }

    while( no != NULL)
    {
        gravado = fwrite(&no->dados, sizeof(DadosCompletos), 1, p);
        no = no->prox;
    }
    if(gravado != 1)
    {
        printf("ERRO na escrita do arquivo\n");
        system("pause");
        exit(1);
    }
    else
    {
    printf("Arquivo gravado com sucesso");
    }
    printf("\n");
    fclose(p);
}


void salvo(Lista *li, char *nomeArquivo)
   {

        FILE *p;
        p = fopen("arquivo.bin", "rb"); // Abre o arquivo em modo de leitura binária.
        if( p == NULL){
                return;
            printf("ERRO na abertura!\n");
            system("pause");
            exit(1);
        }
        DadosCompletos dados; // Nomeia a struct.

         //while(!fread(&dados, sizeof(DadosCompletos), 1, p) == feof(p)) // Lê os dados.
         //aqui você estava lendo de forma errada, como pode ver, é mais simples
         while(fread(&dados, sizeof(DadosCompletos), 1, p)) // Lê os dados.
        {
            insere_lista_ordenada(li, dados.contato); // Insere os dados do arquivo no programa.

        }


    }
