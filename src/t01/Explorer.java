package t01;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Explorer {
    private final Path ORIGINAL_PATH;
    private final int STOP_THERE_ID = 0;
    private final int BACK_ID = 1;

    private final Scanner scanner = new Scanner(System.in);
    private Path currentPath;


    Explorer() {
        this(Paths.get("src").toAbsolutePath().getParent());
    }

    Explorer(Path path) {
        ORIGINAL_PATH = path.toAbsolutePath();
        currentPath = ORIGINAL_PATH;
    }

    /**
     * Allows user to navigate in a file system and pick a certain file or folder
     * @return path to a file or folder
     */
    Path explore() {
        currentPath = ORIGINAL_PATH;
        while (true) {
            if (!exploreCurrentFolder()) break;
        }
        return currentPath;
    }

    /**
     * @return a list of all paths in a current Explorer path
     */
    List<Path> getPathList() {
        List<Path> pathList = new ArrayList<>();
        try(DirectoryStream<Path> paths = Files.newDirectoryStream(currentPath)){
            paths.forEach(pathList::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathList;
    }

    /**
     * prints all paths of a list in a specific format "#. LastPathName"
     * @param pathList list with paths
     */
    void printPaths(List<Path> pathList) {
        for (int i = 0; i < pathList.size(); i++) {
            System.out.println(pathToLine(i + 1, pathList.get(i)));
        }
        System.out.println();
    }

    private boolean exploreCurrentFolder() {
        if (Files.isDirectory(currentPath)) {
            List<Path> pathList = getPathList();

            int choice = getChoice(pathList);

            if (choice == getSpecialCode(STOP_THERE_ID)) {
                return false;
            }

            if (choice == getSpecialCode(BACK_ID)) {
                if (currentPath.getParent() != null) {
                    currentPath = currentPath.getParent();
                }
            } else {
                currentPath = pathList.get(choice);
            }
            return true;
        } else {
            return false;
        }
    }

    private int getChoice(List<Path> pathList) {

        System.out.println("Choose a directory or a file");
        printPaths(pathList);

        int indexAfterPrint = pathList.size() + 1;
        System.out.println((indexAfterPrint + STOP_THERE_ID) + ". STOP RIGHT THERE");
        System.out.println((indexAfterPrint + BACK_ID)+ ". GET BACK");

        int choice  = scanner.nextInt();

        if ((choice < 1) || (choice > indexAfterPrint + BACK_ID)){
            throw new IllegalArgumentException();
        }

        switch (choice - indexAfterPrint) {
            case STOP_THERE_ID:
                return getSpecialCode(STOP_THERE_ID);
            case BACK_ID:
                return getSpecialCode(BACK_ID);
            default:
                return choice - 1;
        }
    }

    private int getSpecialCode(int originalValue) {
        return -(originalValue + 1);
    }

    private String pathToLine(int lineNumber, Path path) {
        int nameCount = path.getNameCount() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lineNumber)
                .append(". ")
                .append(path.getName(nameCount));
        if (Files.isDirectory(path)) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }
}
