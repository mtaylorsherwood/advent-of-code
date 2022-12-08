package twentytwentytwo;

import utils.days;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class daySix extends days {
    private final static String year = "2022";
    private final static String day = "06";

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

        final String line = input.nextLine();

        final Map<Integer, String> buffer = new HashMap<>();

        int markerPoint = 1;
        int i = 1;
        for (final String character : line.split("")) {
            buffer.put(i, character);
            i++;
            markerPoint++;
            if (i > 4) {
                Set<String> valuesSet = new HashSet<>(buffer.values());
                if (buffer.size() == valuesSet.size()) {
                    answer = markerPoint - 2;
                    break;
                } else {
                    buffer.clear();
                    i = 2;
                    buffer.put(1, character);
                }
            }
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;

        final String line = input.nextLine();

        final Map<Integer, String> buffer = new HashMap<>();

        int stringPoint = 0;

        while (answer == 0) {
            int i = 1;
            for (final String character : line.substring(stringPoint, stringPoint + 14).split("")) {
                buffer.put(i, character);
                i++;
            }
            Set<String> valuesSet = new HashSet<>(buffer.values());
            if (buffer.size() == valuesSet.size()) {
                answer = (stringPoint + 14);
            } else {
                buffer.clear();
                stringPoint = (stringPoint + 1);
            }
        }

        System.out.println("Puzzle Two: " + answer);
    }
}
