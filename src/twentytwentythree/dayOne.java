package twentytwentythree;

import utils.days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;

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
        final ArrayList<Integer> numbers = new ArrayList<>();

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            for (String c : line.split("")) {
                try {
                    int number = Integer.parseInt(c);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            String result = String.valueOf(numbers.get(0)) + String.valueOf(numbers.get(numbers.size() - 1));
            answer += Integer.parseInt(result);
            numbers.clear();
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        final ArrayList<Integer> numbers = new ArrayList<>();
        final Map<String, Integer> digits = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );
        while (input.hasNextLine()) {
            final String line = input.nextLine();
            StringJoiner letters = new StringJoiner("");
            for (String c : line.split("")) {
                try {
                    int number = Integer.parseInt(c);
                    numbers.add(number);
                    letters = new StringJoiner("");
                } catch (NumberFormatException e) {
                    letters.add(c);

                    if (letters.toString().length() >= 3) {
                        for (String key : digits.keySet()) {
                            if (letters.toString().contains(key)) {
                                numbers.add(digits.get(key));
                                letters = new StringJoiner("").add(String.valueOf(letters.toString().charAt(letters.toString().length()-1)));
                                break;
                            }
                        }
                    }
                }
            }
            String result = String.valueOf(numbers.get(0)) + String.valueOf(numbers.get((numbers.size() - 1)));
            answer += Integer.parseInt(result);
            numbers.clear();
        }
        System.out.println("Puzzle Two: " + answer);
    }
}
