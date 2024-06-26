#include <stdio.h>
#include <stdlib.h>
#include <string.h>




int main()
{
    float teste1[10];
    double teste2[10];
    int x, y;

    for( x = 0; x < 10; x++)
    {
        printf("\nPosião %d: endereço %p \n", x, &teste1[x]);
    }

     printf("\n\n\nDouble");

    for( y = 0; y < 10; y++)
    {

        printf("\nPosião %d: endereço %p \n", y, &teste2[y]);
    }

      return 0;
}







