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
            ScoreZ scores = new ScoreZ("");
            scores.get(0);
        });
    }

    @Test public void doubleScores() {
        assertThrows(InputMismatchException.class, () -> {
            ScoreZ scores = new ScoreZ("2 4 16.09 32");
            scores.get(3);
        });
    }

    @Test public void negativeScores() {
        ScoreZ scores = new ScoreZ("2 4 16 -32");
        assertEquals(-32,scores.get(3));
    }

    @Test public void nullScores() {
        assertThrows(NullPointerException.class, () -> {
            ScoreZ scores = new ScoreZ(null);
            scores.get(0);
        });
    }

    @Test public void validNumScores() {
        ScoreZ scores = new ScoreZ("2 4 16 32");
        assertEquals(4,scores.getNumScores());
    }

    @Test public void validGet() {
        ScoreZ scores = new ScoreZ("2 4 16 32");
        assertEquals(32,scores.get(3));
    }
    
    /*
     * getMax() tests
     */

    @Test public void emptyMax() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ScoreZ scores = new ScoreZ("");
            scores.get(0);
        });
    }

    @Test public void validMax() {
        ScoreZ scores = new ScoreZ("2 4 16 32");
        assertEquals(32,scores.getMax());
    }
}
