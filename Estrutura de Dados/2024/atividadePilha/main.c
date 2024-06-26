#include <stdio.h>
#include <stdlib.h>
#include "pilhaD.h"

int main()
{
    int x;
    ALUNO al, al1,al2, al3;
    al1.matricula = 100;
    al1.n1 = 8.3;
    al1.n2 = 8.2;
    al1.n3 = 8.1;

    al2.matricula = 110;
    al2.n1 = 9.3;
    al2.n2 = 5.2;
    al2.n3 = 7.1;

    al3.matricula = 120;
    al3.n1 = 7.3;
    al3.n2 = 7.2;
    al3.n3 = 7.1;

    Pilha *pi;

    pi = cria_pilha();

    x = pilha_cheia(pi);
    if(x)
    {
        printf("\nA pilha esta cheia!");
    }
    else
    {
        printf("\nA pilha não esta cheia!");
    }

    x = pilha_vazia(pi);
    if(x)
    {
        printf("\nA pilha esta vazia!");
    }
    else
    {
        printf("\nA pilha não esta vazia!");
    }

    x = insere_pilha(pi, al1);
    if(x)
    {
        printf("\nAluno inserido com sucesso!");
    }
    else
    {
        printf("\nAluno não inserido");
    }

    x = insere_pilha(pi, al2);
    if(x)
    {
        printf("\nAluno inserido com sucesso!");
    }
    else
    {
        printf("\nAluno não inserido");
    }

    x = insere_pilha(pi, al3);
    if(x)
    {
        printf("\nAluno inserido com sucesso!");
    }
    else
    {
        printf("\nAluno não inserido");
    }

    x = tamanho_pilha(pi);
    printf("\nO tamanho da pilha é: %d", x);

    x = consulta_pilha(pi, &al);
    if(x)
    {
        printf("\nConsulta realizada com sucesso: ");
        printf("\nMatricula: %d", al.matricula);
        printf("\nNota 1: %.2f", al.n1);
        printf("\nNota 2: %.2f", al.n2);
        printf("\nNota 3: %.2f", al.n3);
    }
    else
    {
        printf("\nERRO, consulta nao realizada");
    }

    x = remove_pilha(pi);
    if(x)
    {
        printf("\nElemento removido com sucesso!");
    }
    else
    {
        printf("\Elemento não removido");
    }

    destroi_pilha(pi);
    return 0;
}
