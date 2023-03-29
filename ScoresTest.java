import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests the Scores class
 */
public class ScoresTest {
    /**
     * Creates a scores class with only positive integers as scores
     */
   @Test public void positiveScores() {
       Scores scores = new Scores("5 2 18 90 120");
       assertEquals(90, scores.get(3));
   }

    /**
     * Creates a scores class with only positive scores
     */
    @Test public void negativeScores() {
        Scores scores = new Scores("2 4 16 -32");
        assertEquals(-32,scores.get(3));
    }

    /**
     * Creates a scores class with positive and negative scores
     */
    @Test public void posAndNegScores() {
       Scores scores = new Scores("-2 -1 1 2");
       assertEquals(2, scores.get(3));
    }

    /**
     * Creates a scores class with large positive numbers
     */
    @Test public void largeNumbers() {
       Scores scores = new Scores("1000 10000 100000 1000000 10000000");
       assertEquals(1000000, scores.get(3));
    }

    /**
     * Creates a scores class with large negative numbers
     */
    @Test public void smallNumbers() {
       Scores scores = new Scores("-1000 -10000 -100000 -1000000 -10000000");
       assertEquals(-10000, scores.get(1));
    }

    /**
     * Creates a scores class that tries to throw an exception by getting a number out of bounds
     */
    @Test public void invalidGet() {
        String numbers9 = "0 1 2 3 4";
        Scores newScores = new Scores(numbers9);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            int indexValue = newScores.get(7);
        });
    }

    /**
     * Creates an empty scores class that tries to throw an IndexOutOfBoundsException by getting a number out of bounds
     */
    @Test public void emptyScores() {
        Scores scores = new Scores("");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            scores.get(0);
        });
    }

    /**
     * Creates a scores class that includes doubles and tries to throw an IllegalArgumentException
     */
    @Test public void doubleScores() {
        assertThrows(IllegalArgumentException.class, () -> {
            Scores scores = new Scores("2 4 16.09 32");
        });
    }

    /**
     * Creates a scores class that includes strings and tries to throw an IllegalArgumentException
     */
    @Test public void stringLitScores() {
        String numbers3 = "45 10 23 iffy 12 73";
        assertThrows(IllegalArgumentException.class, () -> {
            Scores newScores = new Scores(numbers3);
        });
    }

    /**
     * Creates a scores class that includes characters and tries to throw an IllegalArgumentException
     */
    @Test public void charsScores() {
        String numbers5 = "83 76& 03, 6^3";
        assertThrows(IllegalArgumentException.class, () -> {
            Scores newScores = new Scores(numbers5);
        });
    }

    /**
     * Creates a scores class that includes characters and tests the number of scores
     */
    @Test public void validNumScores() {
        Scores scores = new Scores("2 4 16 32");
        assertEquals(4,scores.getNumScores());
    }

    /**
     * Creates a scores class that includes newlines in the string used in the scores constructor
     */
    @Test public void ctorTestNewlines() {
        String numbers7 = "54 82 43 21 \n" +
                "76 33 26 90 \n" +
                "45 89 01 1";

        Scores newScores = new Scores(numbers7);
        assertEquals(12, newScores.getNumScores());
    }

    /**
     * Creates a scores class that includes broken up strings added together and used in the scores constructor
     */
    @Test public void ctorTestBrokenString() {
       String numbers = "2 34 61 -13 -27 " +
               "12 32 16 9 67 " +
               "43 87 103 91 ";

       Scores scores = new Scores(numbers);
       assertEquals(14, scores.getNumScores());
    }

    /**
     * Creates a scores class that includes broken up strings added together and tests the number of scores
     */
    @Test public void ctorTestBrokenStringNWS() {
       String numbers = "2034 803 -872 90" +
               "21 456 -232 -1098 19" +
               "0 123";
       Scores scores = new Scores(numbers);
       assertEquals(9, scores.getNumScores());
    }

    /**
     * Tests to see if an integer larger than the possible maximum integer can be passed through the Scores constructor
     * and added to the nums ArrayList
     */
    @Test public void OOBInteger() {
        String numbers = "2147483648";
        assertThrows(IllegalArgumentException.class, () -> {
            Scores newScores = new Scores(numbers);
        });
    }

    /**
     * Tests to see if an integer smaller than the possible minimum integer can be passed through the Scores constructor
     * and added to the nums ArrayList
     */
    @Test public void OOBInteger2() {
        String numbers = "-2147483649";
        assertThrows(IllegalArgumentException.class, () -> {
            Scores newScores = new Scores(numbers);
        });
    }
    
    /*
     * getMax() tests
     */

    /**
     * Establishes a new Scores class with an empty String argument and attempts to retrieve the maximum value from the nums ArrayList
     */
    @Test public void emptyMax() {
        Scores scores = new Scores("");
        assertThrows(NoSuchElementException.class, () -> {
            scores.getMax();
        });
    }

    /**
     * Establishes a new Scores class and invokes the getMax() method to ensure that the maximum is located at the 0th index
     * of the nums ArrayList
     */
    @Test public void maxTestBeginning() {
        Scores scores = new Scores("120000 32 74 -23 65");
        int maxValue = scores.getMax();
        assertEquals(120000, maxValue);
    }

    /**
     * Establishes a new Scores class with positive and negative values in the String and invokes the getMax() method to ensure
     * the proper value is found to be 74 (at index 1)
     */
    @Test public void maxTestMiddle() {
        Scores scores = new Scores("-20 74 32 -23 65");
        int maxValue = scores.getMax();
        assertEquals(scores.get(1), maxValue);
    }

    /**
     * Similar to above test, except that maxValue should correspond to the value located at index 2 in the ArrayList
     */
    @Test public void maxTestMiddle2() {
        Scores scores = new Scores("30 11 89 -9 20");
        int maxValue = scores.getMax();
        assertEquals(scores.get(2), maxValue);
    }

    /**
     * Similar to above tests, except with numbers of higher absolute value, and the max value should correspond to the
     * value at index 3 in the ArrayList
     */
    @Test public void maxTestMiddle3() {
        Scores scores = new Scores("190321 894012 -86432 1297893 -0732");
        int maxValues = scores.getMax();
        assertEquals(scores.get(3), maxValues);
    }

    /**
     * Establishes a new Scores class and invokes the getMax() method to ensure that the max value occurs at the
     * last index of the nums ArrayList
     */
    @Test public void maxTestEnd() {
        Scores scores = new Scores("65 32 74 -23 120000");
        int maxValue = scores.getMax();
        assertEquals(scores.get(scores.getNumScores()-1), maxValue);
    }

    /**
     * Tests the getMax() method to see if it returns a single negative value
     */
    @Test public void maxTestSingleScore() {
        String numbers = "-9999999";
        Scores newScores = new Scores(numbers);
        int max = newScores.getMax();
        assertEquals(-9999999, max);
    }

    /**
     * Tests the getMax() method to ensure that there are no errors when passing newline characters in the
     * String argument over to the ArrayList
     */
    @Test public void maxTestNewLine() {
        Scores scores = new Scores("1 2 3 \n 4 5");
        int maxValue = scores.getMax();
        assertEquals(5, maxValue);
    }

    /**
     * Tests to see if getMax() returns the proper value for a broken String argument in the Scores constructor
     * with no whitespaces (i.e. a [5" + "6] should equate to an integer of 56 added to the nums ArrayList)
     */
    @Test public void maxTestBrokenStringNWS() {
        String numbers = "1 2 3 4 5" +
                "6 7 8 9 10";
        Scores scores = new Scores(numbers);
        int maxValue = scores.getMax();
        assertEquals(56, maxValue);
    }

    /**
     * Tests to see if a String argument containing the maximum possible integer value can have it be caught
     * by the getMax() method
     */
    @Test public void getMaxTestMaxInteger() {
        String numbers = "3 5 -0 87 2147483647 -60 -97 -121 103";
        Scores newScores = new Scores(numbers);
        int max = newScores.getMax();
        assertEquals(Integer.MAX_VALUE, max);
    }

    /**
     * Tests to see if a String argument containing the minimum possible integer value can have it be caught by
     * the getMax() method
     */
    @Test public void getMaxTestMinInteger() {
        String numbers = "-2147483648";
        Scores newScores = new Scores(numbers);
        int max = newScores.getMax();
        assertEquals(Integer.MIN_VALUE, max);
    }

}
