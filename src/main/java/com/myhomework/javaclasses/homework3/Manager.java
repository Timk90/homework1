package com.myhomework.javaclasses.homework3;

public class Manager extends Human implements Worker {

    public Manager(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void work() {
        if(!checkSleep()){
            System.out.println("I am bullshiting now");
        }else{
            System.out.println("I cannot do bullshiting while sleeping. Now I am more useful");
        }
    }
}
