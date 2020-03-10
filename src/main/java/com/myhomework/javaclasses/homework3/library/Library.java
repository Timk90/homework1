package com.myhomework.javaclasses.homework3.library;

import java.util.ArrayList;
import java.util.List;

public class Library implements BookOwner {

    List<Book> books = new ArrayList<>();

    @Override
    public boolean addBook(Book book) {
        if(books.size() > 5){
            throw new TakeBookException("It is impossible add a new book", book);
        }
        for (Book availableBook : books) {
            if (book.equals(availableBook)) {
                return false;
            }
        }
        books.add(book);
        return true;
    }

    @Override
    public Book giveBook(String bookName) {
        return null;
    }
}
