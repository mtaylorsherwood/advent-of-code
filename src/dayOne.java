import java.io.IOException;

public class dayOne extends days {
    private final static String day = "01";

    public static void main(String[] args) throws IOException {
        System.out.println("Running day " + day + " puzzles");
        refreshScanner(day);
        puzzleOne();
        refreshScanner(day);
        puzzleTwo();
        System.out.println("END");
    }

    private static void puzzleOne() {
        int answer = 0;
        int previous = Integer.parseInt(input.nextLine());
        int current;

        while (input.hasNextLine()) {
            current = Integer.parseInt(input.nextLine());
            if (current > previous) {
                answer++;
            }
            previous = current;
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        int a = Integer.parseInt(input.nextLine());
        int b = Integer.parseInt(input.nextLine());
        int c = Integer.parseInt(input.nextLine());
        int previousSum = a + b + c;

        while (input.hasNextLine()) {
            c = Integer.parseInt(input.nextLine());
            int sum = a + b + c;
            if (sum > previousSum) {
                answer++;
            }
            previousSum = sum;
            a = b;
            b = c;

        }

        System.out.println("Puzzle Two: " + answer);
    }
}
