package twentytwentytwo;

import utils.days;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dayFive extends days {
    private final static String year = "2022";
    private final static String day = "05";
    private final static Map<Integer, String> stackOne = new HashMap<>();
    private final static Map<Integer, String> stackTwo = new HashMap<>();
    private final static Map<Integer, String> stackThree = new HashMap<>();
    private final static Map<Integer, String> stackFour = new HashMap<>();
    private final static Map<Integer, String> stackFive = new HashMap<>();
    private final static Map<Integer, String> stackSix = new HashMap<>();
    private final static Map<Integer, String> stackSeven = new HashMap<>();
    private final static Map<Integer, String> stackEight = new HashMap<>();
    private final static Map<Integer, String> stackNine = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Running day " + day + " puzzles");
        days.refreshScanner(year, day);
        puzzleOne();
        days.refreshScanner(year, day);
        puzzleTwo();
        System.out.println("END");
    }

    private static void puzzleOne() {
        populateStacks();
        String answer;
        int lineNumber = 1;

        while (input.hasNextLine()) {
            while (lineNumber < 11) {
                input.nextLine();
                lineNumber++;
            }
            final String line = input.nextLine();
            final String[] command = line.split(" ");
            
            for (int i = 0; i < Integer.parseInt(command[1]); i++) {
                final String box = getBoxFromStack(Integer.parseInt(command[3]));
                putBoxOnStack(box, Integer.parseInt(command[5]));
            }
        }

        answer = getTopBoxes();

        System.out.println("Puzzle One: " + answer);
    }

    private static void puzzleTwo() {
        populateStacks();
        String answer;
        int lineNumber = 1;

        while (input.hasNextLine()) {
            while (lineNumber < 11) {
                input.nextLine();
                lineNumber++;
            }
            final String line = input.nextLine();
            final String[] command = line.split(" ");

            if (Integer.parseInt(command[1]) == 1) {
                final String box = getBoxFromStack(Integer.parseInt(command[3]));
                putBoxOnStack(box, Integer.parseInt(command[5]));
            } else {
                final Map<Integer, String> boxes = new HashMap<>();
                for (int i = Integer.parseInt(command[1]); i > 0; i--) {
                    boxes.put(i, getBoxFromStack(Integer.parseInt(command[3])));
                }
                for (String box : boxes.values()) {
                    putBoxOnStack(box, Integer.parseInt(command[5]));
                }
            }
        }

        answer = getTopBoxes();

        System.out.println("Puzzle Two: " + answer);
    }
    
    private static String getBoxFromStack(final int stack) {
        String box;
        if (stack == 1) {
            box = stackOne.get(stackOne.size());
            stackOne.remove(stackOne.size());
            return box;
        } else if (stack == 2) {
            box = stackTwo.get(stackTwo.size());
            stackTwo.remove(stackTwo.size());
            return box;
        } else if (stack == 3) {
            box = stackThree.get(stackThree.size());
            stackThree.remove(stackThree.size());
            return box;
        } else if (stack == 4) {
            box = stackFour.get(stackFour.size());
            stackFour.remove(stackFour.size());
            return box;
        } else if (stack == 5) {
            box = stackFive.get(stackFive.size());
            stackFive.remove(stackFive.size());
            return box;
        } else if (stack == 6) {
            box = stackSix.get(stackSix.size());
            stackSix.remove(stackSix.size());
            return box;
        } else if (stack == 7) {
            box = stackSeven.get(stackSeven.size());
            stackSeven.remove(stackSeven.size());
            return box;
        } else if (stack == 8) {
            box = stackEight.get(stackEight.size());
            stackEight.remove(stackEight.size());
            return box;
        } else if (stack == 9) {
            box = stackNine.get(stackNine.size());
            stackNine.remove(stackNine.size());
            return box;
        }
        
        return "Z";
    }

    private static void putBoxOnStack(final String box, final int stack) {
        if (stack == 1) {
            stackOne.put(stackOne.size() + 1, box);
        } else if (stack == 2) {
            stackTwo.put(stackTwo.size() + 1, box);
        } else if (stack == 3) {
            stackThree.put(stackThree.size() + 1, box);
        } else if (stack == 4) {
            stackFour.put(stackFour.size() + 1, box);
        } else if (stack == 5) {
            stackFive.put(stackFive.size() + 1, box);
        } else if (stack == 6) {
            stackSix.put(stackSix.size() + 1, box);
        } else if (stack == 7) {
            stackSeven.put(stackSeven.size() + 1, box);
        } else if (stack == 8) {
            stackEight.put(stackEight.size() + 1, box);
        } else if (stack == 9) {
            stackNine.put(stackNine.size() + 1, box);
        }
    }

    private static String getTopBoxes() {
        return stackOne.get(stackOne.size()) +
                stackTwo.get(stackTwo.size()) +
                stackThree.get(stackThree.size()) +
                stackFour.get(stackFour.size()) +
                stackFive.get(stackFive.size()) +
                stackSix.get(stackSix.size()) +
                stackSeven.get(stackSeven.size()) +
                stackEight.get(stackEight.size()) +
                stackNine.get(stackNine.size());
    }
    
    private static void populateStacks() {
        stackOne.clear();
        stackTwo.clear();
        stackThree.clear();
        stackFour.clear();
        stackFive.clear();
        stackSix.clear();
        stackSeven.clear();
        stackEight.clear();
        stackNine.clear();
        stackOne.put(1, "D");
        stackOne.put(2, "L");
        stackOne.put(3, "V");
        stackOne.put(4, "T");
        stackOne.put(5, "M");
        stackOne.put(6, "H");
        stackOne.put(7, "F");
        stackTwo.put(1, "H");
        stackTwo.put(2, "Q");
        stackTwo.put(3, "G");
        stackTwo.put(4, "J");
        stackTwo.put(5, "C");
        stackTwo.put(6, "T");
        stackTwo.put(7, "N");
        stackTwo.put(8, "P");
        stackThree.put(1, "R");
        stackThree.put(2, "S");
        stackThree.put(3, "D");
        stackThree.put(4, "M");
        stackThree.put(5, "P");
        stackThree.put(6, "H");
        stackFour.put(1, "L");
        stackFour.put(2, "B");
        stackFour.put(3, "V");
        stackFour.put(4, "F");
        stackFive.put(1, "N");
        stackFive.put(2, "H");
        stackFive.put(3, "G");
        stackFive.put(4, "L");
        stackFive.put(5, "Q");
        stackSix.put(1, "W");
        stackSix.put(2, "B");
        stackSix.put(3, "D");
        stackSix.put(4, "G");
        stackSix.put(5, "R");
        stackSix.put(6, "M");
        stackSix.put(7, "P");
        stackSeven.put(1, "G");
        stackSeven.put(2, "M");
        stackSeven.put(3, "N");
        stackSeven.put(4, "R");
        stackSeven.put(5, "C");
        stackSeven.put(6, "H");
        stackSeven.put(7, "L");
        stackSeven.put(8, "Q");
        stackEight.put(1, "C");
        stackEight.put(2, "L");
        stackEight.put(3, "W");
        stackNine.put(1, "R");
        stackNine.put(2, "D");
        stackNine.put(3, "L");
        stackNine.put(4, "Q");
        stackNine.put(5, "J");
        stackNine.put(6, "Z");
        stackNine.put(7, "M");
        stackNine.put(8, "T");
    }
}
