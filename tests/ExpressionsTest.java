import com.algo.expressions.Postfix;
import com.algo.expressions.PostfixParseTree;
import com.algo.expressions.Prefix;
import com.algo.expressions.PrefixParseTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Subramanyam on 07-Dec-2016.
 */
public class ExpressionsTest {

    Prefix prefix = new Prefix();
    Postfix postfix = new Postfix();

    @Test
    public void InfixToPostfixTest() {

        postfix.fromInfix("(((a+b)*c)-d)");
        assertEquals("ab+c*d-", postfix.getExpression());

        postfix.fromInfix("(((a+b)*(c-d))/e)");
        assertEquals("ab+cd-*e/", postfix.getExpression());
    }

    @Test
    public void InfixToPrefixTest() {

        prefix.fromInfix("(((a+b)*c)-d)");
        assertEquals("-*+abcd", prefix.getExpression());

        prefix.fromInfix("(((a+b)*(c-d))/e)");
        assertEquals("/*+ab-cde", prefix.getExpression());
    }

    @Test
    public void postfixEvaluation() {
        postfix.setExpression("23+5*4-");
        assertTrue((21 - postfix.eval()) == 0.0);

        postfix.setExpression("23+64-*2/");
        assertTrue((5 - postfix.eval()) == 0.0);
    }

    @Test
    public void prefixEvaluation() {
        prefix.setExpression("-*+2354");
        assertTrue((21 - prefix.eval()) == 0.0);

        prefix.setExpression("/*+23-642");
        assertTrue((5 - prefix.eval()) == 0.0);
    }

    @Test
    public void prefixParseTree() {
        PrefixParseTree pt = new PrefixParseTree("/*+23-642");
        PrefixParseTree.TreeNode root = pt.construct();
        pt.print(root);
    }

    @Test
    public void postfixParseTree() {
        PostfixParseTree pt = new PostfixParseTree("23+64-*2/");
        PostfixParseTree.TreeNode root = pt.construct();
        pt.print(root);
    }

}
