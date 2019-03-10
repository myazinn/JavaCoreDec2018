package t01;

import java.nio.file.Path;

public class ExplorerDemo {
    public static void main(String[] args) {
        Explorer explorer = new Explorer();
        Path path = explorer.explore();
        PathHandler pathHandler = new PathHandler(path);
        pathHandler.handle();
    }
}
