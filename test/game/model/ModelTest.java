package game.model;

import game.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Bersik (Serhii Kisilchuk)
 */
public class ModelTest {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final int COUNT_ITERATION = 1000;
    private static final int RAND_MIN_NUMBER = 20;
    private static final int RAND_MAX_NUMBER = 50;

    private static Model model;

    @Before
    public void beforeClass() {
        model = new Model();
        model.setMinNumber(MIN_NUMBER);
        model.setMaxNumber(MAX_NUMBER);
    }

    @Test
    public void testModelTestOneStep() throws Exception {
        final int NUMBER = 50;
        model.setNumber(NUMBER);
        assertTrue(model.isBetween(NUMBER));
        assertEquals(model.step(NUMBER), 0);
        assertTrue(model.isFinished());

        assertEquals(model.getSteps().size(), 1);
    }

    @Test
    public void testModelTestThreeStep() throws Exception {
        final int NUMBER = 50;
        model.setNumber(NUMBER);
        //step 1
        assertTrue(model.isBetween(20));
        assertEquals(model.step(20), 1);
        assertFalse(model.isFinished());
        //step 2
        assertTrue(model.isBetween(70));
        assertEquals(model.step(70), -1);
        assertFalse(model.isFinished());
        //step 3
        assertTrue(model.isBetween(NUMBER));
        assertEquals(model.step(NUMBER), 0);
        assertTrue(model.isFinished());

        assertEquals(model.getSteps().size(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testModelExceptionZero() throws Exception {
        model.setNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testModelExceptionWithoutRange() throws Exception {
        model.setNumber(50);
        model.step(120);
    }

    @Test
    public void testModelRand() throws Exception {
        int number;
        for (int i = 0; i < COUNT_ITERATION; i++) {
            number = model.rand();
            assertTrue(number > 0);
            assertTrue(number < Constants.RAND_MAX);
        }
    }

    @Test
    public void testModelRandParameters() throws Exception {
        int number;
        for (int i = 0; i < COUNT_ITERATION; i++) {
            number = model.rand(RAND_MIN_NUMBER, RAND_MAX_NUMBER);
            assertTrue(number > RAND_MIN_NUMBER);
            assertTrue(number < RAND_MAX_NUMBER);
        }
    }
}
