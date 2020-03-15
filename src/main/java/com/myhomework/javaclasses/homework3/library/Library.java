package com.myhomework.javaclasses.homework3.library;

import java.util.ArrayList;
import java.util.List;

public class Library implements BookOwner {

    List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {

        if (books.size() > 5) {
            throw new TakeBookException("It is impossible add a new book", book);
        }

        books.stream()
                .filter(e -> e.equals(book))
                .findFirst()
                .ifPresent(books::add);
    }

    @Override
    public Book giveBook(String bookName) {
        return books.stream()
                .filter(e -> e.getName().equals(bookName))
                .findFirst()
                .orElseThrow(() -> new TakeBookException(String.format("THERE IS NO SUCH book %s in the Library", bookName)));
    }

    public int getSize() {
        return books.size();
    }
}
