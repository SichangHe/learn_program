#include <stdio.h>

int main(int argc, char const* argv[])
{
    // initialize 3 × 2 array
    int matrix[3][2] = { { 0, 0 }, { 1, 2 }, { 7, 5 } };
    printf("%d\n", matrix[2][1]);

    // can omit first size
    int matrix1[][2] = { { 0, 0 }, { 1, 2 }, { 7, 5 } };
    printf("%d\n", matrix1[2][1]);

    // cannot omit first size
    /*
    int matrix2[][] = { { 0, 0 }, { 1, 2 }, { 7, 5 } };
    printf("%d\n", matrix2[2][1]);
    */

    // can supply one array
    int matrix2[3][2] = { 0, 0, 1, 2, 7, 5 };
    printf("%d\n", matrix2[2][1]);
    return 0;
}
