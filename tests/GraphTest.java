import com.algo.graphs.ConnectedComponents;
import com.algo.graphs.DepthFirstSearch;
import com.algo.graphs.Graph;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class GraphTest {

    static Graph G = new Graph(13);

    @BeforeClass
    public static void init() {

        //     (0)------ (6)       (7)---(8)
        //     /|\        |
        //    / | \       |
        //   / (1)(2)     |        (9)---(10)
        // (5)---------- (4)      /  \
        //   \          /        /    \
        //    `-(3)- '        (11)---(12)

        G.addEdge(0,5);
        G.addEdge(4,3);
        G.addEdge(0,1);
        G.addEdge(9,12);
        G.addEdge(6,4);
        G.addEdge(5,4);
        G.addEdge(0,2);
        G.addEdge(11,12);
        G.addEdge(9,12);
        G.addEdge(0,6);
        G.addEdge(7,8);
        G.addEdge(9,11);
        G.addEdge(9,7);
        G.addEdge(5,3);

//        System.out.println(G);

    }

    @Test
    public void DFSTest() {
        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
        System.out.println(dfs.visited());
    }

    @Test
    public void ConnectedComponentsTest() {
        ConnectedComponents cc = new ConnectedComponents(G);
        assertEquals(3, cc.count());
    }

}