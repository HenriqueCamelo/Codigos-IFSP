#include <stdio.h>

int funcao_in(int x);
int funcao_rec(int t);

int main()
{
    int i, r;

    printf("Digite um número para a função interativa: ");
    scanf("%d", &i);

    funcao_in(i);

    printf("\nDigite um número para a função recursiva: ");
    scanf("%d", &r);

    funcao_rec(r);

    return 0;
}

int funcao_in(int x)
{
    int c, d;
    for(c = x; c >= 0 ; c-- )
    {
        printf("%d \n", c);
    }
}

int funcao_rec(int t)
{
    if ( t == -1)
    {
        return 0;
    }
    else
    {
        printf("%d \n", t);
        return funcao_rec( t - 1);
    }
}
