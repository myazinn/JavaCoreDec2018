package t01;

public class CrazyLoggerDemo {
    public static void main(String[] args) {
        CrazyLogger crazyLogger = new CrazyLogger();
        String[] messages = {"First Test", "Second Test", "Third Test"};

        crazyLogger.log(messages[0]);
        crazyLogger.log(messages[1]);
        crazyLogger.log(messages[0]);

        System.out.println("Full log :");
        System.out.println(crazyLogger.getLog());

        for (String message : messages) {
            System.out.println(message + " at ");
            crazyLogger.printMessageTime(message);
            System.out.println();
        }

        System.out.println("trying to find \"Test\"");
        crazyLogger.printMessageTime("Test");
    }
}
