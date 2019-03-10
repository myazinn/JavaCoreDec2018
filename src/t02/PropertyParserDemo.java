package t02;

import java.io.IOException;

public class PropertyParserDemo {
    public static void main(String[] args) {
        try {
            PropertyParser propertyParser = PropertyParser.of("my_property.property");
            System.out.println(propertyParser.getValue("one"));
            System.out.println(propertyParser.getValue("two"));
            System.out.println(propertyParser.getValue("three"));
            System.out.println(propertyParser.getValue("4"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
