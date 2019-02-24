package t01;

public class KeywordsInFileByBytesDemo {
    public static void main(String[] args) {
        KeywordsInFile keywordsInFile = new KeywordsInFileByBytes("src\\t01\\JavaKeywords.java");

        keywordsInFile.process();
    }
}
