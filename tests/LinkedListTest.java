import com.algo.LinkedList;
import com.algo.Searching;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;


/**
 * Created by Subramanyam on 23-Nov-2016.
 */
public class LinkedListTest {

    LinkedList<Integer> s = new LinkedList<Integer>();

    @Test
    public void getTest() {

        int items[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        for (int item : items) {
            s.add(item);
        }

        assertEquals(Integer.valueOf(10), s.get(0));
        assertEquals(Integer.valueOf(20), s.get(1));
        assertEquals(Integer.valueOf(30), s.get(2));
        assertEquals(Integer.valueOf(40), s.get(3));
        assertEquals(Integer.valueOf(50), s.get(4));
        assertEquals(Integer.valueOf(90), s.get(8));
    }

    @Test
    public void getMiddleTest() {

        int items[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        for (int item : items) {s.add(item);}
        assertEquals(Integer.valueOf(50), s.getMiddle());

        s.clear();

        int items2[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160};
        for (int item : items2) {s.add(item);}
        assertEquals(Integer.valueOf(90), s.getMiddle());
    }

    @Test
    public void reverseTest() {

        int items[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        for (int item : items) {s.add(item);}

        s.reverse();

        int reverse[] = {90, 80, 70, 60, 50, 40, 30, 20, 10};
        for (int i = 0 ; i < reverse.length ; i++) {
            assertEquals(Integer.valueOf(reverse[i]), s.get(i));
        }
    }

    @Test
    public void mergeTest() {

        int items[] = {10, 30,  50, 70, 90};
        for (int item : items) {
            s.add(item);
        }

        LinkedList<Integer> s2 = new LinkedList<Integer>();
        int items2[] = {20, 40, 60, 80, 100};
        for (int item : items2) {
            s2.add(item);
        }

        s.merge(s2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    @Test
    public void getFromLastTest() throws Exception {

        s.init(new Integer[]{10});
        assertEquals(10, (int)s.getFromLast(1));

        s.init(new Integer[]{10, 20});
        assertEquals(20, (int) s.getFromLast(1));
        assertEquals(10, (int)s.getFromLast(2));

        s.init(new Integer[]{10, 20, 30, 40});
        assertEquals(40, (int)s.getFromLast(1));
        assertEquals(30, (int)s.getFromLast(2));
        assertEquals(20, (int)s.getFromLast(3));
        assertEquals(10, (int)s.getFromLast(4));
    }
}
