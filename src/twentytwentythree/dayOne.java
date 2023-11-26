package twentytwentythree;

import utils.days;

import java.io.IOException;

public class dayOne extends days {
    private final static String year = "2023";
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
        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        System.out.println("Puzzle Two: " + answer);
    }
}
