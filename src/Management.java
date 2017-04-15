import model.ArrangeResult;
import model.Session;
import model.Talk;
import model.Track;

import java.util.ArrayList;

/**
 * Created by vinicius on 14/04/17.
 */
public abstract class Management {


    public static ArrangeResult arrange(ArrayList<Talk> talks, int ammountOfTracks) {

        ArrayList<Track> tracks = new ArrayList<>();

        // adding the amount of tracks
        for (int i = 0; i < ammountOfTracks; i++) {
            tracks.add(new Track(String.valueOf(i + 1)));
        }

        //filling the sessions

        //morning sessions
        ArrayList<Talk> result = null;
        for (Track track : tracks) {
            for (Session session : track.getSessions()) {
                if (session.getSessionType().getIdentifier() == Session.MORNING) {
                    result = KnapSack.solution(talks, session.getSessionType().getSessionDuration());
                    session.setTalks(result);
                    result.clear();
                }
            }
        }

        //afternoon sessions
        result.clear();
        for (Track track : tracks) {
            for (Session session : track.getSessions()) {
                if (session.getSessionType().getIdentifier() == Session.AFTERNOON) {
                    result = KnapSack.solution(talks, session.getSessionType().getSessionDuration() + 60);
                    session.setTalks(result);
                    result.clear();
                }
            }
        }

        ArrangeResult arrangeResult = new ArrangeResult();
        arrangeResult.notAllocatedTalks = talks;
        arrangeResult.tracks = tracks;

        return arrangeResult;
    }
}
