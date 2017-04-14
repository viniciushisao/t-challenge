import model.Session;
import model.Talk;
import model.Track;

import java.util.ArrayList;

/**
 * Created by vinicius on 13/04/17.
 */
public abstract class Management {

    public static final int AMOUNT_TRACKS = 2;


    public static void arrange(ArrayList<Talk> talks){

        ArrayList<Track> tracks = new ArrayList<>();

        // adding the amount of tracks
        for (int i = 0 ; i < AMOUNT_TRACKS ; i ++){
            tracks.add(new Track(String.valueOf(i + 1)));
        }

        //filling the sessions
        ArrayList<Talk> result;
        for (Track track : tracks){
            for (Session session : track.getSessions()){
               result = KnapSack.solution(talks,session.getSessionType().getAmountOfTime());
               session.setTalks(result);
               result.clear();
            }
        }

        //printing
        for (Track track : tracks){
           System.out.println(track.toString());
        }


    }



}
