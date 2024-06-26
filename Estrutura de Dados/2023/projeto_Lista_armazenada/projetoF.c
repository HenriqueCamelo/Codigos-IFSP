#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "projetoF.h"


struct elemento
{
    FUNCIONARIO dados;
    struct elemento *prox;
};

typedef struct elemento ELEMENTO;

LISTA *crialista()
{
    LISTA *lista;
    lista = (LISTA*) malloc(sizeof(LISTA));
    if(lista != NULL)
    {
        *lista = NULL;
    }
    return lista;
}

int listaCheia(LISTA *lista)
{
    return 0;
}

int listaVazia(LISTA *lista)
{
    if(lista == NULL)
    {
        return 1;
    }
    if(*lista == NULL)
    {
        return 1;
    }
    return 0;
}

void apagaLista(LISTA *lista){
if(lista != NULL)
{
    ELEMENTO *no;
    while((*lista) != NULL)
    {
        no = *lista;
        *lista = (*lista)->prox;
        free(no);
    }
    free(lista);
}
}

int tamLista(LISTA *lista)
{
    if(lista == NULL)
    {
        return 0;
    }
    int acum = 0;
    ELEMENTO *no = *lista;
    while(no != NULL)
    {
        acum++;
        no = no->prox;
    }
    return acum;
}

int insere_lista_ordenada(LISTA *lista, FUNCIONARIO fu)
{

    if(lista == NULL)
    {
        return 0;
    }
    ELEMENTO *no = (ELEMENTO*) malloc(sizeof(ELEMENTO));
    if(no == NULL)
    {
        return 0;
    }

    no->dados = fu;

    if(listaVazia(lista))
    {
        no->prox = (*lista);
        *lista = no;
        return 1;
    }
    else
    {
        ELEMENTO *ant, *atual = *lista;
        while(atual != NULL && atual->dados.id < fu.id)
        {

            ant = atual;
            atual = atual->prox;
        }
        if(atual == *lista)
        {
            no->prox = (*lista);
            *lista = no;
            return 1;
        }
        else
        no->prox = ant->prox;
        ant->prox = no;
        return 1;
    }
    return 1;
}

int remove_lista(LISTA *lista, int idp)
{
    FUNCIONARIO fu;
    impressao(lista, idp);

    char confirma;
    printf("Tem certeza disso? ");
    scanf(" %c", &confirma);

    switch(confirma){
        case 's':
            if(lista == NULL)
            {
                return 0;
            }
            ELEMENTO *ant, *no = *lista;
            while(no != NULL && no->dados.id != idp)
            {
                ant = no;
                no = no->prox;
            }
            if(no == NULL)
            {
                return 0;
            }
            if(no == *lista)
            {
                *lista = no->prox;
            }
            else
            {
                ant->prox = no->prox;
            }
            free(no);
            return 1;
            break;

        case 'n':
            return 0;
            break;

        default:
            return 0;
            break;
    }
}

