package t01;

import java.io.*;

public class KeywordsInFileByBytes extends KeywordsInFile {
    KeywordsInFileByBytes(String file) {
        super(file);
    }

    KeywordsInFileByBytes(File file) {
        super(file);
    }

    @Override
    public JavaKeywords findKeywordUsages() {
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
    public void printKeywordUsages(JavaKeywords javaKeywords, File outputFile) {
        try (PrintStream printStream = new PrintStream(outputFile)){
            javaKeywords.getUsages().forEach((keyword, value) -> printStream.println(keyword + ": " + value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
