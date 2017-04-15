package util;

import model.ArrangeResult;
import model.Session;
import model.Talk;
import model.Track;

import java.util.ArrayList;
import java.util.Iterator;

import static model.Session.MORNING;

/**
 * Created by vinicius on 13/04/17.
 */
public abstract class GeneralUtil {


    /**
     * @param desiredTime the time used to match on taks
     * @param talks
     * @return null if not found.
     */
    public static Talk getFirstAndDelete(int desiredTime, ArrayList<Talk> talks) {

        Talk talkToReturn = null;
        for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext(); ) {
            Talk talk = iterator.next();
            if (talk.getDuration() == desiredTime) {
                talkToReturn = talk;
                iterator.remove();
                break;
            }
        }
        return talkToReturn;
    }

    public static int getTimeInMinute(String time) {

        int sum = 0;
        try {

            boolean pm = time.substring(time.length() - 2, time.length()).equalsIgnoreCase("pm");
            int minutes = Integer.parseInt(time.substring(time.length() - 4, time.length() - 2));
            int hours = Integer.parseInt(time.substring(0, 2));

            if (pm && hours < 12) {
                hours += 12;
            }

            if (!pm && hours == 12) {
                hours = 0;
            }

            sum = (hours * 60) + minutes;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public static String getTimeInAMPM(int time) {

        String ampm = (time < (12 * 60) ? "AM" : "PM");

        StringBuffer result = new StringBuffer();

        //hour
        int hour;
        if ((time / 60) == 12 || (time / 60) == 0) {
            hour = 12;
        } else {
            hour = time / 60;
            if (hour > 12)
                hour -= 12;
        }
        String hourString = (hour < 10) ? "0" + String.valueOf(hour) : String.valueOf(hour);
        int minute = (time % 60);
        String minuteString = (minute < 10) ? "0" + String.valueOf(minute) : String.valueOf(minute);
        result.append(hourString + ":" + minuteString + ampm);
        return result.toString();
    }

    /**
     * This is the official printing tool. It will print the final model.
     *
     * @param arrangeResult
     */
    public static void print(ArrangeResult arrangeResult) {

        for (Track track : arrangeResult.tracks) {
            System.out.println("Track " + track.getTrackName() + ":");
            for (Session session : track.getSessions()) {
                int time = session.getSessionType().getStart();
                for (Talk talk : session.getTalks()) {
                    System.out.println(getTimeInAMPM(time) + " " + talk.getTitle());
                    time += talk.getDuration();
                }
                if (session.getSessionType().getIdentifier() == MORNING) {
                    System.out.println(getTimeInAMPM(time) + " Lunch");
                } else {
                    System.out.println();
                }
            }
        }

    }

}
