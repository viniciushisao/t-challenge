import org.junit.Test;
import util.GeneralUtil;

import java.util.ArrayList;

/**
 * Created by viniciushisao on 16/04/17.
 */
public class MainTest {

    /**
     * It will test all files under /res folder
     */
    @Test
    public void main() {
        ArrayList<String> paths = GeneralUtil.getAllFilesInResFolder();
        if (paths.size() > 0) {
            for (String path : paths) {
                String args[] = {path};
                Main.main(args);
            }
        } else {
            System.out.println("Something went wrong when reading file: ");
        }
    }
}