#include <stdio.h>

int main() {
    int m, s;
    long long int min, max;
    long long int start = 1;
    scanf("%d%d", &m, &s);

    for (int i = 0; i < m - 1; i++) {
        start *= 10;
    }

    int found = 0;
    for (long long int i = start; i < start * 10; i++) {
        int sum = 0;
        long long int temp = i;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        if (sum == s) {
            min = i;
            found = 1;
            break;
        }
    }

    if (!found) {
        printf("-1 -1");
        return 0;
    }

    for (long long int i = start * 10 - 1; i >= start; i--) {
        int sum = 0;
        long long int temp = i;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        if (sum == s) {
            max = i;
            break;
        }
    }

    printf("%lld %lld", min, max);    
    return 0;
}