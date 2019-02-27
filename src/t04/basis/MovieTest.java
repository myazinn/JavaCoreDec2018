package t04.basis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Actor johny = new Actor("Johnny","Depp");
    private Actor orlando = new Actor("Orlando", "Bloom");
    private Actor keira = new Actor("Keira", "Knightley");
    private Movie pirates = new Movie("Pirates of the Caribbean", 2003, johny, orlando);

    @Test
    void getTitle() {
        assertEquals("Pirates of the Caribbean", pirates.getTitle());
    }

    @Test
    void getYear() {
        assertEquals(2003, pirates.getYear());
    }

    @Test
    void addActor() {
        pirates.addActor(keira);
        assertEquals(keira, pirates.getActors().get(2));
    }

    @Test
    void getActors() {
        List<Actor> actors = new ArrayList<>();
        actors.add(johny);
        actors.add(orlando);

        assertEquals(actors, pirates.getActors());

    }
}