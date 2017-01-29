import com.algo.graphs.BipartiteGraph;
import com.algo.graphs.Graph;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class BiPartiteGraphTest {

    static Graph G = new Graph(7);

    @BeforeClass
    public static void init() {

        /*
            5 ---- 2 -- 0 --  1 ---- 6
                   |  `.    / |
                   |    `.'   |
                   |   /  `.  |
                   3 '      ` 4
        */

        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(1,3);
        G.addEdge(1,4);
        G.addEdge(1,6);
        G.addEdge(2,3);
        G.addEdge(2,4);
        G.addEdge(2,5);

        System.out.println(G);
    }

    @Test
    public void BiPartiteGraphTest() {
        BipartiteGraph B = new BipartiteGraph(G);
        System.out.println(B.visited());
        assertTrue(B.isBipartite());
    }

}
