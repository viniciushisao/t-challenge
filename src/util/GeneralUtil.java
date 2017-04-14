package util;

import model.Talk;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by vinicius on 13/04/17.
 */
public abstract class GeneralUtil {


    /**
     *
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

    public static int getTimeInMinute(String time){

        int sum = 0;
        try{

            boolean pm = time.substring(time.length() - 2 , time.length()).equalsIgnoreCase("pm");
            int minutes = Integer.parseInt(time.substring(time.length() - 4, time.length() - 2));
            int hours = Integer.parseInt(time.substring(0,2));

            if (pm && hours < 12){
                hours += 12;
            }

            if (!pm && hours == 12){
                hours = 0;
            }

             sum =  (hours*60) + minutes;

        }catch (Exception e){
            e.printStackTrace();
        }
        return sum;

    }

}
