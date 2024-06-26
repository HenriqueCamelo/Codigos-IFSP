#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>



int main()
{
    setlocale(LC_ALL," ");

    FILE *f;
    f = fopen("arquivo.txt", "w");
    if(f ==NULL)
    {
        printf("Erro na abertura!\n");
        system("pause");
        exit(1);
    }

    char texto[60];
    printf("Digite algo: ");
    gets(texto);

    int i;
    for(i = 0; i < strlen(texto); i++)
    {
        fputc(texto[i], f);
    }
    fclose(f);
    FILE *f1, *f2;
    f1 = fopen("arquivo.txt", "r");
    f2 = fopen("maiuscula.txt", "w");
    if(f1 == NULL || f2 == NULL)
    {
        printf("Erro na Abertura! \n");
        system("pause");
        exit(1);
    }

    char c = fgetc(f1);
    while(c != EOF)
    {
        fputc(toupper(c), f2);
        c = fgetc(f1);
    }
    fclose(f1);
    fclose(f2);
    f2 = fopen("maiscula.txt", "r");
    char b = fgetc(f2);
    while (b !=EOF)
    {
        printf("%c", b);
        b = fgetc(f2);
    }

    printf("\n\n\n");
    fclose(f2);
    system("pause");

    return 0;
}
