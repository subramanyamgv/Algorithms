import com.algo.graphs.Graph;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class GraphPathsTest {

    static Graph G = new Graph(6);

    @BeforeClass
    public static void init() {

        //    (0)---------(2)
        //     | \     /   | \
        //     |  \  /     |  \
        //     |  (1)      |   \
        //    (5)-------- (3)--(4)

        G.addEdge(0,5);
        G.addEdge(2,4);
        G.addEdge(2,3);
        G.addEdge(1,2);
        G.addEdge(0,1);
        G.addEdge(3,4);
        G.addEdge(3,5);
        G.addEdge(0,2);

        System.out.println(G);
    }

    @Test
    public void BFSTest() {

    }

}
