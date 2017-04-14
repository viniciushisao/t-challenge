package model;

import util.GeneralUtil;

import java.util.ArrayList;

/**
 * Created by vinicius on 13/04/17.
 */
public class Session {


    public static final String MORNING = "Morning";
    public static final String AFTERNOON = "Afternoon";


    public enum SessionType {

        MORNING_SESSION(GeneralUtil.getTimeInMinute("09:00AM"), GeneralUtil.getTimeInMinute("12:00PM"), false, MORNING),
        AFTERNOON_SESSION(GeneralUtil.getTimeInMinute("01:00pm"), GeneralUtil.getTimeInMinute("04:00PM"), true, AFTERNOON);


        private String identifier;
        private int start;
        private int finish;
        private boolean hasOneHour;

        SessionType(int start, int finish, boolean hasOneHour, String identifier) {
            this.start = start;
            this.finish = finish;
            this.hasOneHour = hasOneHour;
            this.identifier = identifier;
        }

        /**
         * @return the amount of time of this session.
         */
        public int getAmountOfTime() {
            return this.finish - this.start;
        }

        /**
         * @return a String identifying this
         */
        public String getIdentifier() {
            return this.identifier;
        }
    }

    private ArrayList<Talk> talks;
    private SessionType sessionType;

    public Session(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public boolean isSessionValid() {
        return true;
    }

    public SessionType getSessionType() {
        return this.sessionType;
    }

    /**
     * This method will make a copy of its original.
     * @param incomeTalks
     */
    public void setTalks(ArrayList<Talk> incomeTalks){
        this.talks = new ArrayList<>();
        for (Talk talk : incomeTalks){
            this.talks.add(talk);
        }
    }


    @Override
    public String toString() {

        StringBuffer str = new StringBuffer();

        for (Talk talk : talks) {
            str.append(talk.getDuration() + " " + talk.getTitle());
            str.append('\n');
        }

        return str.toString();

    }
}
