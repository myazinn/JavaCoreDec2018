// that class exists only to demonstrate the capabilities of the "Notebook" class
public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();

        for (int i = 0; i < 5; i++) {
            notebook.addEntry("line #" + (i+1));
        }

        System.out.println("Before modifications");
        printAll(notebook);

        notebook.removeEntry("line #2");
        notebook.removeEntry(0);
        notebook.editEntry(0, notebook.getEntry(0) + " modified");
        notebook.editEntry("line #5", "line #5 modified");

        System.out.println("After modifications");
        printAll(notebook);

    }

    private static void printAll (Notebook o) {
        for (String entry: o.getAll()) {
            System.out.println(entry);
        }
    }
}
