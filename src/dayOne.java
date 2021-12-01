import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class dayOne {
    public static void main(String[] args) throws IOException {
        System.out.println("Running puzzles");
        puzzleOne();
        puzzleTwo();
        System.out.println("END");
    }

    private static void puzzleOne() throws IOException {
        int answer = 0;
        Scanner input = new Scanner(new File("C:\\development\\advent-of-code\\out\\production\\input.txt"));
        int previous = Integer.parseInt(input.nextLine());
        int current;

        while (input.hasNextLine()) {
            current = Integer.parseInt(input.nextLine());
            if (current > previous) {
                answer++;
            }
            previous = current;
        }

        System.out.println("Puzzle One: " + answer) ;
    }

    private static void puzzleTwo() {
        String answer = "unknown";
        System.out.println("Puzzle Two: " + answer);
    }
}
