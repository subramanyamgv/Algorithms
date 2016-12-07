import com.algo.Searching;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Subramanyam on 23-Nov-2016.
 */
public class SearchingTests {

    Searching s = new Searching();

    @Test
    public void binarySearchTest() {

        int [] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        assertTrue(s.binarySearch(a, 10));
        assertTrue(s.binarySearch(a, 40));
        assertTrue(s.binarySearch(a, 80));
        assertTrue(s.binarySearch(a, 100));
        assertFalse(s.binarySearch(a, 99));
    }

    @Test
    public void interpolationSearchTest() {

        int [] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        assertTrue(s.binarySearch(a, 10));
        assertTrue(s.binarySearch(a, 40));
        assertTrue(s.binarySearch(a, 80));
        assertTrue(s.binarySearch(a, 100));
        assertFalse(s.binarySearch(a, 99));
    }

    @Test
    public void findMinInCyclicSortedSeqTest() {

        int [] a = {50, 60, 70, 80, 90, 100, 10, 20, 30, 40};
        assertEquals(10, s.findMinInCyclicSortedSequence(a));

        int [] a1 = {90, 100, 10, 20, 30, 40, 50, 60, 70, 80};
        assertEquals(10, s.findMinInCyclicSortedSequence(a1));

    }

    @Test
    public void checkIndexAndNumberAreSameInSortedSequence() {

        int [] a = {-8, -5, -3, 3, 5, 10, 15, 22, 25, 27, 28};
        assertEquals(3, s.checkIndexAndNumberAreSameInSortedSequence(a));

        int [] a1 = {-8, -5, -3, 2, 5, 10, 15, 22, 25, 27, 28};
        assertEquals(-1, s.checkIndexAndNumberAreSameInSortedSequence(a1));

        int [] a2 = {-8, -5, -3, 2, 4, 10, 15, 22, 25, 27, 28};
        assertEquals(4, s.checkIndexAndNumberAreSameInSortedSequence(a2));

    }


}
