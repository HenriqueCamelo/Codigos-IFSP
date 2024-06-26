#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hashTable.h"

struct hash{
    int qtd;
    int TABLE_SIZE;
    struct aluno **itens;
};

Hash *criaHash(int TABLE_SIZE)
{
    Hash *ha = (Hash*) malloc(sizeof(Hash));
    if(ha != NULL)
    {
        int i;
        ha->TABLE_SIZE = TABLE_SIZE;
        ha->itens = (struct aluno**) malloc(TABLE_SIZE * sizeof(struct aluno*));

    if(ha->itens == NULL)
    {
        free(ha);
        return NULL;
    }
    ha->qtd = 0;
    for(i = 0; i < ha->TABLE_SIZE; i++)
    {
        ha->itens[i] = NULL;
    }
    }

    return ha;

}

void liberaHash(Hash *ha)
{
    if(ha != NULL)
    {
        int i;
        for(i = 0; i < ha->TABLE_SIZE; i++)
        {
            if(ha->itens[i] != NULL)
            {
                free(ha->itens[i]);
            }
        }
        free(ha->itens);
        free(ha);
    }
}

//- Chave: método da divisão
int chaveDivisao(int chave, int TABLE_SIZE)
{
    return(chave & 0x7FFFFFFF) % TABLE_SIZE;
}

int chaveMultiplicaao(int chave, int TABLE_SIZE)
{
    float A = 0.6180339887;
    float val = chave * A;
    val = val - (int) val;
    return (int) (TABLE_SIZE * val);
}

int chaveDobra(int chave, int TABLE_SIZE)
{
    int num_bits = 10;
    int parte1 = chave >> num_bits;
    int parte2 = chave & (TABLE_SIZE - 1);
    return (parte1 ^ parte2);
}

int valorString(char *str)
{
    int i, valor = 7;
    int tam = strlen(str);
    for(i = 0; i < tam; i++)
    {
        valor = 31 * valor + (int) str[i];
    }
    return valor;
}

int insereHash_semColisao(Hash * ha, struct aluno al)
{
    if(ha == NULL || ha->qtd == ha->TABLE_SIZE)
    {
        return 0;
    }
    int chave = al.matricula;

    int pos = chaveDivisao(chave, ha->TABLE_SIZE);
    //int chave = valorString(al.nome);
    //int pos chaveMultiplicacao(chave, ha->TABLE_SIZE);
    //int pos = chaveDobra(chave, ha->TABLE_SIZE);
    struct aluno *novo;
    novo = (struct aluno*) malloc(sizeof(struct aluno));
    if(novo == NULL)
    {
        return 0;
    }
    *novo = al;
    ha->itens[pos] = novo;//armazena o endereço do novo elemento
    ha->qtd++;//atualiza quantidade de elementos
    return 1;
}

int buscaHash_semColisao(Hash *ha, int mat, struct aluno *al)
{
    if(ha == NULL)
    {
        return 0;
    }
    int pos = chaveDivisao(mat, ha->TABLE_SIZE);
    //int pos = chaveMultiplicao(chave, ha->TABLE_SIZE);
    //int pos = chaveDobra(chave, ha->TABLE_SIZE);
    if(ha->itens[pos] == NULL)
    {
        return 0;
    }
    *al = *(ha ->itens[pos]);
    return 1;
}

int sondagemLinear(int pos, int i, int TABELA_SIZE)
{
    return((pos + i) & 0x7FFFFFFF) % TABELA_SIZE;
}

int sondagemQuadratica(int pos, int i, int TABLE_SIZE)
{
    pos = pos + 2 * i + 5 * i * i;
    return (pos & 0x7FFFFFFF) & TABLE_SIZE;
}

int duploHash(int H1, int chave, int i, int TABLE_SIZE)
{
    int H2 = chaveDivisao(chave, TABLE_SIZE - 1) + 1;
    return((H1 + i * H2) & 0x7FFFFFFF) % TABLE_SIZE;
}

