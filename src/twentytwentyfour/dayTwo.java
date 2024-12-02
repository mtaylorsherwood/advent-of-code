package twentytwentyfour;

import utils.days;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class dayTwo extends days {
    private final static String year = "2024";
    private final static String day = "02";

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

        while (input.hasNextLine()) {
            final String line = input.nextLine();

            if (safeReports(line.split(" "))) {
                answer++;
            }
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;

        while (input.hasNextLine()) {
            final String line = input.nextLine();

            String[] arr = line.split(" ");

            boolean any = false;
            for (int i = 0; i < arr.length; i++) {
                String[] dampenedReport = new String[arr.length - 1];
                System.arraycopy(arr, 0, dampenedReport, 0, i);
                if (arr.length >= i + 1) {
                    System.arraycopy(arr, i + 1, dampenedReport, i + 1 - 1, arr.length - (i + 1));
                }

                if (safeReports(dampenedReport)) {
                    any = true;
                }
            }
            if (any) {
                answer++;
            }
        }

        System.out.println("Puzzle Two: " + answer);
    }

    /**
     * What a mess...
     */
    private static boolean safeReports(String[] entries) {
        final ArrayList<Integer> report = new ArrayList<>();
        for (String entry : entries) {
            report.add(Integer.parseInt(entry));
        }

        int start = report.get(0);
        boolean ascending = false;
        boolean descending = false;

        for (int i = 1; i < report.size(); i++) {
            ascending = report.get(i) > start;
            if (!ascending) {
                break;
            }
        }

        for (int i = 1; i < report.size(); i++) {
            descending = report.get(i) < start;
            if (!descending) {
                break;
            }
        }

        if (ascending || descending) {
            boolean safe = true;
            for (int i = 0; i < report.size(); i++) {
                try {
                    int current = report.get(i);
                    int next = report.get(i + 1);

                    int asc = next - current;
                    int dsc = current - next;

                    if (ascending && (asc <= 0 || asc > 3)) {
                        safe = false;
                        break;
                    } else if (descending && (dsc <= 0 || dsc > 3)) {
                        safe = false;
                        break;
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
            return safe;
        }
        return false;
    }
}
