package util;

import model.ArrangeResult;
import model.Session;
import model.Talk;
import model.Track;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static model.Session.MORNING;

/**
 * Created by vinicius on 13/04/17.
 */
public abstract class GeneralUtil {

    private static final String PATH_TO_RESOURCES = "././test/res/";

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

        System.out.println("FINAL REPORT\n");
        for (Track track : arrangeResult.tracks){
            System.out.println("TRACK: " + track.getTrackName());
            for (Session session : track.getSessions()){
                System.out.println("SESSION: " + session.getSessionType().getIdentifierString() + " VALID: " + session.isValid());
            }
        }
        System.out.println("NOT INCLUDED TALKS: " + arrangeResult.notAllocatedTalks.size());
    }

    /**
     * @return a list of paths of all files in resource folder in tests.
     * It may return an empty arraylist but never null
     */
    public static ArrayList<String> getAllFilesInResFolder() {
        Path path = Paths.get(PATH_TO_RESOURCES);

        ArrayList<String> paths = new ArrayList<>();

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path oneF, BasicFileAttributes attrs) throws IOException {
                    if (Files.exists(oneF)) {
                        paths.add(oneF.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        return paths;
    }

    /**
     * Open a file and return all the lines in String format
     *
     * @param fileUri
     * @return may return an ArrayList empty but never null
     */
    public static ArrayList<String> getLinesOfFile(String fileUri) {

        ArrayList<String> result = new ArrayList<>();

        File file = new File(fileUri);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null) {
                result.add(text);
            }
        } catch (IOException e) {
            result.clear();
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ignored) {
            }
        }
        return result;
    }

    /**
     * Order talks from bigger to smaller.
     *
     * @param talks
     */
    public static void orderTalks(ArrayList<Talk> talks) {
        Collections.sort(talks, (t1, t2) -> t2.getDuration() - t1.getDuration());
    }
}
