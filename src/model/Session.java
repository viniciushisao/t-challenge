package model;

import util.GeneralUtil;

import java.util.ArrayList;

/**
 * Created by vinicius on 14/04/17.
 */
public class Session {


    public static final int MORNING = 1;
    public static final int AFTERNOON = 2;

    public enum SessionType {

        MORNING_SESSION(GeneralUtil.getTimeInMinute("09:00AM"), GeneralUtil.getTimeInMinute("12:00PM"), false, MORNING),
        AFTERNOON_SESSION(GeneralUtil.getTimeInMinute("01:00pm"), GeneralUtil.getTimeInMinute("04:00PM"), true, AFTERNOON);

        private int identifier;
        private int start;
        private int finish;
        private boolean hasOneHour;

        SessionType(int start, int finish, boolean hasOneHour, int identifier) {
            this.start = start;
            this.finish = finish;
            this.hasOneHour = hasOneHour;
            this.identifier = identifier;
        }

        /**
         * @return the amount of time of this session.
         */
        public int getSessionDuration() {
            return this.finish - this.start;
        }

        public int getIdentifier() {
            return this.identifier;
        }

        public int getStart() {
            return this.start;
        }

        /**
         * @return a String identifying this
         */
        public String getIdentifierString() {
            String result = null;
            switch (identifier) {
                case AFTERNOON:
                    result = "Afternoon";
                    break;
                case MORNING:
                    result = "Morning";
                    break;
            }
            return result;
        }
    }

    private ArrayList<Talk> talks;
    private SessionType sessionType;

    public Session(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * It says if this is a valid session, based on rules of each session.
     *
     * @return
     */
    public boolean isValid() {
        boolean result = false;
        if (this.sessionType.hasOneHour) {
            if (this.getAmountOfDurationOfTalks() >= sessionType.getSessionDuration() &&
                    this.getAmountOfDurationOfTalks() <= (sessionType.getSessionDuration() + 60)) {
                result = true;
            }
        } else {
            if (this.getAmountOfDurationOfTalks() == sessionType.getSessionDuration()) {
                result = true;
            }
        }
        return result;
    }

    public int getAmountOfDurationOfTalks() {
        int result = 0;
        for (Talk talk : talks) {
            result += talk.getDuration();
        }
        return result;
    }

    public SessionType getSessionType() {
        return this.sessionType;
    }

    /**
     * This method will make a copy of its original.
     *
     * @param incomeTalks
     */
    public void setTalks(ArrayList<Talk> incomeTalks) {
        this.talks = new ArrayList<>();
        for (Talk talk : incomeTalks) {
            this.talks.add(talk);
        }
    }


    @Override
    public String toString() {

        StringBuffer str = new StringBuffer();

        int totalTime = 0;
        for (Talk talk : talks) {
            totalTime += talk.getDuration();
            str.append(talk.getDuration() + " " + talk.getTitle());
            str.append('\n');
        }
        str.append("Total : " + totalTime + " isValid: " + isValid() + '\n');

        return str.toString();
    }

    public ArrayList<Talk> getTalks() {
        return talks;
    }
}
