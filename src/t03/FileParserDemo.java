package t03;

public class FileParserDemo {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser("Java.SE.03.Information handling_task_attachment.html");

        fileParser.parse();
    }
}
