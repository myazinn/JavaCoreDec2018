package t01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrazyLogger {

    private StringBuilder fullLog;
    private SimpleDateFormat simpleDateFormat;

    CrazyLogger() {
        fullLog = new StringBuilder();
        String datePattern = "dd-MM-yyyy : HH-mm";
        simpleDateFormat = new SimpleDateFormat(datePattern);
    }

    void log(String message) {
        fullLog.append(simpleDateFormat.format(new Date()));
        String delimiter = " - ";
        fullLog.append(delimiter);

        fullLog.append(message);

        String messageEnding = ";\n";
        fullLog.append(messageEnding);
    }

    void printMessageTime(String message) {
        String regExpDatePattern = "((\\d{2}-){2}\\d{4} : \\d{2}-\\d{2}) - ";
        String regExpMessageEnding = ";\\n";

        Pattern pattern = Pattern.compile(regExpDatePattern + message + regExpMessageEnding);
        Matcher matcher = pattern.matcher(fullLog);

        int start = -1;
        int end;
        while (matcher.find()) {
            start = matcher.start(1);
            end = matcher.end(1);
            System.out.println(fullLog.substring(start, end));
        }
        if (start == -1) {
            String messageNotFound = "Error: Message not found in this log";
            System.out.println(messageNotFound);
        }
    }

    String getLog() {
        return fullLog.toString();
    }
}
