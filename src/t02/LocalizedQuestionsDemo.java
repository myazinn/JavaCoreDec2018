package t02;

import java.util.Locale;
import java.util.Scanner;

public class LocalizedQuestionsDemo {
    public static void main(String[] args) {
        System.out.println("Enter your language. Available options : ru, en\n" +
                "Введите ваш язык. Доступные варианты : ru, en");
        String choice = new Scanner(System.in).next().toLowerCase();

        new LocalizedQuestions(new Locale(choice)).start();
    }
}
