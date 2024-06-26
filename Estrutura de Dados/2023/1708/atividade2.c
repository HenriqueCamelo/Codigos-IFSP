#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct funcionario{

    int ID;
    char nome[30];
    int idade;
    float salario;

};

struct funcionario dadosColetados();
void mostrar(struct funcionario vetor_p[]);


int main()
{
    int x, n = 2;
    struct funcionario f[n];

    f[n] = dadosColetados();


    /*for( x = 0; x < n; x++)
    {
        printf("Digite o ID do funcionario: ");
        scanf("%d", &f[x].ID);

        printf("Digite o nome do funcionario: ");
        getchar();
        fgets(f[x].nome, 29, stdin);

        printf("Digite a idade do funcionario: ");
        scanf("%d", &f[x].idade);

        printf("Digite o salario do funcionario: ");
        getchar();
        scanf("%f", &f[x].salario);

        printf("\n\n\n");
        //system("pause");
        //system("cls");

    }*/
        mostrar(f[n]);



    return 0;
}

struct funcionario dadosColetados()
{
    int x;
    struct funcionario testes;
    for( x = 0; x < 2; x++)
    {
        printf("Digite o ID do funcionario: ");
        scanf("%d", &testes.ID);

        printf("Digite o nome do funcionario: ");
        getchar();
        fgets(testes.nome, 29, stdin);

        printf("Digite a idade do funcionario: ");
        scanf("%d", &testes.idade);

        printf("Digite o salario do funcionario: ");
        getchar();
        scanf("%f", &testes.salario);

        printf("\n\n\n");
        //system("pause");
        //system("cls");

    }


};




void mostrar(struct funcionario vetor_p[])
{
    int a;
    for( a = 0; a < 2; a++)
       {
            printf("\nID: %d \n",vetor_p.ID);
            printf("nome: %s \n",vetor_p.nome);
            printf("idade: %d \n",vetor_p.idade);
            printf("salario: %f \n",vetor_p.salario);
        }
}

















