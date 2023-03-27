import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Scores {
    private final ArrayList<Integer> nums;

    public Scores(String numbers) {
        nums = new ArrayList<>();
        Scanner scn = new Scanner(numbers);

        while (scn.hasNext()) {
            nums.add(scn.nextInt());
            if (scn.hasNext() && !scn.hasNextInt()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getNumScores() {
        return nums.size();
    }

    public int get(int index) {
        return nums.get(index);
    }

    public int getMax() {
        if (nums.size() == 0) {
            throw new NoSuchElementException();
        }

        int max = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > max) {
                max = nums.get(i);
            }
        }
        return max;
    }
}
