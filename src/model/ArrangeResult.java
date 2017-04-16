package model;

import java.util.ArrayList;

/**
 * Created by vinicius on 14/04/17.
 */
public class ArrangeResult {

    /**
     * The amount of tracks it was asked
     */
    public ArrayList<Track> tracks;

    /**
     * These talks was not possible to be allocated.
     */
    public ArrayList<Talk> notAllocatedTalks;

    /**
     * It says if this result is OK and meet all the specifications
     *
     * @return true if it is valid
     */
    public boolean isResultValid() {
        if (notAllocatedTalks.size() > 0) {
            return false;
        }
        for (Track track : tracks) {
            for (Session session : track.getSessions()) {
                if (!session.isValid()) {
                    return false;
                }
            }
        }
        return true;
    }
}
