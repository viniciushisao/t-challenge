import org.junit.Test;
import util.GeneralUtil;

import static org.junit.Assert.*;

/**
 * Created by vinicius on 14/04/17.
 */
public class GeneralUtilTest {

    /**
     * this is not case sensitive
     *
     * @throws Exception
     */
    @Test
    public void getTimeInMinute() throws Exception {
        assertEquals(GeneralUtil.getTimeInMinute("01:00am"), 60);
        assertEquals(GeneralUtil.getTimeInMinute("01:00pm"), (13 * 60));
        assertEquals(GeneralUtil.getTimeInMinute("12:00pm"), (12 * 60));
        assertEquals(GeneralUtil.getTimeInMinute("12:00am"), 0);
        assertEquals(GeneralUtil.getTimeInMinute("12:45am"), 45);
    }

    /**
     * this is case sensitive
     */

    @Test
    public void getTimeInAMPM() {
        assertEquals(GeneralUtil.getTimeInAMPM(13 * 60), "01:00PM");
        assertEquals(GeneralUtil.getTimeInAMPM(12 * 60), "12:00PM");
        assertEquals(GeneralUtil.getTimeInAMPM(0), "12:00AM");
        assertEquals(GeneralUtil.getTimeInAMPM(30), "12:30AM");
        assertEquals(GeneralUtil.getTimeInAMPM(60), "01:00AM");
        assertEquals(GeneralUtil.getTimeInAMPM(60*14), "02:00PM");
    }


}