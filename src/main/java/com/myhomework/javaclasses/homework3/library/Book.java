package com.myhomework.javaclasses.homework3.library;

import com.myhomework.javaclasses.homework3.worker.Human;

public class Book {

    private int pageQuantity;
    private String name;
    private Human author;

    public Book(int pageQuantity, String name, Human author) {
        this.pageQuantity = pageQuantity;
        this.name = name;
        this.author = author;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getAuthor() {
        return author;
    }

    public void setAuthor(Human author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return this.name == book.name && this.author == book.author && this.pageQuantity == book.pageQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pageQuantity=" + pageQuantity +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
