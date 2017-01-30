import com.algo.adt.Queue;
import com.algo.adt.Stack;
import com.algo.applications.QueueUsingStacks;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 07-Dec-2016.
 */
public class ADTTest {

    @Test
    public void queueUsingStacksTest() {

        QueueUsingStacks<Integer> qs = new QueueUsingStacks<Integer>();

        qs.offer(10);
        qs.offer(20);
        qs.offer(30);
        qs.offer(40);
        qs.offer(50);

        assertEquals(10, (int)qs.poll());
        assertEquals(20, (int)qs.poll());
        assertEquals(30, (int)qs.poll());
        assertEquals(40, (int)qs.poll());
        assertEquals(50, (int)qs.poll());

    }

    @Test
    public void stackTest() {

        int []input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Stack<Integer> stack = new Stack<Integer>();

        for (int a : input) {
            stack.push(a);
        }

        assertEquals(10, stack.size());

        int []output = new int[10];
        int i = 0;
        while(!stack.isEmpty()) {
            output[i++] = stack.pop();
        }

        int []expected = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        assertArrayEquals(expected, output);

    }

    @Test
    public void queueTest() {

        int []input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Queue<Integer> queue = new Queue<Integer>();

        for (int a : input) {
            queue.offer(a);
        }

        assertEquals(10, queue.size());

        int []output = new int[10];
        int i = 0;
        while(!queue.isEmpty()) {
            output[i++] = queue.poll();
        }

        int []expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, output);
    }
}
