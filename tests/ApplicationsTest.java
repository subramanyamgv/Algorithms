import com.algo.applications.FileSystemTraversal;
import org.junit.Test;

import java.io.File;


/**
 * Created by Subramanyam on 07-Dec-2016.
 */
public class ApplicationsTest {

    @Test
    public void insertLeftParenthesis() {

        FileSystemTraversal apps = new FileSystemTraversal();

//        apps.printFileSystemTree(new File("C:\\Users\\Subramanyam\\Dropbox\\Ebooks"));
        apps.printFileSystemTreeRecursive(new File("C:\\Users\\Subramanyam\\Dropbox\\Ebooks"), 0);
    }

}
