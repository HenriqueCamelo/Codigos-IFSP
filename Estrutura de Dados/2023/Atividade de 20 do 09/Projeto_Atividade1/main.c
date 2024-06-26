#include <stdio.h>
#include <stdlib.h>
#include "my_lib.h"

int main()
{
    int nH1, sH1, nF1, vPF1, taxaIR, salarioFamilia, salarioBruto, vantagens, INSS, IRPF, Deducoes;

    printf ("Digite o número de horas trabalhadas: ");
    scanf("%d", &nH1);

    //nH = nH1;

    printf ("Digite o quanto recebe por hora: ");
    scanf("%d", &sH1);

    //sH = sH1;

    printf ("Digite o número de filhos: ");
    scanf("%d", &nF1);

    //nF = nF1;

    printf ("Digite o quanto cada filhos ganha: ");
    scanf("%d", &vPF1);

    //vPF = vPF1

    printf("Insira a taxa de IR: ");
    scanf("%d", &taxaIR);

    calculoVantagens( nH1, sH1, nF1, vPF1, &salarioBruto, &salarioFamilia, &vantagens);
    calculoDeducoes(taxaIR, &INSS, &IRPF, &Deducoes, &salarioBruto);

    printf("\n\n\nSeu salário bruto é: %d \n", salarioBruto);
    printf("Seu salário Família é: %d \n", salarioFamilia);
    printf("Suas vantagens são: %d \n", vantagens);
    printf("Seu INSS é: %d \n", INSS);
    printf("Seu IRPF é: %d \n", IRPF);
    printf("A dedução é: %d \n", Deducoes);

    return 0;
}
