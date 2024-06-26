#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void soma(int *p1, int *p2, int *p3);

int main()
{
    int num1, num2, num3, *pont1, *pont2, *pont3;

    printf("\nEscreva o primeiro numero: ");
    scanf("%d", &num1);

    printf("\nEscreva o segundo numero: ");
    scanf("%d", &num2);

    printf("\nEscreva o terceiro numero: ");
    scanf("%d", &num3);

    pont1 = &num1;
    pont2 = &num2;
    pont3 = &num3;


    soma(pont1, pont2, pont3);


    return 0;
}

    void soma(int *p1, int *p2, int *p3)
    {
        *p1 = *p1 + 100;
        *p2 = *p2 + 100;
        *p3 = *p3 + 100;

        printf("\nO novo primeiro valor é: %d", *p1);
        printf("\nO novo segundo valor é: %d", *p2);
        printf("\nO novo terceiro valor é: %d", *p3);
    }





