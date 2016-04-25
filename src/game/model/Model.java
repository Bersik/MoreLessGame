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
     * @return if the game is over - true, otherwise - false
     */
    public boolean step(int userNumber) {
        StepInfo stepInfo = new StepInfo(minNumber, maxNumber, userNumber);
        steps.add(stepInfo);

        if (userNumber == number) {
            finished = true;
            return true;
        }
        if ((minNumber <= userNumber) && (userNumber < number))
            minNumber = userNumber + 1;
        else
            maxNumber = userNumber - 1;
        return false;
    }

    /**
     * Generates a number in the given range [min,max] (including limits)
     *
     * @param min lower limit
     * @param max upper limit
     * @return generated number
     */
    public int rand(int min, int max) {
        return min + random.nextInt(max - min + 1);
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
