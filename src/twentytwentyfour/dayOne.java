package twentytwentyfour;

import utils.days;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


public class dayOne extends days {
    private final static String year = "2024";
    private final static String day = "01";

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
        final ArrayList<Integer> left = new ArrayList<>();
        final ArrayList<Integer> right = new ArrayList<>();
        int lineNo = 1;

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            for (String c : line.split(" {3}")) {
                if (lineNo % 2 == 0) {
                    right.add(Integer.parseInt(c));
                } else {
                    left.add(Integer.parseInt(c));
                }
                lineNo++;
            }
        }

        Collections.sort(left);
        Collections.sort(right);

        for (int i = 0; i < 1000; i++) {
            int leftNum = left.get(i);
            int rightNum = right.get(i);
            answer += (leftNum > rightNum) ? leftNum - rightNum : rightNum - leftNum;
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;

        final ArrayList<Integer> left = new ArrayList<>();
        final ArrayList<Integer> right = new ArrayList<>();
        int lineNo = 1;

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            for (String c : line.split(" {3}")) {
                if (lineNo % 2 == 0) {
                    right.add(Integer.parseInt(c));
                } else {
                    left.add(Integer.parseInt(c));
                }
                lineNo++;
            }
        }

        for (int location : left) {
            answer += (location * Collections.frequency(right, location));
        }

        System.out.println("Puzzle Two: " + answer);
    }
}
