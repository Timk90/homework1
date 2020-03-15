package com.myhomework.javaclasses.homework3.library;

import java.util.ArrayList;
import java.util.List;

public class Library implements BookOwner {

    List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) throws TakeBookException {

        if (books.size() >= 5) {
            throw new TakeBookException("It is impossible add a new book. Library is full", book);
        }

        books.stream()
                .filter(e -> e.equals(book))
                .findFirst()
                .ifPresentOrElse((e) -> {
                    throw new TakeBookException("This book is already added to the library.", e);
                }, () -> {
                    books.add(book);
                    System.out.println("New book "+book.getName()+":"+book.getPageQuantity()+" pp. writen by "+book.getAuthor().getSurname()+" is added.");
                });
    }

    @Override
    public Book giveBook(String bookName) throws TakeBookException {
        Book book = books.stream()
                .filter(e -> e.getName().equals(bookName))
                .findFirst()
                .orElseThrow(() -> new TakeBookException(String.format("THERE IS NO SUCH book %s in the Library", bookName)));
        books.remove(book);
        return book;
    }

    public int getSize() {
        return books.size();
    }
}
