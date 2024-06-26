#include <stdio.h>
#include <stdlib.h>
#include "arvoreBinaria.h"

int main()
{
    int x;
    ArvBin *raiz;

    raiz = cria_arvBin();
    //libera_arvBin(raiz);





    x = insere_arvBin(raiz, 150);
    if(x)
    {
        printf("Elemento inserido na arvore com sucesso. \n");
    }
    else
    {
         printf("Erro: elemento não inserido");
    }
    x = insere_arvBin(raiz, 110);
    if(x)
    {
        printf("Elemento inserido na arvore com sucesso. \n");
    }
    else
    {
         printf("Erro: elemento não inserido");
    }
    x = insere_arvBin(raiz, 100);

    x = insere_arvBin(raiz, 130);

    x = insere_arvBin(raiz, 120);

    x = insere_arvBin(raiz, 140);

    x = insere_arvBin(raiz, 160);

        if(vazia_arvBin(raiz))
    {
        printf("A arvore esta vazia.");
    }
    else
    {
        printf("A arvore possui elementos.");
    }
    printf("\n");

    x = altura_arvBin(raiz);
    printf("Altura da arvore: %d\n", x);

    x = totalNo_arvBin(raiz);
    printf("Total de nos na arvore: %d\n", x);

    printf("Elementos da arvore em pré-Ordem: \n");
    preOrdem_arvBin(raiz);

    printf("Elementos da arvore em em-Ordem: \n");
    emOrdem_arvBin(raiz);

    printf("Elementos da arvore em pos-Ordem: \n");
    posOrdem_arvBin(raiz);



    x = remove_arvBin(raiz, 100);

    printf("Elementos da arvore após remoção: \n");
    emOrdem_arvBin(raiz);

        printf("\nBusca na arvore binaria: \n");
    if(consulta_arvBin(raiz, 140))
    {
        printf("Consulta realizada com sucesso !\n");
    }
    else
    {
        printf("Elemento não encontrado...\n");
    }
}