int consulta_lista_id(LISTA *lista, int idp, FUNCIONARIO *fu)
{
    if(lista == NULL)
    {
        return 0;
    }
    ELEMENTO *no = *lista;
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

int consulta_lista_pos(LISTA *lista, int posicao, FUNCIONARIO *fu)
{
    if(lista == NULL || posicao <= 0)
    {
        return 0;
    }
    ELEMENTO *no = *lista;
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


//Nessa função cria-se uma struct teste de FUNCIONARIO que ira armazenar os dados com scanf() e fgets() junto de fflus().
//Ao final � devolvida essa struct teste para outra struct no main que ir� utiliza-la para algo.
FUNCIONARIO coletadados()
{
    FUNCIONARIO teste;

    int i = 1;

    printf("Digite o Id do funcion�rio: ");
    scanf("%d", &teste.id);

    fflush(stdin);

    printf("\nDigite o nome do funcion�rio: ");
    fgets(teste.nome, 29, stdin);

    printf("\nDigite a empresa em que o funcion�rio trabalha: ");
    fgets(teste.empresa, 29, stdin);

    printf("\nDigite o departamento em que o funcion�rio trabalha: ");
    fgets(teste.departamento, 29, stdin);

    printf("\nDigite o telefone fixo do funcion�rio: ");
    scanf("%d", &teste.teleFixo);

    printf("\nDigite o celular do funcion�rio: ");
    scanf("%d", &teste.cel);

    fflush(stdin);

    printf("\nDigite o e-mail do funcion�rio: ");
    fgets(teste.email, 29, stdin);


    return teste;

}


//Nela, é criada uma struct de funcionario fu que servirá como um "recipiente" para receber os dados do funcionario que deseja ser mostrado
//Logo depois, o consulta_lista_id procura o funcionario com id desejado e, caso ele encontre, ser� imprimido os dados do indiv�duo.
int impressao(LISTA *lista, int procura)
{
    int x;
    FUNCIONARIO fu;
    x = consulta_lista_id(lista, procura, &fu);
                if(x)
                {
                    printf("------------------------------------------------\n");
                    printf("\n\tConteudo do Id %d: \n", procura);
                    printf("\nId: %d", fu.id);
                    printf("\nNome: %s", fu.nome);
                    printf("Empresa: %s", fu.empresa);
                    printf("Departamento: %s", fu.departamento);
                    printf("Telefone: %d", fu.teleFixo);
                    printf("\nCelular: %d", fu.cel);
                    printf("\nE-mail: %s\n", fu.email);
                    printf("------------------------------------------------\n");

                }
                else
                {
                    printf("\nO Id: %d n�o foi encontrado\n", procura);
                    return 0;
                }
}

//Funciona da mesma forma que a fun��o impress�o, a diferença é que esse usa a consulta por posição.

void impressao_pos(LISTA *lista, int procura)
{
    int x;
    FUNCIONARIO fu;
    x = consulta_lista_pos(lista, procura, &fu);
                if(x)
                {
                    printf("------------------------------------------------\n");
                    printf("\n\tConteudo do Id na posicao %d: \n", procura);
                    printf("\nId: %d", fu.id);
                    printf("\nNome: %s", fu.nome);
                    printf("Empresa: %s", fu.empresa);
                    printf("Departamento: %s", fu.departamento);
                    printf("Telefone: %d", fu.teleFixo);
                    printf("\nCelular: %d", fu.cel);
                    printf("\nE-mail: %s\n", fu.email);


                }
                else
                {
                    printf("\nO Id: %d n�o foi encontrado\n", procura);
                }
}


//Nesta função, é verificado se o inicio da lista é igual a zero ou nada.
//Logo apás, cria-se um nó com o inicio da lista que andará por dentro do código até chegar ao fim que é o NULL. Também é criado um i que será utilizado no while.
//Caso o n� seja diferente de nulo e menor que a posição desejada, o nó irá para o próximo, tirará 1 de i, imprimirá os dados da posição,
// e por fim tira-se 1 da posição, indo para o próximo da lista.
void mostra_lista(LISTA *lista, int posicao)
{
    if(lista == NULL || posicao <= 0)
    {
        return 0;
    }

    ELEMENTO *no = *lista;

    while(no != NULL)
    {
        impressao_pos(lista, posicao);
        posicao--;
        no = no->prox;
    }
}


//Na função busca, cria-se um no com o inicio da lista em conjunto com uma string alvo.
//Enquanto o nó não chegar ao fim que o NULL, é copiado o nome do funcionário para dentro da string alvo com o strcpy
//Além disso, ainda enquanto o nó não chega ao fim, é verificado se a string busca, digitado pelo usuario, é igual a string alvo
// que contem os dados do funcinoario, caso sim, são impresso os dados, se não, não imprime. Ambas são convertidas para maiúscula para não ter problema com o case sensitive.
void busca(LISTA *lista, char busca[]){
    int x;
    ELEMENTO *no = *lista;
    char nome[50];
    while(no != NULL)
    {
        strcpy(nome, no->dados.nome);
        if(strstr(strupr(nome),strupr(busca)))
        {
            printf("------------------------------------------------\n");
            printf("\nId: %d", no->dados.id);
            printf("\nNome: %s", no->dados.nome);
            printf("Empresa: %s", no->dados.empresa);
            printf("Departamento: %s", no->dados.departamento);
            printf("Telefone: %d", no->dados.teleFixo);
            printf("\nCelular: %d", no->dados.cel);
            printf("\nE-mail: %s\n", no->dados.email);
            printf("------------------------------------------------\n");
        }
        no = no->prox;
    }
}

// Esta é a funão que salva os dados.
//No começo cria-se um nó que andará pelos dados.
// Declara-se o File p e em seguida abre ele, verificando se há algum erro.
// Enquanto o nó náo chegar o fim, os dados são escritos com o fwrite para o gravador e anda para o proximo dado.
void salvandoDados(LISTA *lista)
{
    int gravado;
    ELEMENTO *no = *lista;

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
        gravado = fwrite(&no->dados, sizeof(DadosBinarios), 1, p);
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

//Esta é a função que lê o arquivo em binário.
//Nela abre-se o arquivo em modo de leitura binária, Nomeia a struct dados de dados binarios para receber as informações presentes nos arquivos.
// Logo em seguida o fread() lê os dados e enquanto isso
//o insere_lista_ordenada() passa esses dados a struct dados de DadosBinarios n

void lerArquivoDeMemoria(LISTA *lista, char *nomeArquivo)
   {
        FILE *p;
        p = fopen("arquivo.bin", "rb");
        if( p == NULL){
                return;
            printf("ERRO na abertura!\n");
            system("pause");
            exit(1);
        }
        DadosBinarios dados;

        while(fread(&dados, sizeof(DadosBinarios), 1, p))
        {
            insere_lista_ordenada(lista, dados.contato);

        }
    }
