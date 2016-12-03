import com.algo.DynamicProgramming;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 02-Dec-2016.
 */
public class DPTest {

    DynamicProgramming dp = new DynamicProgramming();

    @Test
    public void fibonnaciTest() {

        assertEquals(55, dp.fibonacci(10));
    }
}
