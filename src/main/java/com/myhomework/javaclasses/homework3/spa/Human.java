package com.myhomework.javaclasses.homework3.spa;

import com.myhomework.javaclasses.homework3.spa.exceptions.SleepException;

public abstract class Human {

    private String name;
    private String surname;
    private int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    boolean isAsleep;

    public void sleep() throws SleepException {
        if (!isAsleep) {
            isAsleep = true;
        } else {
            throw  new SleepException(this);
        }
    }

    public void wakeUp() {
        isAsleep = false;
    }

    public void greetings() {
        System.out.println(this.toString());
    }

    public boolean checkSleep(){
        return isAsleep;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "My name is " + name + ", and my surname is " + surname;
    }
}
