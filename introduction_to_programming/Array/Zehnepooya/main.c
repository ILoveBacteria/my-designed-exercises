#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    
    int heights[1000];
    for (int i = 0; i < n; i++) {
        scanf("%d", &heights[i]);
    }

    int a = 0;
    int b = n - 1;
    int max = 0;
    int min = 1001;
    while (a < b) {
        for (int i = a; i <= b; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        
        int area = (b - a) * min;
        if (area > max) {
            max = area;
        }
        if (heights[a] < heights[b]) {
            a++;
        } else {
            b--;
        }
    }
}