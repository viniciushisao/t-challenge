package model;

/**
 * Created by vinicius on 14/04/17.
 */
public class Talk {

    /**
     * in minutes
     */
    private int duration;
    private String title;

    public Talk(int duration, String title) {
        this.duration = duration;
        this.title = title;
    }

    public Talk(Talk talk){
        this.duration = talk.getDuration();
        this.title = talk.getTitle();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return this.duration + " - " + this.title;
    }
}
