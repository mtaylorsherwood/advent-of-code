package twentytwentyone;

import utils.days;

import java.io.IOException;

public class dayOne extends days {
    private final static String year = "2021";
    private final static String day = "01";

    public static void main(String[] args) throws IOException {
        System.out.println("Running day " + day + " puzzles");
        days.refreshScanner(year, day);
        puzzleOne();
        days.refreshScanner(year, day);
        puzzleTwo();
        System.out.println("END");
    }

    private static void puzzleOne() {
        int answer = 0;
        int previous = Integer.parseInt(days.input.nextLine());
        int current;

        while (days.input.hasNextLine()) {
            current = Integer.parseInt(days.input.nextLine());
            if (current > previous) {
                answer++;
            }
            previous = current;
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        int a = Integer.parseInt(days.input.nextLine());
        int b = Integer.parseInt(days.input.nextLine());
        int c = Integer.parseInt(days.input.nextLine());
        int previousSum = a + b + c;

        while (days.input.hasNextLine()) {
            c = Integer.parseInt(days.input.nextLine());
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
