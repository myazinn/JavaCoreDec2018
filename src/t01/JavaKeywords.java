package t01;

import java.util.HashMap;
import java.util.Map;

public class JavaKeywords {
    private static String[] keywords = {
            "abstract", "continue", "for", "new", "switch",
            "assert", "default", "goto", "package", "synchronized",
            "boolean", "do", "if", "private", "this",
            "break", "double", "implements", "protected", "throw",
            "byte", "else", "import", "public", "throws", "case",
            "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try",
            "char", "final", "interface", "static", "void",
            "class", "finally", "long", "strictfp", "volatile",
            "const", "float", "native", "super", "while"};


    private Map<String, Integer> keywordsMap;

    JavaKeywords(){
        keywordsMap = new HashMap<>();

        for (String keyword : keywords) {
            keywordsMap.put(keyword,0);
        }
    }

    public boolean containsKeyword(String keyword) {
        return keywordsMap.containsKey(keyword);
    }

    public void addUsage(String keyword) {
        if (containsKeyword(keyword)){
            int value = keywordsMap.get(keyword) + 1;
            keywordsMap.put(keyword, value);
        }
    }

    public Map<String, Integer> getUsages() {
        Map<String, Integer> result = new HashMap<>();

        keywordsMap.forEach((key, value) -> {
            if (value > 0) {
                result.put(key, value);
        }});

        return result;

    }

}
