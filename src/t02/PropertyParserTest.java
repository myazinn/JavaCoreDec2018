package t02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyParserTest {

    private PropertyParser propertyParser;

    @Test
    void PropertyParserConstructorTest() {
        assertThrows(NoSuchFileException.class, () -> PropertyParser.of("my_my.txt"));
    }

    @Test
    void getValueTest() {
        try {
             propertyParser = PropertyParser.of("my_property.property");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("first field", propertyParser.getValue("one"));
        assertEquals("second field", propertyParser.getValue("two"));
        assertEquals("third : field", propertyParser.getValue("three"));
        assertEquals("txt", propertyParser.getValue("4"));

        assertEquals(4, propertyParser.keySet().size());

        String key = "five";
        assertThrows(IllegalArgumentException.class, () -> propertyParser.getValue(key));
    }
}