import com.algo.strings.Misc;
import com.algo.strings.Permutations;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 20-Dec-2016.
 */
public class StringsTest {

    Misc m = new Misc();

    @Test
    public void permutations() {
        Permutations p = new Permutations();
        p.printPermutations("abcd");
    }

    @Test
    public void compressTest() {
        String str = "aabcccccaaa";
        assertEquals("a2b1c5a3", m.compress(str));
    }

    @Test
    public void reduceStringTest() {
        String s = "aabcccccddd";
        assertEquals("bcd", m.reduce(s));
        String s1 = "bccb";
        assertEquals("", m.reduce(s1));
    }

    @Test
    public void powerSet() {
        Permutations p = new Permutations();
        String str = "abc";
        p.powerSet(str);
    }
}
