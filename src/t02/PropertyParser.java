package t02;

import java.nio.file.Files;
import java.nio.file.Path;

public class PropertyParser {
    private final Path path;

    PropertyParser(String propertyPath){
        path = Path.of(propertyPath);
    }
}
