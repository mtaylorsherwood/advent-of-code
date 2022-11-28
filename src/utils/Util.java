package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {
    public static Scanner getInputAsScanner(final String year, final String day) throws FileNotFoundException {
        final String fileLoc = "C:\\development\\advent-of-code\\inputs\\" + "\\" + year + "\\" + day + "\\input.txt";

        final File inputFile = new File(fileLoc);

        if (!inputFile.exists()) {
            throw new FileNotFoundException("Input file not found.");
        }

        return new Scanner(inputFile);
    }
}
