package t02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PropertyParser {
    private final Map<String, String> properties = new HashMap<>();

    static PropertyParser of(String propertyPath) throws IOException {
        return new PropertyParser(Path.of(propertyPath));
    }

    private PropertyParser(Path path) throws IOException {
        if (!Files.isReadable(path)) {
            throw new NoSuchFileException(path.toString());
        }
        parseProperty(path);
    }

    String getValue(String key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("key \"" + key + "\" does not exist in a property");
        }

        return properties.get(key);
    }

    boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    Set<String> keySet(){
        return properties.keySet();
    }

    private void parseProperty(Path path) throws IOException{
        List<String> strings = Files.readAllLines(path);
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i).trim();

            if (!string.startsWith("!") && !string.startsWith("#")) {
                int index = getIndex(string);
                StringBuilder valueBuilder = new StringBuilder();

                String key = string.substring(0, index).trim();
                String tempValue = string.substring(index + 1).trim();

                while (tempValue.endsWith("\\") && ++i < strings.size()) {
                    valueBuilder.append(tempValue, 0, tempValue.length() - 1);
                    tempValue = strings.get(i).trim();
                }
                valueBuilder.append(tempValue);

                properties.put(key, valueBuilder.toString());
            }
        }
    }

    private int getIndex(String string) throws WrongPropertyFormatException {
        int equalIndex = string.indexOf("=");
        int colonIndex = string.indexOf(":");

        if (equalIndex == -1 && colonIndex == -1) {
            throw new WrongPropertyFormatException("Every value require a key");
        }

        int index = Integer.MAX_VALUE;
        index = equalIndex != -1 ? equalIndex : index;
        index = colonIndex != -1 && index > colonIndex ? colonIndex : index;
        if (index == 0) {
            throw new WrongPropertyFormatException("Every value require a non-empty key");
        }
        return index;
    }
}
