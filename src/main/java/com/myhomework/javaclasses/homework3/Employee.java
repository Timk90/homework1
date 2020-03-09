package com.myhomework.javaclasses.homework3;

public class Employee extends Human implements Worker {

    public Employee(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void work() {
        if(!checkSleep()) {
            System.out.println("I am working...");
        }else{
            System.out.println("I can not work while sleeping");
        }
    }
}
