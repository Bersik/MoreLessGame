package game.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Bersik (Serhii Kisilchuk)
 */
public class ModelTest {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;

    private static Model model;

    @Before
    public void beforeClass() {
        model = new Model();
        model.setMinNumber(MIN_NUMBER);
        model.setMaxNumber(MAX_NUMBER);
    }

    @Test
    public void modelTestOneStep() throws Exception {
        final int NUMBER = 50;
        model.setNumber(NUMBER);
        assertTrue(model.isBetween(NUMBER));
        assertEquals(model.step(NUMBER), 0);
        assertTrue(model.isFinished());

        assertEquals(model.getSteps().size(), 1);
    }

    @Test
    public void modelTestThreeStep() throws Exception {
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
    public void modelExceptionZero() throws Exception {
        model.setNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void modelExceptionWithoutRange() throws Exception {
        model.setNumber(50);
        model.step(120);
    }


}
