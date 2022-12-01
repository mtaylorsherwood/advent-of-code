package twentytwentytwo;

import utils.days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class dayOne extends days {
    private final static String year = "2022";
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
        int rations = 0;
        int biggestRation = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("")) {
                if (rations > biggestRation) {
                    biggestRation = rations;
                }
                rations = 0;
            } else {
                try {
                    rations += Integer.parseInt(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println("Puzzle One: " + biggestRation);
    }

    private static void puzzleTwo() {
        int rations = 0;
        int answer;
        final ArrayList<Integer> rationList = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("")) {
                rationList.add(rations);
                rations = 0;
            } else {
                try {
                    rations += Integer.parseInt(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        rationList.sort(Collections.reverseOrder());
        answer = (rationList.get(0) + rationList.get(1) + rationList.get(2));
        System.out.println("Puzzle Two: " + answer);
    }
}
