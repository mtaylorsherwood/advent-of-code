package twentytwentytwo;

import utils.days;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dayThree extends days {
    private final static String year = "2022";
    private final static String day = "03";

    private final static String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    private final static Map<String, Integer> letterScore = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            letterScore.put(alphabet[i].toLowerCase(), i + 1);
        }
        for (int i = 0; i < 26; i++) {
            letterScore.put(alphabet[i], i + 27);
        }
    }

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
            String duplicate = null;
            final Map<String, String> check = new HashMap<>();
            final int midPoint = (line.length() / 2);
            final String[] first = (line.substring(0, midPoint)).split("");
            final String[] second = (line.substring(midPoint)).split("");
            for (final String character : first) {
                check.put(character, character);
            }
            for (final String character : second) {
                duplicate = check.get(character);
                if (duplicate != null) {
                    break;
                }
            }
            answer += letterScore.get(duplicate);
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;

        while (input.hasNextLine()) {
            final String lineOne = input.nextLine();
            final String lineTwo = input.nextLine();
            final String lineThree = input.nextLine();
            String duplicate = null;
            final Map<String, String> two = new HashMap<>();
            final Map<String, String> three = new HashMap<>();
            for (final String character : lineTwo.split("")) {
                two.put(character, character);
            }
            for (final String character : lineThree.split("")) {
                three.put(character, character);
            }
            for (final String character : lineOne.split("")) {
                if (two.containsKey(character) && three.containsKey(character)) {
                    duplicate = character;
                }
            }
            answer += letterScore.get(duplicate);
        }

        System.out.println("Puzzle Two: " + answer);
    }
}
