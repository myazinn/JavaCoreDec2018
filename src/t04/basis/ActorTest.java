package t04.basis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @Test
    void getFullNameTest() {
        Actor johny = new Actor("Johny", "Depp");
        assertEquals("Johny Depp", johny.getFullName());
    }
}