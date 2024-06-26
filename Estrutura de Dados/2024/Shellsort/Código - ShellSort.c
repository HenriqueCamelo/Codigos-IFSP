#include <stdlib.h>
#include <stdio.h>

struct item {
    int chave;
};

void shellsort(struct item *vetor, int tamanho);

int main() {

    struct item vetor[] = {18, 5, 23, 0, 10, 14, 21, 6, 3, 20, 19, 4, 15, 12, 1, 17, 11, 2, 22, 25, 16, 13, 8, 9, 7};
    int tamanho = sizeof(vetor) / sizeof(vetor[0]);

    printf("Vetor original:\n");
    for(int i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i].chave);
    }
    printf("\n");

    shellsort(vetor, tamanho);

    printf("Vetor ordenado:\n");
    for(int i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i].chave);
    }
    printf("\n");

    return 0;
}

void shellsort(struct item *vetor, int tamanho) {
    int i, j, intervalo;
    struct item auxiliar;

        /* calcula o intervalo inicial. */
        for(intervalo = 1; intervalo < tamanho; intervalo = 3*intervalo+1);

        while(intervalo > 0) {

        /* atualiza o valor do intervalo. */
            intervalo = (intervalo-1)/3;

        for(i = intervalo; i < tamanho; i++) {
            auxiliar = vetor[i];
            j = i;

            /* efetua comparações entre elementos com distância do intervalo: */
                while(j >= intervalo && vetor[j - intervalo].chave > auxiliar.chave){
                vetor[j] = vetor[j - intervalo];
                j -=  intervalo;
                }

        vetor[j] = auxiliar;
            }
        }
    }

