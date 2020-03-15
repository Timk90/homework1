package com.myhomework.javaclasses.homework3;


import com.myhomework.javaclasses.homework3.library.Book;
import com.myhomework.javaclasses.homework3.library.Student;
import com.myhomework.javaclasses.homework3.library.TakeBookException;
import com.myhomework.javaclasses.homework3.worker.Employee;
import com.myhomework.javaclasses.homework3.worker.Human;

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
        }catch (TakeBookException e){
            System.out.println("Exception occurred for "+student.getName()+" student while adding book "+newbook.getName());
        }
        student.readBook(book);
        student.dropBook();
        student.addBook(newbook);
        student.giveBook("My Second Book");
    }
}
