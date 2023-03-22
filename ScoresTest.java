import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoresTest {
    /*
     * Constructor tests using numScores() and get()
     */

    @Test public void emptyScores() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Scores scores = new Scores("");
            scores.get(0);
        });
    }

    @Test public void doubleScores() {
        assertThrows(InputMismatchException.class, () -> {
            Scores scores = new Scores("2 4 16.09 32");
            scores.get(3);
        });
    }

    @Test public void negativeScores() {
        Scores scores = new Scores("2 4 16 -32");
        assertEquals(-32,scores.get(3));
    }

    @Test public void ctorTestStringLit() {
        String numbers3 = "45 10 23 iffy 12 73";
        assertThrows(InputMismatchException.class, () -> {
            Scores newScores = new Scores(numbers3);
        });
    }

    @Test public void ctorTestChars() {
        String numbers5 = "83 76& 03, 6^3";
        assertThrows(InputMismatchException.class, () -> {
            Scores newScores = new Scores(numbers5);
        });
    }

    @Test public void ctorTestNewlines() {
        String numbers7 = "54 82 43 21 \n" +
                "76 33 26 90 \n" +
                "45 89 01 1";

        Scores newScores = new Scores(numbers7);
        assertEquals(12, newScores.getNumScores());
    }

    @Test public void nullScores() {
        assertThrows(NullPointerException.class, () -> {
            Scores scores = new Scores(null);
            scores.get(0);
        });
    }

    @Test public void validNumScores() {
        Scores scores = new Scores("2 4 16 32");
        assertEquals(4,scores.getNumScores());
    }

    @Test public void validGet() {
        Scores scores = new Scores("2 4 16 32");
        assertEquals(32,scores.get(3));
    }

    @Test public void getTestOOB() {
        String numbers9 = "0 1 2 3 4";
        Scores newScores = new Scores(numbers9);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            int indexValue = newScores.get(7);
        });
    }
    
    /*
     * getMax() tests
     */

    @Test public void emptyMax() {   //Throws IndexOutOfBoundException; want NoSuchElementException
        assertThrows(NoSuchElementException.class, () -> {
            Scores scores = new Scores("");
            scores.getMax();
        });
    }

    @Test public void maxTestBeginning() {
        Scores scores = new Scores("120000 32 74 -23 65");
        int maxValue = scores.getMax();
        assertEquals(120000,scores.get(0));
    }

    @Test public void maxTestMiddle() {
        Scores scores = new Scores("120000 32 74 -23 65");
        int maxValue = scores.getMax();
        assertEquals(74,scores.get(2));
    }

    @Test public void maxTestEnd() {
        Scores scores = new Scores("120000 32 74 -23 65");
        int maxValue = scores.getMax();
        assertEquals(65,scores.get(4));
    }
}
