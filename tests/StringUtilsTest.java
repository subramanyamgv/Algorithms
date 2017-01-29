import com.algo.StringUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 03-Dec-2016.
 */
public class StringUtilsTest {

    StringUtil su = new StringUtil();

    @Test
    public void reverseTest() {
        String str = "abcdef";

        String subStr = str.substring(1, 0);

        assertEquals("fedcba", su.reverse(str));
    }

}
