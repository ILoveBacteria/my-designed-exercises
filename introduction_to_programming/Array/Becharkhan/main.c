#include <stdio.h>
#define SIZE 10


int main() {

    int array[SIZE][SIZE];
    int rotated_Array[SIZE][SIZE];
    int row, column;

    scanf("%d%d", &row, &column);

    for (int i = 0; i < row; ++i) {
        for (int j = 0; j < column; ++j) {

            scanf("%d", &array[i][j]);
        }
    }

    for (int i = 0; i < column; ++i) {
        for (int j = 0; j < row; ++j) {

            rotated_Array[i][row-1-j] = array[j][i];
        }
    }

    for (int i = 0; i < column; ++i) {
        for (int j = 0; j < row; ++j) {

            printf("%d ", rotated_Array[i][j]);
        }
        printf("\n");
    }

    return 0;
}