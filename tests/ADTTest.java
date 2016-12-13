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
}
