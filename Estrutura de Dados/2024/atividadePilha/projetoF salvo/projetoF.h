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

typedef struct elemento* Lista;

Lista *crialista();

void apagaLista(Lista *li);

int tamLista(Lista *li);

int insere_lista_ordenada(Lista *li, FUNCIONARIO fu);

int listaCheia(Lista *li);

int listaVazia(Lista *li);

int remove_lista(Lista *li, int id);

int consulta_lista_id(Lista *li, int idp, FUNCIONARIO *fu);

int consulta_lista_pos(Lista *li, int posicao, FUNCIONARIO *fu);

FUNCIONARIO coletadados();

void impressao(Lista *li, int procura);

void mostra_lista(Lista *li, int tamanho);

void impressao_pos(Lista *li, int procura);

void busca(Lista *li, char busca[]);

//void salvo(Lista *li);

void salvo(Lista *li, char *nomeArquivo);

typedef struct dadosCompletos {
    FUNCIONARIO contato;
}DadosCompletos;

void salvamento(Lista *li);
