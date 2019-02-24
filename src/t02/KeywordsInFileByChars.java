package t02;

import t01.JavaKeywords;
import t01.KeywordsInFile;

import java.io.*;

public class KeywordsInFileByChars extends KeywordsInFile {
    KeywordsInFileByChars(String file) {
        super(file);
    }

    KeywordsInFileByChars(File file) {
        super(file);
    }

    @Override
    public void printKeywordUsages(JavaKeywords javaKeywords, File outputFile) {
        try (PrintWriter printWriter = new PrintWriter(outputFile)) {
            javaKeywords.getUsages().forEach((keyword, value) -> printWriter.println(keyword + ": " + value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JavaKeywords findKeywordUsages() {

        JavaKeywords javaKeywords = new JavaKeywords();

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W");

                for (String word : words) {
                    javaKeywords.addUsage(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return javaKeywords;
    }
}
