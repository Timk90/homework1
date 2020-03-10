package com.myhomework.javaclasses.homework3.library;

import com.myhomework.javaclasses.homework3.spa.Human;

public class Book {

    private int pageQuantity;
    private String name;
    private Human author;

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
}
