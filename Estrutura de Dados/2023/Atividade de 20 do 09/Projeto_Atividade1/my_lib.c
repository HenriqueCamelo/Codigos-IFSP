#include <stdio.h>
#include <stdlib.h>
#include "my_lib.h"

 void calculoVantagens (int numeroHoras, int salarioHora, int numeroFilhos, int valorPorFilho, int *salarioBruto, int *salarioFamilia, int *vantagens)
    {
        *salarioBruto = numeroHoras * salarioHora;
        *salarioFamilia = numeroFilhos * valorPorFilho;
        *vantagens = *salarioBruto + *salarioFamilia;
    }

    void calculoDeducoes (int taxaIR, int *INSS, int *IRPF, int *Deducoes, int *salarioBruto)
    {
        *INSS = *salarioBruto * 0.08;
        *IRPF = *salarioBruto * taxaIR;
        *Deducoes = *INSS + *IRPF;
    }
