package twentytwentyfour;

import utils.days;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class daySix extends days {
    private final static String year = "2024";
    private final static String day = "06";

    private final static ArrayList<String> map = new ArrayList<>();
    private final static ArrayList<String> positions = new ArrayList<>();

    private static int currentLine = 0;
    private static int currentPosition = 0;

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

        populateMap();

        boolean onTheMap = true;
        String direction = "UP";

        while (onTheMap) {
            String line = map.get(currentLine);
            String nextLine;
            try {
                switch (direction) {
                    case "UP" -> {
                        nextLine = map.get(currentLine - 1);
                        if (nextLine.split("")[currentPosition].equals(".")) {
                            addPosition((currentLine - 1), currentPosition);
                            currentLine = currentLine - 1;
                        } else {
                            direction = "RIGHT";
                        }
                    }
                    case "DOWN" -> {
                        nextLine = map.get(currentLine + 1);
                        if (nextLine.split("")[currentPosition].equals(".")) {
                            addPosition((currentLine + 1), currentPosition);
                            currentLine = currentLine + 1;
                        } else {
                            direction = "LEFT";
                        }
                    }
                    case "LEFT" -> {
                        nextLine = line;
                        if (nextLine.split("")[currentPosition - 1].equals(".")) {
                            addPosition(currentLine, (currentPosition - 1));
                            currentPosition--;
                        } else {
                            direction = "UP";
                        }
                    }
                    case "RIGHT" -> {
                        nextLine = line;
                        if (nextLine.split("")[currentPosition + 1].equals(".")) {
                            addPosition(currentLine, (currentPosition + 1));
                            currentPosition++;
                        } else {
                            direction = "DOWN";
                        }
                    }
                }
            } catch (IndexOutOfBoundsException fellOffTheMap) {
                onTheMap = false;
            }
        }

        answer += positions.size();

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        System.out.println("Puzzle Two: " + answer);
    }

    private static void populateMap() {
        int i = -1;
        while (input.hasNextLine()) {
            i++;
            String line = input.nextLine();
            if (line.contains("^")) {
                currentPosition = line.indexOf("^");
                currentLine = i;
                addPosition(currentLine, currentPosition);
                line = line.replace("^", ".");
            }
            map.add(line);
        }
    }

    private static void addPosition(int line, int position) {
        final String positionCombination = line + "|" + position;

        if (!positions.contains(positionCombination)) {
            positions.add(positionCombination);
        }
    }
}
