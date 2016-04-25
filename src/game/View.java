package game;

/**
 * View class
 *
 * @author Serhii Kisilchuk
 */
public class View {
    // Text's constants
    public static final String WELCOME_MESSAGE = "Welcome!";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String ENTERED_INT_DATA = "You entered the number ";
    public static final String NEXT_STEP_MESSAGE = "Take the next step. ";
    public static final String WRONG_INPUT_INT_DATA_RANGE = "Wrong input! INT value should include a range! Repeat please! ";
    public static final String STATISTIC_MESSAGE = "Your statistic:";

    public static final String WIN_MESSAGE = "You win! The conceived number was %d\n";
    public static final String INPUT_INT_DATA = "Input INT value between %d and %d: ";
    public static final String STATISTIC_MESSAGE_FORMAT = "%d) Range: [%d,%d]; your number: %d\n";
    public static final String COUNT_STEPS_MESSAGE = "You finished the game in %d steps\n";


    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void formatMessage(String message, Object... args) {
        System.out.format(message, args);
    }

}
