package com.myhomework.javaclasses.homework3.library;

import com.myhomework.javaclasses.homework2.Human;

public class Student extends Human implements BookReader {

    private Book book;

    private int pageQuantityCounter = 0;

    private int bookQuantityCounter = 0;

    @Override
    public void readBook(Book book) {
        this.book = book;
        pageQuantityCounter += book.getPageQuantity();
    }
}
