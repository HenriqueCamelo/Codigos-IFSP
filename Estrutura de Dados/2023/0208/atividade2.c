
#include <stdio.h>
#include <stdlib.h>

void calculoVantagens (int númeroHoras, int salárioHora, int númeroFilhos, int valorPorFilho, int *salarioBruto, int *salarioFamilia, int *vantagens);
void calculoDeducoes (int taxaIR, int *INSS, int *IRPF, int *Deduções, int *salarioBruto);

//int salarioBruto, salarioFamilia, vantagens, INSS, IRPF, taxaIR, Deduções;


int main ()
{
    int nH1, sH1, nF1, vPF1, taxaIR, salarioFamilia, salarioBruto, vantagens, INSS, IRPF, Deduções;

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
    calculoDeducoes(taxaIR, &INSS, &IRPF, &Deduções, &salarioBruto);

    printf("\n\n\nSeu salário bruto é: %d \n", salarioBruto);
    printf("Seu salário Família é: %d \n", salarioFamilia);
    printf("Suas vantagens são: %d \n", vantagens);
    printf("Seu INSS é: %d \n", INSS);
    printf("Seu IRPF é: %d \n", IRPF);
    printf("A dedução é: %d \n", Deduções);

    return 0;
}

    void calculoVantagens (int númeroHoras, int salárioHora, int númeroFilhos, int valorPorFilho, int *salarioBruto, int *salarioFamilia, int *vantagens)
    {
        *salarioBruto = númeroHoras * salárioHora;
        *salarioFamilia = númeroFilhos * valorPorFilho;
        *vantagens = *salarioBruto + *salarioFamilia;
    }

    void calculoDeducoes (int taxaIR, int *INSS, int *IRPF, int *Deduções, int *salarioBruto)
    {
        *INSS = *salarioBruto * 0.08;
        *IRPF = *salarioBruto * taxaIR;
        *Deduções = *INSS + *IRPF;
    }

