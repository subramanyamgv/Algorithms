import com.algo.Arrays;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 02-Dec-2016.
 */
public class ArraysTest {

    Arrays arrays = new Arrays();

    @Test
    public void printAllStringsTest() {

        char a[] = {'a', 'b', 'c'};

        arrays.printAllStrings(a, 0, 3);
    }

    @Test
    public void findBalancedIndex2Test() {

        int []a = {10, 10, 2, -3, 6, 7, 10};

        assertEquals(1, arrays.findBalancedIndex2(a));
    }

    @Test
    public void reverseStringTest() {

        char []a = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

        arrays.reverse(a, 0, a.length - 1);

        assertEquals(new char[]{'f', 'e', 'd', 'c', 'b', 'a'}, a);
    }

    @Test
    public void evaluateExpression() {

        String exp = "(1+((20+3)*(432+54)))";

        assertEquals(11179, (int) arrays.evaluateExpression(exp));
    }

    @Test
    public void isExpressionBalanced() {

        String exp = "(1+((20+3)*(432+54)))";
        assertEquals(true, arrays.isExpressionBalanced(exp));

        String exp2 = "(1+(20+3)*(432+54)))";
        assertEquals(false, arrays.isExpressionBalanced(exp2));

        String exp3 = "(1+{[20+3]*[432+54]})";
        assertEquals(false, arrays.isExpressionBalanced2(exp3));
    }

    @Test
    public void insertLeftParenthesis() {

        String exp = "1+2)*3-4)*5-6)))";
        assertEquals("((1+2)*((3-4)*(5-6)))", arrays.insertLeftParentheses(exp));

        String exp2 = "1234+265)*32-24)*8985-23566)))";
        assertEquals("((1234+265)*((32-24)*(8985-23566)))", arrays.insertLeftParentheses(exp2));
    }

    @Test
    public void randomShuffleTest() {

        int []a = {1, 2, 3, 4, 5, 6};
        arrays.randomShuffle(a);
    }
}