int insereHash_enderecoAberto(Hash *ha, struct aluno al)
{
    if(ha == NULL || ha->qtd == ha->TABLE_SIZE)
    {
        return 0;
    }
    int chave = al.matricula;
    //int chave = valorStrig(al.nome);
    int i, pos, newPos;
    pos = chaveDivisao(chave, ha->TABLE_SIZE);
    //pos = chaveMultiplicao(chave, ha->TABLE_SIZE);
    //pos = chaveDobra(chave, ha->TABLE_SIZE);
    for(i = 0; i < ha->TABLE_SIZE; i++)
    {
        newPos = sondagemLinear(pos, i, ha->TABLE_SIZE);
        //newPos = sondagemQuadratica(pos, i, ha->TABLE_SIZE);
        //newPos = duploHash(pos, chave, i, ha->TABLE_SIZE);
        if(ha->itens[newPos] == NULL)
        {
            struct aluno *novo;
            novo = (struct aluno*) malloc(sizeof(struct aluno));
            if(novo == NULL)
            {
                return 0;
            }
            *novo = al;
            ha->itens[newPos] = novo;
            ha->qtd++;
            return 1;
        }
    }
    return 0;
}

int buscaHash_enderecoAberto(Hash * ha, int mat, struct aluno *al)
{
    if(ha == NULL)
    {
        return 0;
    }
    int i, pos, newPos;
    pos = chaveDivisao(mat, ha->TABLE_SIZE);
    //pos = chaveMultiplicaao(mat, ha->TABLE_SIZE);
    //pos = chaveDobra(mat, ha->TABLE_SIZE);
    for(i = 0; i < ha->TABLE_SIZE; i++)
    {
        newPos = sondagemLinear(pos, i, ha->TABLE_SIZE);
        //newPos = sondagemQuadratica(pos, i, ha->TABLE_SIZE);
        //newPos = duploHash(pos, i, ha->TABLE_SIZE);
        if(ha->itens[newPos] == NULL)
        {
            return 0;
        }
        if(ha->itens[newPos]->matricula == mat)
        {
            *al = *(ha->itens[newPos]);
            return 1;
        }
    }
    return 0;
}

ALUNO coletadados()
{
    ALUNO teste;

    int i = 1;

    printf("\nDigite numero de matricula do aluno: ");
    scanf("%d", &teste.matricula);

    fflush(stdin);

    printf("\nDigite o nome do aluno: ");
    fgets(teste.nome, 29, stdin);

    printf("\nDigite a nota da 1° prova: ");
    scanf("%f", &teste.n1);

    printf("\nDigite a nota da 2° prova: ");
    scanf("%f", &teste.n2);

    printf("\nDigite a nota da 3° prova: ");
    scanf("%f", &teste.n3);

    return teste;

}

impressao_semcolisao(Hash *ha, int matricula)
{
    int x;
    ALUNO base;
    x = buscaHash_semColisao(ha, matricula, &base);
    if(x)
    {
        printf("\nId: %d", base.matricula);
        printf("\nNome: %s", base.nome);
        printf("\nNota 1: %.2f", base.n1);
        printf("\nNota 2: %.2f", base.n2);
        printf("\nNota 3: %.2f", base.n3);

    }
    else
    {
        printf("Elemento não impresso");
    }
}

impressao_comtratamento(Hash *ha, int matricula)
{
    int x;
    ALUNO base;
    x = buscaHash_enderecoAberto(ha, matricula, &base);
    if(x)
    {
        printf("\nId: %d", base.matricula);
        printf("\nNome: %s", base.nome);
        printf("\nNota 1: %.2f", base.n1);
        printf("\nNota 2: %.2f", base.n2);
        printf("\nNota 3: %.2f", base.n3);

    }
    else
    {
        printf("Elemento não impresso");
    }
}
