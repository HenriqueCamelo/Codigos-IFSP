#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "projetoF.h"

char continuar = 's';

int main()
{


    char nome[30];
    int quantidade = 0;
    int procura;
    int escolha;
    int salvado;
    int x, y, n,idp = 2, id = 2;


    printf("iniciando...");

    Lista *li;

    FUNCIONARIO fu1, fu2,fu,novo;

    li = crialista();


    salvo(li, "arquivo.bin");
    printf("entrou aqui");


    while(continuar == 's')
    {
        printf("Escolha uma das opções:\n(1)Inserir um novo contato\n(2)Exibir lista de contatos\n(3)Procurar por contato via Id\n(4)Procurar contato via nome\n(5)Editar contato\n(6)Remover contato via Id\n(7)Salvar e Encerrar\n");
        scanf("%d", &escolha);

        system("cls");

        switch(escolha)
        {
            case 1:

                printf("Inserção de usuário:\n\n");
                novo = coletadados();

                x = insere_lista_ordenada(li, novo);
                if(x)
                {
                    printf("\nUsuário inserido ordenadamente");
                }
                else
                {
                    printf("\nERRO, Inserção não efetuada\n");
                }

                x = tamLista(li);
                printf("\nO tamanho da lista atualmente é: %d\n", x);

                system("pause");
                system("cls");
                break;

            case 2:
                printf("Lista de contato: \n\n");

                x = tamLista(li);
                printf("A quantidade de contatos é: %d", x);

                mostra_lista(li, x);





//                for(y = 0;y < x; y++ )
//                {
//                    n = consulta_lista_pos(li, y, &fu);
//                    if(n)
//                    {
//                        printf("\nConteúdo da posição %d:", quantidade);
//                        printf("\nId: %d", fu.id);
//                        printf("\nNome: %s", fu.nome);
//                        printf("\nEmpresa: %s", fu.empresa);
//                        printf("\nDepartamento: %s", fu.departamento);
//                        printf("\nTelefone: %d", fu.teleFixo);
//                        printf("\nCelular: %d", fu.cel);
//                        printf("\nE-mail: %s\n", fu.email);
//
//                    }
//                    else
//                    {
//                        printf("\nO Id: %d não foi encontrado\n", procura);
//                    }
//
//                }





                system("pause");
                system("cls");
                break;

            case 3:
                printf("Procura id:\n\n");
                printf("Digite o Id do funcionário que deseja encontrar: ");
                scanf("%d", &procura);

                impressao(li, procura);

                system("pause");
                system("cls");
                break;

            case 4:
                getchar();
                printf("Procurar nome:\n\n");

                gets(nome);

                busca(li, nome);

                system("pause");
                system("cls");
                break;

            case 5:
                printf("Editar Id :\n\n");
                printf("Digite o Id que deseja alterar: ");
                scanf("%d", &procura);

                impressao(li, procura);

                remove_lista(li, procura);

                printf("Edição de usuário:\n\n");
                novo = coletadados();

                x = insere_lista_ordenada(li, novo);
                if(x)
                {
                    printf("\nUsuário editado ordenadamente");
                }
                else
                {
                    printf("\nERRO, edição não efetuada\n");
                }


                system("pause");
                system("cls");
                break;

            case 6:
                printf("Digite o Id do contato que deseja remover: ");
                scanf("%d", &procura);

                x = remove_lista(li, procura);
                if(x)
                {
                    printf("\nElemento removido com sucesso\n");
                }
                else
                {
                    printf("\nERRO, remoção incompleta\n");
                }

                system("pause");
                system("cls");
                break;

            case 7:


                printf("Deseja continuar a rodar o programa ?: ");
                scanf(" %c", &continuar);

                salvamento(li);

                apagaLista(li);
                break;

            default:
                printf("\nOpção inválida\n");
                system("pause");
                system("cls");
                break;


        }
    }




}
