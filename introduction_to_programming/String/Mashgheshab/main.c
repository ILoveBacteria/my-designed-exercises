#include <stdio.h>
#include <string.h>

int main () {
    char data[400];
    int countWords = 0;
    fgets(data, 400, stdin);

    char wor[20][16];
    for (int i = 0, j = 0;; ++i, ++j) {
        if (data[i] == ' ' || data[i] == '\0') {
            wor[countWords][j] = '\0';
            countWords++;
            j = -1;
            if (data[i] == '\0') break;
            continue;
        }
        if (data[i] == '\n') {
            wor[countWords][j] = '\0';
        } else {
            wor[countWords][j] = data[i];
        }
    }

    for (int k = 1; k < countWords; k++) {
        if (strlen(wor[k]) != strlen(wor[k-1])) {
            printf("FALSE");
            return 0;
        }
    }

    int n = strlen(wor[0]);
    for (int k = 0; k < countWords; k++) {
        int i, j;
        for (i = 0; i < n - 1; i++)
            for (j = 0; j < n - i - 1; j++)
                if (wor[k][j] > wor[k][j + 1]) {
                    char temp = wor[k][j];
                    wor[k][j] = wor[k][j + 1];
                    wor[k][j + 1] = temp;
                }
    }

    for (int k = 1; k < countWords; k++) {
        if (strcmp(wor[k], wor[k-1])) {
            printf("FALSE");
            return 0;
        }
    }
    printf("TRUE");
    return 0;
}
