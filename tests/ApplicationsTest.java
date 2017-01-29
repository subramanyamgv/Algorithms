import com.algo.applications.FileSystemTraversal;
import com.algo.applications.ProducerConsumer;
import org.junit.Test;

import java.io.File;


/**
 * Created by Subramanyam on 07-Dec-2016.
 */
public class ApplicationsTest {

    @Test
    public void printFileSystemTreeRecursive() {

        FileSystemTraversal apps = new FileSystemTraversal();

//        apps.printFileSystemTree(new File("C:\\Users\\Subramanyam\\Dropbox\\Ebooks"));
        apps.printFileSystemTreeRecursive(new File("C:\\Users\\Subramanyam\\Dropbox\\Ebooks"), 0);
    }

    @Test
    public void testProducerConsumer() {
        ProducerConsumer pc = new ProducerConsumer();
        pc.start(4);
    }

}
