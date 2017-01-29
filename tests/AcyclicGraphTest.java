import com.algo.graphs.AcyclicGraph;
import com.algo.graphs.Graph;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class AcyclicGraphTest {

    static Graph G = new Graph(6);

    @BeforeClass
    public static void init() {

        /*
            (1) ----(0)------(5)
             |                |
             |                |
            (2)-----(3)------(4)
        */

        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(3,4);
        G.addEdge(4,5);
        G.addEdge(5,0);

//        System.out.println(G);
    }

    @Test
    public void AcyclicGraphTest() {
        AcyclicGraph A = new AcyclicGraph(G);
        assertTrue(A.hasCycle());
    }

}
