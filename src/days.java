import java.io.FileNotFoundException;
import java.util.Scanner;

public class days {
    protected static Scanner input;

    protected static void refreshScanner(final String day) throws FileNotFoundException {
        input = Util.getInputAsScanner(day);
    }
}
