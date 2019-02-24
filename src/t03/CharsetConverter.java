package t03;

import java.io.*;
import java.nio.charset.StandardCharsets;

class CharsetConverter {
    static void convert(String inputName, String outputName) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputName, StandardCharsets.UTF_8));
                PrintWriter printWriter = new PrintWriter(outputName, StandardCharsets.UTF_16)){

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
