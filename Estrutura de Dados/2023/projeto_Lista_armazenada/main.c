#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "projetoF.h"

//GU3042511 Henrique Ferreira Camelo
//GU3042634 Guilherme Vieira da Silva

char continuar = 's';

int main()
{
    char nome[30];
    int procura;
    int escolha;
    int salvado;
    int x;

    LISTA *lista;

    FUNCIONARIO novoFuncionario;

    lista = crialista();

    lerArquivoDeMemoria(lista, "arquivo.bin");

    while(continuar == 's')
    {
        printf("------------------------------------------------\n\n");
        printf("\tOla, seja bem vindo!\n\tEscolha uma das opcoes:\n\n\t1 - Inserir um contato\n\t2 - Exibir lista de contatos\n\t3 - Procurar por contato via Id\n\t4 - Procurar contato via nome\n\t5 - Editar contato\n\t6 - Remover contato via Id\n\t7 - Salvar e Encerrar\n\n");
        printf("------------------------------------------------\n\n");
        scanf("%d", &escolha);


        system("cls");

        switch(escolha)
        {
            case 1:
                printf("Insercao de usuario:\n\n");
                novoFuncionario = coletadados();
                x = insere_lista_ordenada(lista, novoFuncionario);
                if(x)
                {
                    printf("\nUsuario inserido ordenadamente");
                }
                else
                {
                    printf("\nERRO, Insercao nao efetuada\n");
                }

                x = tamLista(lista);
                printf("\nO tamanho da lista atualmente �: %d\n", x);

                system("pause");
                system("cls");
                break;

            case 2:
                printf("Lista de contato: \n\n");

                x = tamLista(lista);
                printf("A quantidade de contatos e: %d\n\n", x);

                mostra_lista(lista, x);

                system("pause");
                system("cls");
                break;

            case 3:
                printf("Procura id:\n\n");
                printf("Digite o Id do funcionario que deseja encontrar: ");
                scanf("%d", &procura);

                impressao(lista, procura);

                system("pause");
                system("cls");
                break;

            case 4:
                getchar();
                printf("Procurar nome:\n\n");

                gets(nome);

                busca(lista, nome);

                system("pause");
                system("cls");
                break;

            case 5:
                printf("Editar Id :\n\n");
                printf("Digite o Id que deseja alterar: ");
                scanf("%d", &procura);

                x = remove_lista(lista, procura);

                if(x){
                printf("Edi��o de usu�rio:\n\n");
                novoFuncionario = coletadados();

                x = insere_lista_ordenada(lista, novoFuncionario);
                if(x)
                {
                    printf("\nUsuario editado ordenadamente");
                }
                else
                {
                    printf("\nERRO, edicao nao efetuada\n");
                }

                system("pause");
                system("cls");
                break;
                }
                else
                {
                system("pause");
                system("cls");
                break;
                }

            case 6:
                printf("Digite o Id do contato que deseja remover: ");
                scanf("%d", &procura);

                x = remove_lista(lista, procura);
                if(x)
                {
                    printf("\nElemento removido com sucesso\n");
                }
                else
                {
                    printf("\nERRO, remocao incompleta\n");
                }

                system("pause");
                system("cls");
                break;

            case 7:
                printf("Deseja continuar a rodar o programa ?: ");
                scanf(" %c", &continuar);

                salvandoDados(lista);

                apagaLista(lista);
                break;

            default:
                printf("\nOpcao invalida\n");
                system("pause");
                system("cls");
                break;

        }
    }
}
