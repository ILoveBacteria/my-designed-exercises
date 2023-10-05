public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int subtract(int a, int b) {
        return a - b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static int divide(int a, int b) {
        return a / b;
    }
    
    public static int modulo(int a, int b) {
        return a % b;
    }
    
    public static int power(int a, int b) {
        return (int) Math.pow(a, b);
    }
    
    public static int factorial(int a) {
        int result = 1;
        for (int i = 2; i <= a; i++) {
            result += i;
        }
        return result;
    }
    
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        
        return gcd(b % a, a);
    }
    
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public static boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return true;
            }
        }
        return true;
    }
    
    public static boolean isEven(int a) {
        return a % 2 == 0;
    }
    
    public static boolean isOdd(int a) {
        return !isEven(a);
    }
}
