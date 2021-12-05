import java.io.IOException;

public class template extends days {
    private final static String day = "99";

    public static void main(String[] args) throws IOException {
        System.out.println("Running day " + day + " puzzles");
        refreshScanner(day);
        puzzleOne();
        refreshScanner(day);
        puzzleTwo();
        System.out.println("END");
    }

    private static void puzzleOne() {
        int answer = 0;
        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        System.out.println("Puzzle Two: " + answer);
    }
}
