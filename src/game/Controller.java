package game;

import game.model.Model;
import game.model.StepInfo;

import java.util.List;
import java.util.Scanner;

/**
 * Controller class
 *
 * @author Serhii Kisilchuk
 */
public class Controller {
    // The Constants
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 100;
    public static final int RAND_MAX = 100;

    private Scanner sc = new Scanner(System.in);

    // Constructor
    Model model;
    View view;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * The Work method
     */
    public void playGame() {
        initModel();
        view.printlnMessage(View.WELCOME_MESSAGE);
        while (true) {
            int number = inputIntValueWithScanner(model.getMinNumber(), model.getMaxNumber());
            view.printlnMessage(View.ENTERED_INT_DATA + number);
            int step = model.step(number);
            if (step == 0) {
                view.formatMessage(View.WIN_MESSAGE, model.getNumber());

                showUserSteps(model.getSteps());
                break;
            } else {
                if (step == 1)
                    view.printMessage(View.MORE_MESSAGE);
                else
                    view.printMessage(View.LESS_MESSAGE);
                view.printMessage(View.NEXT_STEP_MESSAGE);
            }
        }
    }

    /**
     * Model initialization before the game
     */
    public void initModel() {
        model.setFinished(false);
        model.setMinNumber(MIN_NUMBER);
        model.setMaxNumber(MAX_NUMBER);
        model.generateNumber();
    }

    // The Utility methods

    /**
     * Input int value from range [min,max] from scanner
     *
     * @param min min number in range
     * @param max max number in range
     * @return entered int value
     */
    public int inputIntValueWithScanner(int min, int max) {
        view.formatMessage(View.INPUT_INT_DATA, min, max);
        int num;
        while (true) {
            if (!sc.hasNextInt()) {
                view.formatMessage(View.WRONG_INPUT_INT_DATA + View.INPUT_INT_DATA, min, max);
                sc.next();
            } else {
                num = sc.nextInt();
                if (isBetween(num, model.getMinNumber(), model.getMaxNumber()))
                    break;
                else {
                    view.formatMessage(View.WRONG_INPUT_INT_DATA_RANGE + View.INPUT_INT_DATA, min, max);
                }
            }
        }
        return num;
    }

    /**
     * Show user steps (statistic)
     *
     * @param userSteps list of user steps
     */
    public void showUserSteps(List<StepInfo> userSteps) {
        view.printlnMessage(View.STATISTIC_MESSAGE);
        int index = 1;
        for (StepInfo stepInfo : userSteps) {
            view.formatMessage(View.STATISTIC_MESSAGE_FORMAT, index++, stepInfo.getMinNumber(), stepInfo.getMaxNumber(),
                    stepInfo.getUserNumber());
        }
        view.formatMessage(View.COUNT_STEPS_MESSAGE, model.getSteps().size());
    }

    public static boolean isBetween(int num, int min, int max) {
        return (min < num) && (num < max);
    }
}
