package model;

import java.util.ArrayList;

/**
 * Created by vinicius on 14/04/17.
 */
public class Track {

    ArrayList<Session> sessions = new ArrayList<>();
    private String trackName;

    public Track(String trackName) {
        sessions.add(new Session(Session.SessionType.MORNING_SESSION));
        sessions.add(new Session(Session.SessionType.AFTERNOON_SESSION));
        this.trackName = trackName;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Track " + trackName + '\n');

        for (Session session : sessions) {
            str.append(session.getSessionType().getIdentifierString() + ":" + '\n');
            str.append(session.toString());
        }

        return str.toString();
    }

    public String getTrackName() {
        return this.trackName;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }
}
