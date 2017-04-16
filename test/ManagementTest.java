import model.ArrangeResult;
import model.Session;
import model.Track;
import org.junit.Test;
import util.GeneralUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by vinicius on 14/04/17.
 */
public class ManagementTest {

    @Test
    public void arrange() throws Exception {

        //must work gracefully. the amount of tracks is ideal
        ArrangeResult arrangeResult = Management.arrange(TestUtil.getTalksDefault(), 2);
        assert(arrangeResult.isResultValid());

        //must fail
        arrangeResult = Management.arrange(TestUtil.getTalksDefault(), 3);
        assert(!arrangeResult.isResultValid());

    }

}