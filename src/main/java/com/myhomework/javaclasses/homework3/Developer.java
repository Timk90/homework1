package com.myhomework.javaclasses.homework3;

public class Developer extends Human implements Worker {

    public Developer(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void work() {
        if(!checkSleep()){
            System.out.println("I am developing now");
        }else{
            System.out.println("I cannot develop while sleeping");
        }
    }
}
