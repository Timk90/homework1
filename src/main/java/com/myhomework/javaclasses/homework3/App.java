package com.myhomework.javaclasses.homework3;


import com.myhomework.javaclasses.homework3.library.Book;
import com.myhomework.javaclasses.homework3.library.Intern;
import com.myhomework.javaclasses.homework3.library.Library;
import com.myhomework.javaclasses.homework3.library.Student;
import com.myhomework.javaclasses.homework3.library.TakeBookException;
import com.myhomework.javaclasses.homework3.library.TestBookGenerator;
import com.myhomework.javaclasses.homework3.worker.Employee;
import com.myhomework.javaclasses.homework3.worker.Human;
import com.myhomework.javaclasses.homework3.worker.Tester;
import com.myhomework.javaclasses.homework3.worker.Worker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        Human author = new Employee("John", "Patrick", 102);

        Book book = new Book(
                100,
                "My First Book",
                author
        );

        Book newbook = new Book(
                120,
                "My Second Book",
                author
        );

        student.addBook(book);
        student.readBook(book);

        try {
            student.addBook(newbook);
        } catch (TakeBookException e) {
            System.out.println("Exception occurred for " + student.getName() + " student while adding book " + newbook.getName());
        }
        student.readBook(book);
        student.dropBook();
        student.addBook(newbook);
        student.giveBook("My Second Book");
        student.sleep();
        student.sleep();

        Library library = new Library();
        List<Book> books = Stream.generate(() -> TestBookGenerator.getEntity(author))
                .limit(5)
                .peek(library::addBook)
                .collect(Collectors.toList());

        student.addBook(library.giveBook("Test book 1"));
        System.out.println(library.getSize());
        student.readBook(book);
        student.readBook(newbook);
        System.out.println(student.getBookQuantityCounter() + " books read with total number of pages equals " + student.getPageQuantityCounter());
        student.dropBook();
        student.addBook(library.giveBook("Test book 3"));
        System.out.println(library.getSize());
        library.addBook(student.giveBook("Test book 3"));
        System.out.println(library.getSize());

        Worker worker = new Tester("Tester", "Best", 123);
        worker.work();
        Worker intern = new Intern();
        intern.work();
    }
}
