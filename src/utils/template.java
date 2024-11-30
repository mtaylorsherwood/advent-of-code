package utils;

import java.io.FileNotFoundException;

public class template extends days {
    private final static String year = "2042";
    private final static String day = "99";

    public static void main(String[] args) {
        System.out.println("Running day " + day + " puzzles");

        try {
            days.refreshScanner(year, day);
            puzzleOne();
            days.refreshScanner(year, day);
            puzzleTwo();
        } catch (FileNotFoundException ignored) {
            System.out.println("Input file not found");
        } finally {
            System.out.println("END");
        }
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
