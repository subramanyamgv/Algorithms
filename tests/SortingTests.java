import com.algo.Sorting;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 23-Nov-2016.
 */
public class SortingTests {

    Sorting sorting = new Sorting();

    @Test
    public void insertingTest() {

        int [] a = {8, 2, 4, 9, 3, 6};
        int [] sorted = sorting.insertion(a);

        int[]expected = {2, 3, 4, 6, 8, 9};
        assertArrayEquals(expected, a);
    }

    @Test
    public void mergeTest() {

        int []a = {1, 3, 5};
        int []b = {2, 4, 6, 8, 10, 11};

        int [] merged = sorting.merge(a, b);

        int[]expected = {1, 2, 3, 4, 5, 6, 8, 10, 11};
        assertArrayEquals(expected, merged);
    }
}
