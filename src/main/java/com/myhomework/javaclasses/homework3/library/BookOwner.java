package com.myhomework.javaclasses.homework3.library;

/**
 * Владелец книг.
 */
public interface BookOwner {

    /**
     * Добавить новую книгу.
     *
     * @param book - книга.
     */
    boolean addBook(Book book);

    /**
     * Отдать книгу.
     *
     * @param bookName - имя книги.
     * @return - Book (запрашиваемая книга).
     */
    Book giveBook(String bookName);
}
