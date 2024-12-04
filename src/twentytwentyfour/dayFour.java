package twentytwentyfour;

import utils.days;

import java.io.FileNotFoundException;
import java.util.*;

public class dayFour extends days {
    private final static String year = "2024";
    private final static String day = "04";

    private final static ArrayList<String> lines = new ArrayList<>();

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
            lines.add(input.nextLine());
        }

        for (String line : lines) {
            answer += christmasFuture(line.split(""));
            answer += christmasFuture((new StringBuilder(line).reverse().toString()).split(""));
        }

        for (int i = lines.size(); i > 0; i--) {
            try {
                answer += christmasPast(lines.get(i).split(""), lines.get(i - 1).split(""), lines.get(i - 2).split(""), lines.get(i - 3).split(""));
            } catch (IndexOutOfBoundsException ignored) {

            }
        }

        for (int i = 0; i <= lines.size(); i++) {
            try {
                answer += christmasPast(lines.get(i).split(""), lines.get(i + 1).split(""), lines.get(i + 2).split(""), lines.get(i + 3).split(""));
            } catch (IndexOutOfBoundsException ignored) {

            }
        }

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        int answer = 0;

        for (int i = 1; i <= lines.size(); i++) {
            try {
                answer += christmasPresent(lines.get(i).split(""), lines.get(i - 1).split(""), lines.get(i + 1).split(""));
            } catch (IndexOutOfBoundsException ignored) {

            }
        }

        System.out.println("Puzzle Two: " + answer);
    }

    private static int christmasFuture(String[] lineArr) {
        int answer = 0;

        for (int i = 0; i <= lineArr.length; i++) {
            try {
                String letter = lineArr[i];
                StringJoiner joiner = new StringJoiner("");
                if (Objects.equals(joiner.add(letter).add(lineArr[i + 1]).add(lineArr[i + 2]).add(lineArr[i + 3]).toString(), "XMAS")) {
                    answer++;
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        }

        return answer;
    }

    private static int christmasPast(String[] lineOne, String[] lineTwo, String[] lineThree, String[] lineFour) {
        int answer = 0;

        for (int ii = 0; ii <= lineOne.length; ii++) {
            try {
                answer += christmasFuture(new String[]{lineOne[ii], lineTwo[ii], lineThree[ii], lineFour[ii]});
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                answer += christmasFuture(new String[]{lineOne[ii], lineTwo[ii + 1], lineThree[ii + 2], lineFour[ii + 3]});
            } catch (IndexOutOfBoundsException ignored) {
            }
            try {
                answer += christmasFuture(new String[]{lineOne[ii], lineTwo[ii - 1], lineThree[ii - 2], lineFour[ii - 3]});
            } catch (IndexOutOfBoundsException ignored) {
            }
        }

        return answer;
    }

    private static int christmasPresent(String[] lineOne, String[] lineTwo, String[] lineThree) {
        int answer = 0;
        for (int i = 0; i <= lineOne.length; i++) {
            try {
                if (lineOne[i].equals("A")) {
                    String topLeft = lineTwo[i - 1];
                    String btmLeft = lineThree[i - 1];
                    String topRight = lineTwo[i + 1];
                    String btmRight = lineThree[i + 1];
                    if (((topLeft.equals("M") && btmRight.equals("S")) && (topRight.equals("M") && btmLeft.equals("S")))) {
                        answer++;
                    } else if (((topLeft.equals("S") && btmRight.equals("M")) && (topRight.equals("S") && btmLeft.equals("M")))) {
                        answer++;
                    } else if (((topLeft.equals("M") && btmRight.equals("S")) && (topRight.equals("S") && btmLeft.equals("M")))) {
                        answer++;
                    } else if (((topLeft.equals("S") && btmRight.equals("M")) && (topRight.equals("M") && btmLeft.equals("S")))) {
                        answer++;
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        }

        return answer;
    }
}
