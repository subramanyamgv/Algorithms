import com.algo.BST;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Subramanyam on 29-Nov-2016.
 */
public class BstTest {

    BST<Integer> bst = new BST<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    @Test
    public void findTest() {

        bst.init(new Integer[]{8, 3, 10, 1, 6, 14, 4, 7, 13});

        assertEquals(8, (int) bst.find(8));
        assertEquals(3, (int) bst.find(3));
        assertEquals(10, (int) bst.find(10));
        assertEquals(1, (int) bst.find(1));
        assertEquals(6, (int) bst.find(6));
        assertEquals(14, (int) bst.find(14));
        assertEquals(4, (int) bst.find(4));
        assertEquals(7, (int) bst.find(7));
        assertEquals(13, (int)bst.find(13));

        assertEquals(8, (int)bst.findRecursive(8));
        assertEquals(3, (int)bst.findRecursive(3));
        assertEquals(10, (int)bst.findRecursive(10));
        assertEquals(1, (int)bst.findRecursive(1));
        assertEquals(6, (int)bst.findRecursive(6));
        assertEquals(14, (int)bst.findRecursive(14));
        assertEquals(4, (int)bst.findRecursive(4));
        assertEquals(7, (int)bst.findRecursive(7));
        assertEquals(13, (int)bst.findRecursive(13));
    }

    @Test
    public void inorderTreeIteratorTest() {

        bst.init(new Integer[]{8, 3, 10, 1, 6, 14, 4, 7, 13});

        Iterator<Integer> itr = bst.getIterator(BST.TRAVERSAL.INORDER);

        int[] inorder = new int[9];
        int count = 0;
        while (itr.hasNext()) {
            inorder[count++] = itr.next();
        }

        assertArrayEquals(inorder, new int[]{1, 3, 4, 6, 7, 8, 10, 13, 14});
    }

    @Test
    public void preorderTreeIteratorTest() {

        bst.init(new Integer[]{8, 3, 10, 1, 6, 14, 4, 7, 13});

        Iterator<Integer> itr = bst.getIterator(BST.TRAVERSAL.PREORDER);

        int[] preorder = new int[9];
        int count = 0;
        while (itr.hasNext()) {
            preorder[count++] = itr.next();
        }

        assertArrayEquals(preorder, new int[]{8, 3, 1, 6, 4, 7, 10, 14, 13});
    }

    @Test
    public void levelorderTreeIteratorTest() {
        bst.init(new Integer[]{8, 3, 10, 1, 6, 14, 4, 7, 13});

        Iterator<Integer> itr = bst.getIterator(BST.TRAVERSAL.LEVELORDER);

        int[] levelorder = new int[9];
        int count = 0;
        while (itr.hasNext()) {
            levelorder[count++] = itr.next();
        }

        assertArrayEquals(levelorder, new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13});
    }
}
