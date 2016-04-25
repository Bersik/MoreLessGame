package game.model;

/**
 * Class for to store information about each user step
 *
 * @author Serhii Kisilchuk
 */
public class StepInfo {
    /**
     * Min number in range
     */
    private int minNumber;
    /**
     * Max number in range
     */
    private int maxNumber;
    /**
     * User number
     */
    private int userNumber;

    public StepInfo(int minNumber, int maxNumber, int userNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.userNumber = userNumber;
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

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return "StepInfo{" +
                "minNumber=" + minNumber +
                ", maxNumber=" + maxNumber +
                ", userNumber=" + userNumber +
                '}';
    }
}
