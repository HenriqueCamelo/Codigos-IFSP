#include <string.h>

struct aluno{
    int matricula;
    char nome[30];
    float n1, n2, n3;
};

typedef struct aluno ALUNO;

ALUNO coletadados();

typedef struct hash Hash;

impressao_semcolisao(Hash *ha, int matricula);
impressao_comtratamento(Hash *ha, int matricula);

Hash *criaHash(int tamanho);
void liberaHash(Hash *ha);
int valorString(char *str);
int insereHash_semColisao(Hash *ha, struct aluno al);
int buscaHash_semColisao(Hash *ha, int mat, struct aluno *al);
int insereHash_enderecoAberto(Hash *ha, struct aluno al);
int buscaHash_enderecoAberto(Hash *ha, int mat, struct aluno *al);
