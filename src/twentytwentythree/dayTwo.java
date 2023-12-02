package twentytwentythree;

import utils.days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class dayTwo extends days {
    private final static String year = "2023";
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
        int gameID;

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            gameID = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(":")));
            String[] gameSets = line.substring(line.indexOf(":")+1).split(";");
            boolean setIsOk = true;
            for (String set : gameSets) {
                int red = 0;
                int blue = 0;
                int green = 0;
                String[] dice = set.replace(" ", "").split(",");
                for (String die : dice) {
                    if (die.contains("red")) {
                        red += Integer.parseInt(die.substring(0, die.indexOf("red")));
                    } else if (die.contains("blue")) {
                        blue += Integer.parseInt(die.substring(0, die.indexOf("blue")));
                    } else if (die.contains("green")) {
                        green += Integer.parseInt(die.substring(0, die.indexOf("green")));
                    }
                }
                if (!(red <= 12 && blue <= 14 && green <= 13)) {
                    setIsOk = false;
                    break;
                }
            }
            if (setIsOk) {
                answer += gameID;
            }
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;

        while (input.hasNextLine()) {
            final String line = input.nextLine();
            String[] gameSets = line.substring(line.indexOf(":")+1).split(";");
            ArrayList<Integer> red = new ArrayList<>();
            ArrayList<Integer> blue = new ArrayList<>();
            ArrayList<Integer> green = new ArrayList<>();
            for (String set : gameSets) {
                String[] dice = set.replace(" ", "").split(",");
                for (String die : dice) {
                    if (die.contains("red")) {
                        red.add(Integer.parseInt(die.substring(0, die.indexOf("red"))));
                    } else if (die.contains("blue")) {
                        blue.add(Integer.parseInt(die.substring(0, die.indexOf("blue"))));
                    } else if (die.contains("green")) {
                        green.add(Integer.parseInt(die.substring(0, die.indexOf("green"))));
                    }
                }
            }
            red.sort(Collections.reverseOrder());
            blue.sort(Collections.reverseOrder());
            green.sort(Collections.reverseOrder());
            answer += (red.get(0) * blue.get(0) * green.get(0));
        }

        System.out.println("Puzzle Two: " + answer);
    }
}
