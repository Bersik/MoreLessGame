package game.model;

import game.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Model class
 *
 * @author Serhii Kisilchuk
 */
public class Model {
    private static Random random = new Random();

    private int minNumber;
    private int maxNumber;
    /**
     * Random number
     */
    private int number;
    /**
     * Flag, that shows whether the game is over
     */
    private boolean finished;
    /**
     * User steps
     */
    private List<StepInfo> steps = new ArrayList<>();

    /**
     * Step in the game
     *
     * @param userNumber a number that user entered
     * @return if the game is over - 0, if {@code number} > {@code userNumber} - 1, else - -1
     */
    public int step(int userNumber) {
        if (!isBetween(userNumber))
            throw new IllegalArgumentException("userNumber should be between minNumber and maxNumber");

        StepInfo stepInfo = new StepInfo(minNumber, maxNumber, userNumber);
        steps.add(stepInfo);

        if (userNumber == number) {
            finished = true;
            return 0;
        }
        if ((minNumber <= userNumber) && (userNumber < number)) {
            minNumber = userNumber;
            return 1;
        } else {
            maxNumber = userNumber;
            return -1;
        }
    }

    /**
     * Generates a number in the given range [min,max] (without limits)
     *
     * @param min lower limit
     * @param max upper limit
     * @return generated number
     */
    public int rand(int min, int max) {
        return 1 + min + random.nextInt(max - min - 1);
    }

    /**
     * Generates a number in the given range [0,RAND_MAX] (including limits)
     *
     * @return generated number
     * @see Controller
     */
    public int rand() {
        return rand(0, Controller.RAND_MAX);
    }

    /**
     * Set generated number
     */
    public void generateNumber() {
        number = rand(minNumber, maxNumber);
    }

    public boolean isBetween(int num) {
        return (minNumber < num) && (num < maxNumber);
    }

    public int getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (!isBetween(number))
            throw new IllegalArgumentException("Number should be between minNumber and maxNumber");
        this.number = number;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public List<StepInfo> getSteps() {
        return steps;
    }

    public void setSteps(List<StepInfo> steps) {
        this.steps = steps;
    }
}
