#include <stdio.h>
#include <stdlib.h>
#include "arvoreAVL.h"

int main()
{
    int x;
    arvAVL *raiz;
    raiz = cria_arvAVL();

    confirmaInsercao(insere_avrAVL(raiz, 160));
    confirmaInsercao(insere_avrAVL(raiz, 150));
    confirmaInsercao(insere_avrAVL(raiz, 100));
    confirmaInsercao(insere_avrAVL(raiz, 110));
    confirmaInsercao(insere_avrAVL(raiz, 130));
    confirmaInsercao(insere_avrAVL(raiz, 140));
    confirmaInsercao(insere_avrAVL(raiz, 120));
    confirmaInsercao(insere_avrAVL(raiz, 170));
    confirmaInsercao(insere_avrAVL(raiz, 180));
    confirmaInsercao(insere_avrAVL(raiz, 190));
    confirmaInsercao(insere_avrAVL(raiz, 200));
    confirmaInsercao(insere_avrAVL(raiz, 210));

    if(vazia_arvAVL(raiz))
    {
        printf("A arvore esta vazia.");
    }
    else
    {
        printf("A arvore possui elemenentos.");
    }
    printf("\n");

    x = altura_arvAVL(raiz);
    printf("Altura da arvore: %d\n", x);

    x = totalNo_arvAVL(raiz);
    printf("Total de nos na arvore: %d\n", x);

    printf("\nVisitando em pre-ordem\n");
    preOrdem_arvAVL(raiz);

    printf("\nVisitando em-ordem\n");
    emOrdem_arvAVL(raiz);

    printf("\nVisitando em pos-ordem\n");
    posOrdem_arvAVL(raiz);

    printf("\nBusca na Arvore Binaria: \n");
        if(consulta_arvAVL(raiz, 140))
        {
            printf("\nConsulta realizada com sucesso!\n");
        }
        else
        {
            printf("\nElemento nao encontrado...\n");
        }

    x = remove_arvAVL(raiz, 200);
    if(x)
    {
        printf("Elemento removido com sucesso!");
    }
    else{
        printf("ERRO, não é possível");
    }


    liberar_arvAVL(raiz);
    return 0;
}


