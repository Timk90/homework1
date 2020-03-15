package com.myhomework.javaclasses.homework3.library;

import com.myhomework.javaclasses.homework2.Human;

public class Student extends Human implements BookReader, BookOwner{

    private Book book;

    private int pageQuantityCounter = 0;

    private int bookQuantityCounter = 0;

    @Override
    public void addBook(Book book) {
        if(book.equals(this.book)){
            throw new TakeBookException("Student already has this book.");
        }
        if (this.book != null){
            throw new TakeBookException("Student already has some book.");
        }
        this.book = book;
    }

    @Override
    public Book giveBook(String bookName) {
        if(!this.book.getName().equals(bookName)){
            throw new TakeBookException("Student has another book.");
        }
        if(this.book == null){
            throw new TakeBookException("Student do not have any book.");
        }
        return this.book;
    }

    @Override
    public void readBook(Book book) {
        this.book = book;
        pageQuantityCounter += book.getPageQuantity();
    }

    public void dropBook(){
        System.out.println("Student dropped the book "+this.book.getName());
        this.book = null;
    }
}
