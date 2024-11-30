package twentytwentythree;

import utils.days;

import java.io.IOException;

public class dayFour extends days {
    private final static String year = "2023";
    private final static String day = "04";

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
        int lineNumber = 0;
        while (input.hasNextLine()) {
            final String line = input.nextLine();
            lineNumber++;
            int matches = getMatches(line);
            if (matches == 1) {
                answer += 1;
            } else if (matches > 1) {
                int result = 1;
                for (int i = matches; i > 1; i--) {
                    result *= 2;
                }
                answer += result;
            }
        }
        System.out.println("Lines: " + lineNumber);
        System.out.println("Puzzle One: " + answer);
    }

    private static int getMatches(final String line) {
        final String winningNumbers = line.substring(line.indexOf(":") + 1, line.indexOf("|")).trim();
        final String myNumbers = line.substring(line.indexOf("|") + 1).trim();
        int matches = 0;
        for (final String myNumber : myNumbers.split(" ")) {
            if (!myNumber.isEmpty()) {
                for (final String winner : winningNumbers.split(" ")) {
                    if (!winner.isEmpty() && myNumber.equals(winner)) {
                        matches++;
                        break;
                    }
                }
            }
        }
        return matches;
    }

    private static void puzzleTwo() {
        int answer = 0;
        System.out.println("Puzzle Two: " + answer);
    }
}
