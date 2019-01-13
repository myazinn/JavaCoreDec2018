import java.util.ArrayList;

/**
 * This class represents notebook that collects a bunch of entry
 * @author Myazin N
 * @version 0.9a
 */
public class Notebook {
    ArrayList<NotebookEntry> body = new ArrayList<>();

    /**
     * Creates new notebook and a new entry with the <b>text</b> inside
     * @param text text of the entry
     * @see Notebook#Notebook()
     */
    Notebook(String text){
        addEntry(text);
    }
    /**
     * Creates new notebook
     * @see Notebook#Notebook(String)
     */
    Notebook() {}

    /**
     * Creates a new entry in notebook
     * @param text text of the entry
     * @return true
     */
    public boolean addEntry(String text){
        body.add(new NotebookEntry(text));
        return true;
    }

    /**
     * Removes an entry from the notebook by its index
     * @param index the index of the entry you want to remove
     * @return true if entry was successfully deleted and false otherwise
     * @see Notebook#removeEntry(String)
     */
    public boolean removeEntry(int index){
        if (indexOk(index)){
            body.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Removes an entry from the notebook by its value
     * @param entry an entry that you want to remove
     * @return true if entry was successfully deleted and false otherwise
     * @see Notebook#removeEntry(int)
     */
    public boolean removeEntry(String entry){
        return removeEntry(lookup(entry));
    }

    /**
     * Edits (modifies) specified entry
     * @param index the index of the entry you want to edit
     * @param newEntry a new entry that will replace an old one
     * @return true if entry was successfully edited and false otherwise
     * @see Notebook#editEntry(String, String)
     */
    public boolean editEntry(int index, String newEntry){
        if (indexOk(index)){
            body.get(index).setEntry(newEntry);
            return true;
        }
        return false;
    }

    /**
     * Edits (modifies) specified entry
     * @param currentEntry an entry that you want to edit
     * @param newEntry a new entry that will replace an old one
     * @return true if entry was successfully edited and false otherwise
     * @see Notebook#editEntry(int, String)
     */
    public boolean editEntry(String currentEntry, String newEntry){
        return editEntry(lookup(currentEntry), newEntry);
    }

    /**
     * Gives access to any existing entry;
     * @param index the index of the desired entry
     * @return entry if index was correct and error message "ERROR: INCORRECT INDEX" otherwise
     * @see Notebook#getAll()
     */
    public String getEntry(int index) {
        if (indexOk(index)){
            return body.get(index).getEntry();
        }
        return "ERROR: INCORRECT INDEX";
    }

    /**
     * Gives access to all existing entry
     * @return an array of all entries
     * @see Notebook#getEntry(int)
     */
    public String[] getAll() {
        String[] result = new String[body.size()];
        for (int i = 0; i < body.size(); i++){
            result[i] = body.get(i).getEntry();
        }

        return result;
    }

    /**
     * Checks if given index is valid for an array (to prevent out of bound exception)
     * @param i index of the array we are testing
     * @return true if index is valid and false otherwise
     */
    private boolean indexOk(int i){
        return 0 <= i && i < body.size();
    }

    /**
     * Finds specified entry in the notebook by value
     * @param entry entry we want to find
     * @return if found, index of the entry; -1 otherwise;
     */
    private int lookup(String entry) {
        for (int i = 0; i < body.size(); i++) {
            if (body.get(i).getEntry().equals(entry)) {
                return i;
            }
        }
        return -1;
    }
}
