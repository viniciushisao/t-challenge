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
}
