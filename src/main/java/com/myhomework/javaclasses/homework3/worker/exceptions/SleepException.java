package com.myhomework.javaclasses.homework3.worker.exceptions;

import com.myhomework.javaclasses.homework3.worker.Human;

public class SleepException extends RuntimeException {
    private SleepException() {
    }

    public SleepException(String message) {
        super(message);
    }

    public SleepException(Human human) {
        super(human.getName() +" "+human.getSurname()+" сейчас спит и ничего не может делать.");
}
}
