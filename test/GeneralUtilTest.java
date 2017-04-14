import org.junit.Test;
import util.GeneralUtil;

import static org.junit.Assert.*;

/**
 * Created by vinicius on 13/04/17.
 */
public class GeneralUtilTest {

    @Test
    public void getTimeInMinute() throws Exception {
        assertEquals(GeneralUtil.getTimeInMinute("01:00am"), 60);
        assertEquals(GeneralUtil.getTimeInMinute("01:00pm"), (13*60));
        assertEquals(GeneralUtil.getTimeInMinute("12:00pm"), (12*60));
        assertEquals(GeneralUtil.getTimeInMinute("12:00am"), 0);
        assertEquals(GeneralUtil.getTimeInMinute("12:45am"), 45);
    }

}