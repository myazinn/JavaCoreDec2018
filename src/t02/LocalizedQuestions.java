package t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class LocalizedQuestions {
    private ResourceBundle resourceBundle;

    LocalizedQuestions(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("content", locale);
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            printMenu();

            String prompt = scanner.next();

            if (prompt.equals("4")) {
                run = false;
            } else {
                System.out.println(getAnswer(prompt));
                System.out.println();
            }
        }

    }

    private void printMenu() {
        for (String key : resourceBundle.keySet()) {
            System.out.println(key + ". " + getQuestion(key));
        }
    }

    private String getQuestion(String key) {
        String field = resourceBundle.getObject(key).toString();
        int delimiterPos = field.indexOf(':');
        return field.substring(0, delimiterPos);
    }

    private String getAnswer(String key) {
        String field = resourceBundle.getObject(key).toString();
        int delimiterPos = field.indexOf(':') + 1;
        return field.substring(delimiterPos);
    }
}
