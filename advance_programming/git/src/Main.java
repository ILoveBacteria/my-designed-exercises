public class Main {
    public static void main(String[] args) {
        int facto = Calculator.factorial(4);
        boolean even = Calculator.isEven(2);
        boolean odd = Calculator.isOdd(2);
        System.out.printf("%d %d %d", facto, even ? 1 : 0, odd ? 1 : 0);
    }
}
