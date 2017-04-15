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

        ArrangeResult arrangeResult = Management.arrange(TestUtil.getTalksDefault(), 2);

        //test if all sessions are good
        for(Track track : arrangeResult.tracks){
            for (Session session : track.getSessions()){
                assertTrue(session.isValid());
            }
        }

        //test if there is no talks which are not allocated
        assertEquals(arrangeResult.notAllocatedTalks.size(), 0);

        //printing
//        for (Track track : arrangeResult.tracks) {
//            System.out.println(track.toString());
//        }

        GeneralUtil.print(arrangeResult);

        System.out.println("Not allocated talks");
        TestUtil.print(arrangeResult.notAllocatedTalks);
    }

}