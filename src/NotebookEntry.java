/**
 * This class represents single entry
 * @author Myazin N
 * @version 0.9
 */
public class NotebookEntry{
    /**
     * Body of the entry
     */
    private String entry;

    /**
     * Creates an objects of an entry with a text
     * @param text text that you need to out in an entry
     * @see NotebookEntry#NotebookEntry()
     */
    public NotebookEntry(String text) {
        this.entry = text;
    }
    /**
     * Creates an objects of an entry without a text
     * @see NotebookEntry#NotebookEntry(String)
     */
    public NotebookEntry() {
        this("");
    }

    /**
     * replace an old text of an entry with a new one
     * @param text new text of an entry
     * @return true
     * @see NotebookEntry#getEntry()
     */
    public boolean setEntry(String text) {
        this.entry = text;
        return true;
    }

    /**
     * Allows to see current state of an entry
     * @return current text of an entry
     * @see NotebookEntry#setEntry(String)
     */
    public String getEntry() {
        return entry;
    }
}
