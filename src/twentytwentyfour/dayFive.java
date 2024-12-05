package twentytwentyfour;

import utils.days;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class dayFive extends days {
    private final static String year = "2024";
    private final static String day = "05";

    private final static ArrayList<String> rules = new ArrayList<>();
    private final static ArrayList<String> pages = new ArrayList<>();
    private final static ArrayList<String> correctOrder = new ArrayList<>();
    private final static ArrayList<String> incorrectOrder = new ArrayList<>();

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

        populateLists();

        for (String pageList : pages) {
            sortPages(pageList);
        }

        for (String correct : correctOrder) {
            String[] correctArr = correct.split(",");
            answer += Integer.parseInt(correctArr[(correctArr.length - 1) / 2]);
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;
        ArrayList<String> fixedReport = new ArrayList<>();
        for (String incorrect : incorrectOrder) {
            fixedReport.clear();
            String[] incorrectArr = incorrect.split(",");

            for (int i = 0; i <= incorrectArr.length; i++) {
                try {
                    String current = incorrectArr[i];
                    String next = "";
                    try {
                        next = incorrectArr[i + 1];
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                    if (!fixedReport.contains(current)) {
                        fixedReport.add(i, current);
                    }

                    if (!next.isEmpty() && rules.contains(next + "|" + current)) {
                        fixedReport.add(i, next);
                    } else {
                        if (!next.isEmpty()) {
                            fixedReport.add(i + 1, next);
                        }
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }

            // Keep looping through to resort
            for (int j = 0; j < 24; j++) {
                for (int i = incorrectArr.length - 1; i >= 0; i--) {
                    String current = fixedReport.get(i);
                    try {
                        String previous = fixedReport.get(i - 1);
                        if (rules.contains(current + "|" + previous)) {
                            fixedReport.add(i - 1, current);
                            fixedReport.remove(i + 1);
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                }
            }

            String[] fixedArr = fixedReport.toArray(new String[0]);
            answer += Integer.parseInt(fixedArr[(fixedArr.length - 1) / 2]);
        }

        System.out.println("Puzzle Two: " + answer);
    }

    private static void populateLists() {
        boolean pageSet = false;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.isEmpty() && !pageSet) {
                pageSet = true;
            }

            if (!pageSet) {
                rules.add(line);
            } else {
                pages.add(line);
            }
        }

        //Get rid of the blank line separator
        pages.remove(0);
    }

    private static void sortPages(String pageList) {
        boolean correct = true;
        String[] pages = pageList.split(",");
        for (int i = 0; i <= pages.length; i++) {
            try {
                String current = pages[i];
                String next = pages[i + 1];

                if (rules.contains(next + "|" + current)) {
                    correct = false;
                    break;
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        if (correct) {
            correctOrder.add(pageList);
        } else {
            incorrectOrder.add(pageList);
        }
    }
}
