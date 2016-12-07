import com.algo.Number;
import com.algo.StringUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 30-Nov-2016.
 */
public class NumberTest {

    Number num = new Number();

    @Test
    public void multipleTests() {

        //Reverse test
        assertEquals(1, num.reverse(1));
        assertEquals(14, num.reverse(41));
        assertEquals(146, num.reverse(641));
        assertEquals(1462, num.reverse(2641));
        assertEquals(146254654, num.reverse(456452641));

        //Palindrome test
        assertEquals(true, num.isPalindrome(646, 646));
        assertEquals(false, num.isPalindrome(646, 6465));
        assertEquals(true, num.isPalindrome(6446, 6446));

        //Number of digits
        assertEquals(4, num.nDigits(4646));
        assertEquals(6, num.nDigits(464678));
        assertEquals(7, num.nDigits(4646782));

        //Number of digits a^b
        assertEquals(12, num.nDigits(5, 16));
        assertEquals(7, num.nDigits(4, 10));
        assertEquals(9, num.nDigits(4, 14));

    }

    @Test
         public void getKthDigitTest() {

        int n = 36492827;

        assertEquals(3, num.getKthDigit(n, 1));
        assertEquals(6, num.getKthDigit(n, 2));
        assertEquals(4, num.getKthDigit(n, 3));
        assertEquals(9, num.getKthDigit(n, 4));
        assertEquals(2, num.getKthDigit(n, 5));
        assertEquals(8, num.getKthDigit(n, 6));
        assertEquals(2, num.getKthDigit(n, 7));
        assertEquals(7, num.getKthDigit(n, 8));
    }

    @Test
    public void getNumberTest() {

        int n = 36492827;
        assertEquals(4928, num.getSubNumber(n, 3, 6));
    }

    @Test
    public void getLogNFactorial() {

        double sum = num.logNfactorial(10);

        assertTrue(true);
    }

    @Test
    public void binaryTest() {
        int N = 50;
        String result = num.binary(N);
        assertEquals("110010", result);
    }

}
