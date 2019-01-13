import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NotebookTest {

    private Notebook notebook = new Notebook();

    @Test
    void addEntry() {
        assertTrue(notebook.addEntry(""));
        assertTrue(notebook.addEntry("First"));
    }

    @Test
    void removeEntry() {
        notebook.addEntry("first");
        notebook.addEntry("second");
        notebook.addEntry("third");
        assertTrue(notebook.removeEntry(2));
        assertTrue(notebook.removeEntry("second"));
        assertFalse(notebook.removeEntry("second"));
        assertFalse(notebook.removeEntry(2));

    }

    @Test
    void editEntry() {
        notebook.addEntry("first");
        notebook.addEntry("second");

        assertTrue(notebook.editEntry(0, "second"));
        assertTrue(notebook.editEntry(1, "third"));

        assertTrue(notebook.editEntry("third", "THI"));
        assertFalse(notebook.editEntry("third", "THI"));
        assertFalse(notebook.editEntry(3,"SSS"));

        assertEquals(notebook.getEntry(0), "second");
        assertEquals(notebook.getEntry(1), "THI");
    }

    @Test
    void getAll() {
        notebook.addEntry("FIRST");
        notebook.addEntry("SECOND");
        notebook.addEntry("THIRD");
        assertTrue(Arrays.equals(notebook.getAll(), new String[]{"FIRST", "SECOND", "THIRD"}));
    }
}