#include <string.h>


typedef struct funcionario
{
    int id;
    char nome[30];
    char empresa[30];
    char departamento[30];
    int teleFixo;
    int cel;
    char email[30];
}FUNCIONARIO;

typedef struct elemento* LISTA;

LISTA *crialista();

void apagaLista(LISTA *lista);

int tamLista(LISTA *lista);

int insere_lista_ordenada(LISTA *lista, FUNCIONARIO fu);

int listaCheia(LISTA *lista);

int listaVazia(LISTA *lista);

int remove_lista(LISTA *lista, int id);

int consulta_lista_id(LISTA *lista, int idp, FUNCIONARIO *fu);

int consulta_lista_pos(LISTA *lista, int posicao, FUNCIONARIO *fu);

FUNCIONARIO coletadados();

int impressao(LISTA *lista, int procura);

void mostra_lista(LISTA *lista, int posicao);

void impressao_pos(LISTA *lista, int procura);

void busca(LISTA *lista, char busca[]);



void lerArquivoDeMemoria(LISTA *lista, char *nomeArquivo);

typedef struct dadosCompletos {
    FUNCIONARIO contato;
}DadosBinarios;

void salvandoDados(LISTA *lista);
