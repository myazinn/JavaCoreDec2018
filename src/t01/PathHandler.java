package t01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class PathHandler {
    private final Path path;
    private final Scanner scanner;
    private final Explorer explorer;

    PathHandler(Path path) {
        this.path = path;
        explorer = new Explorer(path);
        scanner = new Scanner(System.in);
    }

    /**
     * Handles path depending on its type (directory or file)
     * If it is a directory, allows to create new text file or delete existing text file
     * If it is a text file, allows to add content to that file
     * Do nothing if it is any other file
     */
    void handle() {
        if (Files.isDirectory(path)) {
            handleDirectory();
        } else {
            handleFile();
        }

        System.out.println("Done! Bye.");
    }

    private void handleFile(){
        if (path.toString().endsWith(".txt")) {
            handleTextFile();
        } else {
            handleOrdinaryFile();
        }
    }

    private void handleOrdinaryFile() {
        System.out.println("There is nothing I can do with this file");
    }

    private void handleTextFile() {
        addContent(path);
    }

    private void handleDirectory() {
        System.out.println("Available options: ");
        System.out.println("1. Delete txt file");
        System.out.println("2. Create txt file");

        int choice = scanner.nextInt();

        if (choice == 1) {
            deleteTxtFile();
        } else if (choice == 2) {
            createTxtFile();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void deleteTxtFile() {
        List<Path> pathList = explorer.getPathList();
        List<Path> filteredPathList = pathList.stream()
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".txt"))
                .collect(Collectors.toList());

        if (filteredPathList.size() != 0) {
            System.out.println("Choose a txt file");
            explorer.printPaths(filteredPathList);

            int choice = scanner.nextInt();

            try {
                Files.deleteIfExists(filteredPathList.get(choice));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No .txt file to delete");
        }
    }

    private void createTxtFile() {
        System.out.println("Enter a filename");
        String filename = readLine();

        Path filePath = Path.of(path.toString(), filename + ".txt");
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        addContent(filePath);
    }

    private void addContent(Path filePath) {
        System.out.println("Enter a new content");
        String content = readLine();
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLine() {
        String content;
        do {
            content = scanner.nextLine();
        } while (content.length() == 0);

        return content;
    }
}
