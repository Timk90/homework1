package com.myhomework.javaclasses.homework3.library;

import com.myhomework.javaclasses.homework2.Human;

public class Student extends Human implements BookReader, BookOwner {

    private Book book;

    private int pageQuantityCounter = 0;

    private int bookQuantityCounter = 0;

    @Override
    public void addBook(Book book) {
        if (book.equals(this.book)) {
            throw new TakeBookException("Student already has this book.");
        }
        if (this.book != null) {
            throw new TakeBookException("Student already has some book.");
        }
        System.out.println("the book "
                + book.getName() + " written by "
                + book.getAuthor().getName() + " "
                + book.getAuthor().getSurname() + " was added.");
        this.book = book;
    }

    @Override
    public Book giveBook(String bookName) {
        if (!this.checkSleep()) {
            if (this.book == null) {
                throw new TakeBookException("Student do not have any book.");
            }
            if (!this.book.getName().equals(bookName)) {
                throw new TakeBookException("Student has another book.");
            }
            Book book = this.book;
            this.book = null;
            return book;
        }
        return null;
    }

    @Override
    public void readBook(Book book) {
        if (!this.checkSleep()) {
            this.book = book;
            pageQuantityCounter += book.getPageQuantity();
            bookQuantityCounter++;
            System.out.println(" student read the book " + book.getName() + " with a total page number " + book.getPageQuantity() + ".");
        }
    }

    public void dropBook() {
        if (!this.checkSleep()) {
            System.out.println("Student dropped the book " + this.book.getName());
            this.book = null;
        }
    }

    public int getPageQuantityCounter() {
        return pageQuantityCounter;
    }

    public int getBookQuantityCounter() {
        return bookQuantityCounter;
    }
}
