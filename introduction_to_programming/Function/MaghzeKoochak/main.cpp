#include <iostream>

int countDigits(int n) {
    int total = 0;
    while (n > 0) {
        n /= 10;
        total++;
    }
    return total;
}

bool isReadableNumber(int n, int max) {
    return n <= max;
}

int pow(int n, int power) {
    int result = 1;
    for (int i = 0; i < power; ++i) {
        result *= n;
    }
    return result;
}

int splitNumber(int n, int max) {
    while (!isReadableNumber(n, max)) {
        n /= 10;
    }
    return n;
}

int newNumberAfterSplit(int n, int split) {
    return n - split * (pow(10, countDigits(n) - countDigits(split)));
}

int main() {
    int number, n , max;
    std::cin >> n >> max;

    for (int i = 0; i < n; ++i) {
        std::cin >> number;
        bool firstOutput = true;
        while (number > 0) {
            int split = splitNumber(number, max);
            number = newNumberAfterSplit(number, split);
            firstOutput ? std::cout << split : std::cout << "-" << split;
            firstOutput = false;
        }
        std::cout << std::endl;
    }
}
