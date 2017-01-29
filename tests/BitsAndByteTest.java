import com.algo.BitsAndBytes;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 23-Dec-2016.
 */
public class BitsAndByteTest {

    BitsAndBytes bitsAndBytes = new BitsAndBytes();

    @Test
    public void reverseTest() {
        assertEquals(242, bitsAndBytes.reverseBits(79));
    }
}
