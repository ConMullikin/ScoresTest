import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Scores {
    private final ArrayList<Integer> nums;

    /**
     * @param numbers should be a String with zero or more whitespace-delimited integers.
     *                Each integer is a score. This class holds the list of scores parsed from the String.
     * @throws IllegalArgumentException if numbers is not a whitespace-delimited list of zero or more integers.
     */
    public Scores(String numbers) throws IllegalArgumentException {
        nums = new ArrayList<>();
    }

    /**
     * @return the number of scores in this object i.e. the number of integers in the String given to the constructor
     */
    public int getNumScores() { return -1; }

    /**
     * @param index An integer index in the range [0, getNumScores())
     * @return The score at the specified index. For example, the first score in the String is at index 0.
     */
    public int get(int index) { return -1; }

    /**
     * @return the maximum score stored in this object
     * @throws java.util.NoSuchElementException if there are no scores
     */
    public int getMax() throws NoSuchElementException { return -1; }
}
