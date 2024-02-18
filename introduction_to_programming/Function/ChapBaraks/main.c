#include <stdio.h>


void solver(int n) {
    if (n == 0) {
        return;
    }
    int num;
    scanf("%d", &num);
    solver(n - 1);
    if (num % 2 != 0) {
        printf("%d\n", num);
    }
}

int main() {
    int n;
    scanf("%d", &n);
    solver(n);
}