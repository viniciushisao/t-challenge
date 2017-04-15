import model.ArrangeResult;
import model.Talk;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vinicius on 14/04/17.
 */

public abstract class TestUtil {

    public final static String LINE_DIVIDER = "-----------------------------------";

    /**
     * @return a non static ArrayList with default Talk list
     */
    public static ArrayList<Talk> getTalksDefault() {
        return new ArrayList<>(Arrays.asList(
                new Talk(60, "Writing Fast Tests Against Enterprise Rails"),
                new Talk(45, "Overdoing it in Python"),
                new Talk(30, "Lua for the Masses"),
                new Talk(45, "Ruby Errors from Mismatched Gem Versions"),
                new Talk(45, "Common Ruby Errors"),
                new Talk(15, "Rails for Python Developers"),
                new Talk(60, "Communicating Over Distance"),
                new Talk(45, "Accounting-Driven Development"),
                new Talk(30, "Woah"),
                new Talk(30, "Sit Down and Write"),
                new Talk(45, "Pair Programming vs Noise"),
                new Talk(60, "Rails Magic"),
                new Talk(60, "Ruby on Rails: Why We Should Move On"),
                new Talk(45, "Clojure Ate Scala (on my project)"),
                new Talk(30, "Programming in the Boondocks of Seattle"),
                new Talk(30, "Ruby vs. Clojure for Back-End Development"),
                new Talk(60, "Ruby on Rails Legacy App Maintenance"),
                new Talk(30, "A World Without HackerNews"),
                new Talk(30, "User Interface CSS in Rails Apps")
        ));
    }

    public static void print(ArrayList<Talk> talks) {
        int totalTime = 0;
        for (Talk talk : talks) {
            System.out.println(talk.toString());
            totalTime += talk.getDuration();
        }
        System.out.println("Total : " + totalTime);
        System.out.println(LINE_DIVIDER);
    }

}
