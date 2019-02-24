package t02;

import t01.KeywordsInFile;

public class KeywordsInFileByCharsDemo {
    public static void main(String[] args) {
        KeywordsInFile keywordsInFile = new KeywordsInFileByChars("src\\t01\\JavaKeywords.java");

        keywordsInFile.process("ByChars.txt");
    }
}
