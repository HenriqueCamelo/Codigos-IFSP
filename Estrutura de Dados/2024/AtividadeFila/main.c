#include <stdio.h>
#include <stdlib.h>
#include "filaD.h"

int main()
{
    int x;
    ALUNO al, al1, al2, al3;

    al1.matricula = 100;
    al1.n1 = 8.2;
    al1.n2 = 9.1;
    al1.n3 = 7.4;

    al2.matricula = 110;
    al2.n1 = 7.2;
    al2.n2 = 7.1;
    al2.n3 = 7.4;

    al3.matricula = 120;
    al3.n1 = 6.2;
    al3.n2 = 6.1;
    al3.n3 = 6.4;

    Fila *fi;

    fi = cria_lista();

    x = fila_cheia(fi);
    if(x)
    {
        printf("\nA fila esta cheia!");
    }
    else
    {
        printf("\nA fila nao esta cheia.");
    }

    x = fila_vazia(fi);
    if(x)
    {
        printf("\nA fila esta vazia!");
    }
    else
    {
        printf("\nA fila não esta vazia.");
    }

    x = insere_fila(fi, al1);
    if(x)
    {
        printf("\nElemento inserido com sucesso! ");
    }
    else
    {
        printf("\nERRO, elemento não inserido.");
    }

    x = insere_fila(fi, al2);
    if(x)
    {
        printf("\nElemento inserido com sucesso! ");
    }
    else
    {
        printf("\nERRO, elemento não inserido.");
    }

    x = insere_fila(fi, al3);
    if(x)
    {
        printf("\nElemento inserido com sucesso! ");
    }
    else
    {
        printf("\nERRO, elemento não inserido.");
    }

    x = tamanho_lista(fi);
    printf("\nO tamanho da lista e: %d", x);

    x = consulta_fila(fi, &al);
    if(x)
    {
        printf("\nConsulta realizada com sucessso:");
        printf("\nMatricula: %d", al.matricula);
        printf("\nNota 1: %.2f", al.n1);
        printf("\nNota 2: %.2f", al.n2);
        printf("\nNota 3: %.2f", al.n3);
    }
    else
    {
        printf("\nERRO, consulta não realizada");
    }

    x = remove_fila(fi);
    if(x)
    {
        printf("\nElemento removido com sucesso!");
    }
    else
    {
        printf("\nERRO, elemento não removido");
    }
    destroi_fila(fi);
    return 0;
}
