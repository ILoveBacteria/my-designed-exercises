import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        
        // Input matrix
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Person position in matrix
        int personRow = scanner.nextInt();
        int personColumn = scanner.nextInt();
        
        while (scanner.hasNext()) {
            String nextWord = scanner.next();
            int vowels = countVowelInWord(nextWord);
            int canHear = sumPeopleCanHearVoice(matrix, personRow, personColumn, vowels);
            System.out.println(canHear);
        }
    }
    
    private static int sumPeopleCanHearVoice(int[][] matrix, int personRow, int personColumn, int radius) {
        int sum = 0;
        for (int i = personRow - radius; i <= personRow + radius; i++) {
            for (int j = personColumn - radius; j <= personColumn + radius; j++) {
                if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
    
    private static int countVowelInWord(String word) {
        int countVowels = 0;
        for (char w : word.toCharArray()) {
            if (w == 'a' || w == 'e' || w == 'i' || w == 'o' || w == 'u') {
                countVowels++;
            }
        }
        return countVowels;
    }
}
