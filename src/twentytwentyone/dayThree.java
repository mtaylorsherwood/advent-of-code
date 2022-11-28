package twentytwentyone;

import utils.days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dayThree extends days {
    private final static String year = "2021";
    private final static String day = "03";

    public static void main(String[] args) throws IOException {
        System.out.println("Running day " + day + " puzzles");
        days.refreshScanner(year, day);
        puzzleOne();
        days.refreshScanner(year, day);
        puzzleTwo();
        System.out.println("END");
    }

    private static void puzzleOne() {
        int answer;
        int zero = 0;
        int one = 0;
        List<String> list = new ArrayList<>();
        StringBuilder epsilon = new StringBuilder();
        StringBuilder gamma = new StringBuilder();
        while (days.input.hasNextLine()) {
            list.add(days.input.nextLine());
        }
        for (int i = 0; i < 12; i++) {
            for (String line : list) {
                char c = line.charAt(i);
                switch (c) {
                    case '0' -> zero++;
                    case '1' -> one++;
                }
            }
            if (zero > one) {
                gamma.append("0");
                epsilon.append("1");
            } else {
                gamma.append("1");
                epsilon.append("0");
            }
            zero = 0;
            one = 0;
        }
        System.out.println(epsilon);
        System.out.println(gamma);
        System.out.println(Integer.parseInt(epsilon.toString(), 2));
        System.out.println(Integer.parseInt(gamma.toString(), 2));
        answer = (Integer.parseInt(epsilon.toString(), 2) * Integer.parseInt(gamma.toString(), 2));
        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        System.out.println("Puzzle Two: " + answer);
    }
}
