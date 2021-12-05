import java.io.IOException;

public class dayTwo extends days {
    private final static String day = "02";
    private static String direction;
    private static int units;

    public static void main(String[] args) throws IOException {
        System.out.println("Running day " + day + " puzzles");
        refreshScanner(day);
        puzzleOne();
        refreshScanner(day);
        puzzleTwo();
        System.out.println("END");
    }

    private static void puzzleOne() {
        int answer;
        int horizontal = 0;
        int depth = 0;

        while (input.hasNextLine()) {
            processLine();
            switch (direction) {
                case "forward" -> horizontal = (horizontal + units);
                case "down" -> depth = (depth - units);
                case "up" -> depth = (depth + units);
            }
        }
        answer = (horizontal * Math.abs(depth));
        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer;
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        while (input.hasNextLine()) {
            processLine();
            switch (direction) {
                case "forward" -> {
                    horizontal = (horizontal + units);
                    depth += (aim * units);
                }
                case "down" -> aim = (aim + units);
                case "up" -> aim = (aim - units);
            }
        }
        answer = (horizontal * Math.abs(depth));
        System.out.println("Puzzle Two: " + answer);
    }

    private static void processLine() {
        String line = input.nextLine();
        direction = line.substring(0, line.indexOf(' '));
        units = Integer.parseInt(line.substring(line.indexOf(' ') + 1));
    }
}
