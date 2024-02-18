//
// Created by Mohammad Moein on 11/24/2022.
//

#include <stdio.h>

int max(int a, int b) {
    return a >= b ? a : b;
}

int min(int a, int b) {
    return a <= b ? a : b;
}

int countSquares(int a, int b) {
    if (a == 0 || b == 0)
        return 0;
    int maxLength = max(a, b);
    int minLength = min(a, b);
    int count = maxLength / minLength;
    return countSquares(maxLength - count * minLength, minLength) + count;
}

int main() {
    int a, b;
    scanf("%d%d", &a, &b);
    printf("%d", countSquares(a, b));
}
