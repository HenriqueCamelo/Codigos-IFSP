#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hashTable.h"



int main()
{
    int mat, x;





    Hash *li;

    ALUNO alunoNew;

    li = criaHash(7);

    char resposta = 's';

    int escolha, escolha1, escolha2, escolha3;

    while(resposta == 's')
    {
        printf("Deseja :");
        printf("\n[0] - Inserções sem tratamento de colisões");
        printf("\n[1] - Inserções com tratamento de colisões\n");
        scanf("%d", &escolha);
        system("pause");
        system("cls");


            switch(escolha)
            {
                case 0:

                    printf("Deseja:");
                    printf("\n[0] - Inserir aluno");
                    printf("\n[1] - Procurar aluno via id\n");
                    scanf("%d", &escolha2);
                    system("pause");
                    system("cls");

                        switch(escolha2)
                        {
                            case 0:
                            alunoNew = coletadados();

                            x = insereHash_semColisao(li, alunoNew);
                            if(x)
                            {
                                printf("Elemento inserido com sucesso !");
                            }
                            else
                            {
                                printf("Elemento não inserido");
                            }
                            system("pause");
                            system("cls");
                            break;

                            case 1:
                            printf("\nInsira a matrícula que deseja procurar: ");
                            scanf("%d", &mat);

                            x = buscaHash_semColisao(li, mat, &alunoNew);
                            if(x)
                            {
                                printf("Elemento encontrado !");
                            }
                            else
                            {
                                printf("Elemento não encontrado");
                            }

                            impressao_semcolisao(li,mat);
                            system("pause");
                            system("cls");
                            break;

                        }

                    printf("\nDeseja continuar ? (s = sim/ n = não): ");
                    scanf(" %c", &resposta);
                    system("pause");
                    system("cls");
                    break;

                            case 1:

                    printf("Deseja:");
                    printf("\n[0] - Inserir aluno");
                    printf("\n[1] - Procurar aluno via id\n");
                    scanf("%d", &escolha3);
                    system("pause");
                    system("cls");

                           switch(escolha3)
                        {
                            case 0:
                            alunoNew = coletadados();

                            x = insereHash_enderecoAberto(li, alunoNew);
                            if(x)
                            {
                                printf("Elemento inserido com sucesso !");
                            }
                            else
                            {
                                printf("Elemento não inserido");
                            }
                            system("pause");
                            system("cls");
                            break;

                            case 1:
                            printf("\nInsira a matrícula que deseja procurar: ");
                            scanf("%d", &mat);

                            x = buscaHash_enderecoAberto(li, mat, &alunoNew);
                            if(x)
                            {
                                printf("Elemento encontrado !");
                            }
                            else
                            {
                                printf("Elemento não encontrado");
                            }

                            impressao_comtratamento(li,mat);
                            system("pause");
                            system("cls");
                            break;

                        }

                    printf("\nDeseja continuar ? (s = sim/ n = não): ");
                    scanf(" %c", &resposta);
                    system("pause");
                    system("cls");
                    break;

            }

    }
            liberaHash(li);

    return 0;
}
