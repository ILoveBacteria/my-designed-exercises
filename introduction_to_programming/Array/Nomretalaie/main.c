#include <stdio.h>

//if __name__ == '__main__':
//n, k = map(int, input().split(' '))
//price = list(map(int, input().split(' ')))
//
//if k >= 3:
//print(min(price))
//elif k == 1:
//print(max(price))
//else:
//result = None
//for i in range(1, n):
//temp = min(max(price[0:i]), max(price[i:n]))
//if result is None or temp < result:
//result = temp
//print(result)

int main () {
    int n, k;
    scanf("%d%d", &n, &k);

    int data[5000];
    for (int i = 0; i < n; ++i) {
        scanf("%d", &data[i]);
    }

    if (k >= 3) {
        int min = data[0];
        for (int i = 1; i < n; ++i) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        printf("%d", min);
    } else if (k == 1) {
        int max = data[0];
        for (int i = 1; i < n; ++i) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        printf("%d", max);
    } else {
        int result = 0;
        for (int i = 1; i < n; ++i) {
            int temp = data[0];
            for (int j = 1; j < i; ++j) {
                if (data[j] > temp) {
                    temp = data[j];
                }
            }
            int temp2 = data[i];
            for (int j = i + 1; j < n; ++j) {
                if (data[j] > temp2) {
                    temp2 = data[j];
                }
            }
            if (result == 0 || temp < result) {
                result = temp;
            }
            if (result == 0 || temp2 < result) {
                result = temp2;
            }
        }
        printf("%d", result);
    }
    

    return 0;
}
