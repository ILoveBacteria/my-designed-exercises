#include <iostream>

int lowerNumber(int a, int b) {
    if (a < b)
        return a;
    return b;
}

int gcd(int a, int b) {
    if (a == 1)
        return a;
    if (b == 1)
        return b;

    for (int i = lowerNumber(a, b); i >= 1; --i) {
        if (a % i == 0 && b % i == 0) {
            return i;
        }
    }
    return -1;
}

int lcm(int a, int b) {
    return a * b / gcd(a, b);
}

int main() {
    int n, number, resultNumber;
    bool lcmTurn = true;
    std::cin >> n >> resultNumber;

    for (int i = 1; i < n; ++i) {
        std::cin >> number;
        if (lcmTurn) {
            resultNumber = lcm(resultNumber, number);
        } else {
            resultNumber = gcd(resultNumber, number);
        }
        lcmTurn = !lcmTurn;
    }

    std::cout << resultNumber << std::endl;
}
