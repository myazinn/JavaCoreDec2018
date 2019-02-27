package t04;

import t04.basis.Actor;
import t04.basis.Movie;
import t04.basis.MovieDB;

import java.io.*;
import java.util.List;
import java.util.Scanner;

class MovieDBEditor {
    private MovieDB movieDB;

    void start(String fileName) {
        readDB(fileName);

        while (true) {
            int choice;

            Scanner scanner = new Scanner(System.in);

            myPrint("Choose an option (enter a number):\n" +
                    "1. Show all movies\n" +
                    "2. Edit movie info\n" +
                    "3. Add movie\n" +
                    "4. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    editMovie();
                    break;
                case 3:
                    addMovie();
                    break;
                case 4:
                    tryToSave(fileName);
                    return;
            }
        }
    }

    private void showAll() {
        printMovies();

        myPrint("Choose an option (enter a number):\n" +
                "1. Info about specific movie\n" +
                "2. Go back");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                myPrint("Enter a number of the movie");
                choice = scanner.nextInt();
                printActors(choice - 1);
                break;
            case 2:
                break;
        }
    }

    private void editMovie() {
        myPrint("Choose a movie (Enter a number)");
        printMovies();

        Scanner scanner = new Scanner(System.in);
        int movieChoice = scanner.nextInt();

        printActors(movieChoice - 1);

        myPrint("Choose an option (enter a number):\n" +
                "1. Add an actor");
        int actionChoice = scanner.nextInt();
        if (actionChoice == 1) {
            Actor actor = getActor();
            movieDB.addActor(movieChoice - 1, actor);
        }
    }

    private void addMovie(){
        Scanner scanner = new Scanner(System.in);

        myPrint("Enter movie title");
        String title = scanner.nextLine();

        System.out.println("Enter year of release");
        int year = scanner.nextInt();

        System.out.println("Enter amount of actors in that movies");
        int amount = scanner.nextInt();

        Actor[] actors = new Actor[amount];

        for (int i = 0; i < amount; i++){
            actors[i] = getActor();
        }

        movieDB.addMovie(new Movie(title, year, actors));
    }

    private void tryToSave(String fileName) {
        myPrint("Do you want to save changes? (Y/y - yes, N/n - no)");
        String decision = new Scanner(System.in).next();

        if (decision.equalsIgnoreCase("y")) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                objectOutputStream.writeObject(movieDB);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readDB(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Object object = objectInputStream.readObject();
            if (object instanceof MovieDB) {
                movieDB = (MovieDB) object;
            } else {
                throw new RuntimeException("Corrupted file");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Actor getActor() {
        Scanner scanner = new Scanner(System.in);

        myPrint("Enter a name of an actor");
        String name;
        do {
            name = scanner.nextLine();
        } while (name.trim().length() == 0);

        myPrint("Enter a surname of an actor");
        String surname = scanner.nextLine();

        return new Actor(name, surname);
    }

    private void myPrint(String text){
        System.out.println();
        System.out.println(text);
    }

    private void printMovies(){
        List<Movie> movies = movieDB.getMovies();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
    }

    private void printActors(int number) {
        Movie movie = movieDB.getMovies().get(number);

        myPrint("Actors in " + movie);

        List<Actor> actors = movie.getActors();
        for (int i = 0; i < actors.size(); i++) {
            System.out.println((i+1) + ". " + actors.get(i));
        }
    }
}
