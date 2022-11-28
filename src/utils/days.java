package utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class days {
    protected static Scanner input;

    protected static void refreshScanner(final String year, final String day) throws FileNotFoundException {
        input = Util.getInputAsScanner(year, day);
    }
}
