//
// Created by Mohammad Moein on 11/22/2022.
//

#include <stdio.h>

long long int countPairs(int n) {
    if (n < 2)
        return 1;
    return countPairs(n - 1) + (n - 1) * countPairs(n - 2);
}

int main() {
    int n;
    scanf("%d", &n);
    printf("%lld", countPairs(n));
}
