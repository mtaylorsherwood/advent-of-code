package twentytwentyfour;

import utils.days;

import java.io.FileNotFoundException;

public class dayThree extends days {
    private final static String year = "2024";
    private final static String day = "03";

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

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            for (String chunk : line.split("mul\\(")) {
                answer += performMulti(chunk);
            }
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        boolean performMulti = true;
        while (input.hasNextLine()) {
            final String line = input.nextLine();
            for (String chunk : line.split("mul\\(")) {

                if (performMulti) {
                    answer += performMulti(chunk);
                }

                if (chunk.contains("don't()")) {
                    performMulti = false;
                } else if (chunk.contains("do()")) {
                    performMulti = true;
                }
            }
        }

        System.out.println("Puzzle Two: " + answer);
    }

    private static int performMulti(String chunk) {
        int findComma = chunk.indexOf(",");
        if (findComma != -1 && findComma <= 3) {
            try {
                int left = Integer.parseInt(chunk.substring(0, findComma));
                int findBrace = chunk.indexOf(")", findComma);
                if (findBrace != -1) {
                    int right = Integer.parseInt(chunk.substring(findComma + 1, findBrace));
                    return left * right;
                }
            } catch (NumberFormatException ignored) {
            }
        }

        return 0;
    }
}
