package twentytwentytwo;

import utils.days;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dayFour extends days {
    private final static String year = "2022";
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

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            final Map<Integer, Integer> first = new HashMap<>();
            final Map<Integer, Integer> second = new HashMap<>();
            final String[] assignments = line.split(",");
            final String[] firstRange = assignments[0].split("-");
            final String[] secondRange = assignments[1].split("-");

            for (int i = Integer.parseInt(firstRange[0]); i <= Integer.parseInt(firstRange[1]); i++) {
                first.put(i, i);
            }
            for (int i = Integer.parseInt(secondRange[0]); i <= Integer.parseInt(secondRange[1]); i++) {
                second.put(i, i);
            }

            final int difference = ((Math.abs(Integer.parseInt(firstRange[1]) - Integer.parseInt(secondRange[1]))) + (Math.abs(Integer.parseInt(firstRange[0]) - Integer.parseInt(secondRange[0]))));

            int possibleOverlap = 0;
            for (final Integer id : first.values()) {
                if (second.containsKey(id)) {
                    possibleOverlap++;
                }
            }
            if (possibleOverlap == first.size() || possibleOverlap == (first.size() - difference)) {
                answer++;
            } else {
                possibleOverlap = 0;
                for (final Integer id : second.values()) {
                    if (first.containsKey(id)) {
                        possibleOverlap++;
                    }
                }
                if (possibleOverlap == second.size() || possibleOverlap == (second.size() - difference)) {
                    answer++;
                }
            }
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            final Map<Integer, Integer> first = new HashMap<>();
            final Map<Integer, Integer> second = new HashMap<>();
            final String[] assignments = line.split(",");
            final String[] firstRange = assignments[0].split("-");
            final String[] secondRange = assignments[1].split("-");

            for (int i = Integer.parseInt(firstRange[0]); i <= Integer.parseInt(firstRange[1]); i++) {
                first.put(i, i);
            }
            for (int i = Integer.parseInt(secondRange[0]); i <= Integer.parseInt(secondRange[1]); i++) {
                second.put(i, i);
            }

            for (final Integer id : first.values()) {
                if (second.containsKey(id)) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println("Puzzle Two: " + answer);
    }
}
