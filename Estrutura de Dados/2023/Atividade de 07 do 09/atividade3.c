#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    int *m;
    int *n;
    int *s;
    int d1, d2, d3, d4, i, f, g, h, j;


    printf(" Digite as medidas da matrix 1 (ex: 1x2, 4x5, 3x3) dando Enter o primeiro e o segundo digito: ");
    scanf("%d", &d1);
    scanf("%d", &d2);

    printf(" Digite as medidas da matrix 2 (ex: 1x2, 4x5, 3x3) dando Enter o primeiro e o segundo digito: ");
    scanf("%d", &d3);
    scanf("%d", &d4);

    m = (int*) calloc(d1*d2, sizeof(int));
    n = (int*) calloc(d3*d4, sizeof(int));
    s = (int*) calloc(d3*d4, sizeof(int));

    printf("\n\n\n");

    for (i = 0; i < d1; i++)
    {
        for(f = 0; f < d2; f++)
        {
            m[f] = f + 1;
            printf("%d ", m[f]);
            if( f == d1 - 1)
            {
                printf("\n");
            }
        }
    }

    printf("\n\n\n");

    for (g = 0; g < d3; g++)
    {
        for(h = 0; h < d4; h++)
        {
            n[h] = h + 1;
            printf("%d ", n[h]);
            if( h == d3 - 1)
            {
                printf("\n");
            }
        }
    }

    printf("\n\n\n");

    for (g = 0; g < d3; g++)
    {
        for(j = 0; j < d4; j++)
        {
            //s[j] = n[h] + m[f];
            s[j] = ((j+1)*2);
            printf("%d ", s[j]);

            if( j == d3 - 1)
            {
                printf("\n");
            }
        }
    }


    return 0;
}
