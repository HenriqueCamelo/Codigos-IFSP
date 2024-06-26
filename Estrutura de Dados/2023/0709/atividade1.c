#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    int *n;
    n = (int*) calloc(5, sizeof(int));

    if( n == NULL )
    {
        printf("ERRO: sem memória! \n");
        exit(1); //encerra a execção em caso de erro
    }

    int x;
    printf("Digite um número: ");
    scanf("%d", &x);


    int i = 0;
    for( i = 0; i <= x; i++)
    {

        n[i]= (i - 1) + (i + 2);
        printf(" %d -- %d \n", i , n[i]);

    }

    return 0;
}
