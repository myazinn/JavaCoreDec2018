package t04.basis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    private String title;
    private int year;
    private List<Actor> actors;

    public Movie(String title, int year, Actor... actors) {
        this.title = title;
        setYear(year);
        this.actors = new ArrayList<>();

        for (Actor actor : actors) {
            addActor(actor);
        }
    }

    String getTitle() {
        return title;
    }

    int getYear() {
        return year;
    }

    void addActor(Actor actor){
        actors.add(actor);
    }

    public List<Actor> getActors() {
        return new ArrayList<>(actors);
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }

    private void setYear(int year) {
        if (year > 1900 && year < 2025) {
            this.year = year;
        } else {
            throw new RuntimeException("Incorrect year");
        }
    }
}
