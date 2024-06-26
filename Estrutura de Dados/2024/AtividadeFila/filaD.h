typedef struct aluno
{
    int matricula;
    float n1, n2, n3;
}ALUNO;

typedef struct fila Fila;

Fila *cria_lista();

void destroi_fila(Fila *fi);

int tamanho_lista(Fila *fi);

int fila_cheia(Fila *fi);

int fila_vazia(Fila *fi);

int insere_fila(Fila *fi, ALUNO al);

int remove_fila(Fila *fi);

int consulta_fila(Fila *fi, ALUNO *al);
