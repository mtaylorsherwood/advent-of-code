package twentytwentytwo;

import utils.days;

import java.io.IOException;

public class dayTwo extends days {
    private final static String year = "2022";
    private final static String day = "02";

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
        int roundScore;

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            final String[] actions = line.split(" ");
            roundScore = actionScore(actions[1]);
            roundScore += winLoss(actions[0], actions[1]);
            answer += roundScore;
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        int roundScore;

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            final String[] actions = line.split(" ");
            roundScore = actionScore(actionToUse(actions[0], actions[1]));
            roundScore += actions[1].equals("X") ? 0 : (actions[1].equals("Y") ? 3 : 6);
            answer += roundScore;
        }

        System.out.println("Puzzle Two: " + answer);
    }

    private static int winLoss(final String opponent, final String player) {
        switch (opponent) {
            case "A" -> {
                switch (player) {
                    case "X" -> {
                        return 3;
                    }
                    case "Y" -> {
                        return 6;
                    }
                    case "Z" -> {
                        return 0;
                    }
                }
            }
            case "B" -> {
                switch (player) {
                    case "X" -> {
                        return 0;
                    }
                    case "Y" -> {
                        return 3;
                    }
                    case "Z" -> {
                        return 6;
                    }
                }
            }
            case "C" -> {
                switch (player) {
                    case "X" -> {
                        return 6;
                    }
                    case "Y" -> {
                        return 0;
                    }
                    case "Z" -> {
                        return 3;
                    }
                }
            }
        }

        return 0;
    }

    private static String actionToUse(final String opponent, final String desiredOutcome) {
        switch (desiredOutcome) {
            case "X" -> {
                switch (opponent) {
                    case "A" -> {
                        return "Z";
                    }
                    case "B" -> {
                        return "X";
                    }
                    case "C" -> {
                        return "Y";
                    }
                }
            }
            case "Y" -> {
                switch (opponent) {
                    case "A" -> {
                        return "X";
                    }
                    case "B" -> {
                        return "Y";
                    }
                    case "C" -> {
                        return "Z";
                    }
                }
            }
            case "Z" -> {
                switch (opponent) {
                    case "A" -> {
                        return "Y";
                    }
                    case "B" -> {
                        return "Z";
                    }
                    case "C" -> {
                        return "X";
                    }
                }
            }
        }

        return "U";
    }

    private static int actionScore(final String action) {
        switch (action) {
            case "X" -> {
                return 1;
            }
            case "Y" -> {
                return 2;
            }
            case "Z" -> {
                return 3;
            }
        }
        return 0;
    }
}
