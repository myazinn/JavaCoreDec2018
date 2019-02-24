package t01;

import java.io.*;
import java.util.Map;

public class KeywordsInFileByBytes extends KeywordsInFile {
    public KeywordsInFileByBytes(String file) {
        super(file);
    }

    public KeywordsInFileByBytes(File file) {
        super(file);
    }

    @Override
    JavaKeywords findKeywordUsages() {
        {
            JavaKeywords javaKeywords = new JavaKeywords();

            try (BufferedInputStream bufferedInputStream =
                         new BufferedInputStream(
                                 new FileInputStream(file))) {

                int ch;
                StringBuilder word = new StringBuilder();

                while ((ch = bufferedInputStream.read()) != -1) {
                    if (Character.isLetter(ch)){
                        word.append((char) ch);
                    } else {
                        javaKeywords.addUsage(word.toString());
                        word = new StringBuilder();
                    }
                }
                javaKeywords.addUsage(word.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }

            return javaKeywords;
        }
    }

    @Override
    void printKeywordUsages(JavaKeywords javaKeywords, File outputFile) {
        try (PrintStream printStream = new PrintStream(outputFile)){
            for (Map.Entry<String, Integer> stringIntegerEntry : javaKeywords.getUsages().entrySet()) {

                printStream.print(stringIntegerEntry.getKey());
                printStream.print(": ");
                printStream.println(stringIntegerEntry.getValue());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
