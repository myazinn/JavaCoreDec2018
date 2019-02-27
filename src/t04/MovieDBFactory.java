package t04;

import t04.basis.Actor;
import t04.basis.Movie;
import t04.basis.MovieDB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MovieDBFactory {
    public static void main(String[] args) {
        MovieDB movieDB = new MovieDB();

        Actor johny = new Actor("Johnny","Depp");
        Actor orlando = new Actor("Orlando", "Bloom");
        Actor brad = new Actor("Bradley", "Pitt");
        Actor logan = new Actor("Logan", "Lerman");


        Movie pirates = new Movie("Pirates of the Caribbean", 2003, johny, orlando);
        Movie troy = new Movie("Troy", 2004, brad, orlando);
        Movie fury = new Movie("Fury", 2014, brad, logan);

        movieDB.addMovie(pirates);
        movieDB.addMovie(troy);
        movieDB.addMovie(fury);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data"))){
            objectOutputStream.writeObject(movieDB);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
