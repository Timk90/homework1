package com.myhomework.javaclasses.homework3.library;

import com.myhomework.javaclasses.homework3.worker.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class TestBookGenerator {

    private static int bookCounter = 0;

    private static List<Human> authors = new ArrayList<>(List.of(
            new Author("Mikhail", "Bulgakov", new Random().nextInt(50) + 40),
            new Author("Fedor", "Dostoevsky", new Random().nextInt(70) + 30),
            new Author("Mikhail", "Efremov", new Random().nextInt(40) + 20),
            new Author("Lev", "Tolstoy", new Random().nextInt(50) + 40))
    );

    private TestBookGenerator() {
    }

    public static Book getEntity(Human human) {
        bookCounter++;
        return new Book(
                new Random().nextInt(150) + 100,
                "Test book " + bookCounter,
                human
        );
    }

    public static Book getEntity() {
        Human human = getAuthor();
        return getEntity(human);
    }

    public static Book getEntity(String bookName) {
        Human human = getAuthor();
        return new Book(
                new Random().nextInt(550) + 100,
                bookName,
                human);
    }

    private static Author getAuthor() {
        return (Author) authors.get(new Random().nextInt(authors.size()));
    }

    private static class Author extends Human {

        public Author(String name, String surname, int age) {
            super(name, surname, age);
        }
    }
}
