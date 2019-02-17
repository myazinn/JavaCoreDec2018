package t03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileParser {
    private File file;
    private CrazyParser crazyParser;

    FileParser(String file) {
        this.file = new File(file);
        crazyParser = new CrazyParser();
    }

    void parse() {
        Charset charset = getCharset();

        try (BufferedReader reader = new BufferedReader(new FileReader(file, charset))) {
            String buffer = "";

            while (buffer != null) {
                crazyParser.parsePrintLine(buffer);
                buffer = reader.readLine();
            }

        } catch (IOException exc) {
            System.out.println(exc.toString());
        }
    }

    private Charset getCharset() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String buffer = "";
            Pattern charsetPattern = Pattern.compile("charset *= *([\\w-]+)");

            while (buffer != null) {
                Matcher charsetMatcher = charsetPattern.matcher(buffer);
                if (charsetMatcher.find()) {
                    String charset = charsetMatcher.group(1);
                    return Charset.forName(charset);
                }
                buffer = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println(exc.toString());
        }
        return StandardCharsets.UTF_8;
    }
}
