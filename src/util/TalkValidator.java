package util;

import model.Talk;

/**
 * Created by viniciushisao on 15/04/17.
 */
public abstract class TalkValidator {

    private static final String LIGHTNING = "lightning";
    private static final String LIGHTNING_TIME = "15";
    private static final String MIN = "min";


    /**
     * Rules:
     * No talk title has numbers in it.
     * All talk lengths are either in minutes (not hours) or lightning (5 minutes).
     *
     * @param str the line representing the talk.
     * @return if null, something went wrong. read log file, otherwise a Talk object will be returned.
     */
    public static Talk validateTalk(String str) {

        Talk talk = null;

        str = str.trim();
        String minutes = str.replaceAll("[^0-9]+", " ").trim();
        String title = str;

        // If you need to remove the time from string, uncomment this code
        if (minutes.length() > 0) {
            //title = str.replace(minutes + MIN, "").trim();
        } else {
            //is it lightning?
            if (str.indexOf(LIGHTNING) > 0) {
              //  title = str.replace(LIGHTNING, "").trim();
                minutes = LIGHTNING_TIME;
            }
        }

        try {
            int mins = Integer.parseInt(minutes);
            talk = new Talk(mins, title);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return talk;
    }

}
