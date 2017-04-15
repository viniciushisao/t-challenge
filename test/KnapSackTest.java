import model.Talk;
import org.junit.Test;
import util.GeneralUtil;

import java.util.ArrayList;

/**
 * Created by vinicius on 12/04/17.
 */
public class KnapSackTest {

    @Test
    public void test_solution() {

        ArrayList<Talk> input = TestUtil.getTalksDefault();

        GeneralUtil.orderTalks(input);

        ArrayList<Talk> result = KnapSack.solution(input, 60*3);
        TestUtil.print(result);

        result = KnapSack.solution(input, 60*3);
        TestUtil.print(result);

        result = KnapSack.solution(input, 60*3);
        TestUtil.print(result);

        result = KnapSack.solution(input, 60*3);
        TestUtil.print(result);

        //those are the rest
        TestUtil.print(input);
    }
}