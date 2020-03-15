package com.myhomework.javaclasses.homework3.library;

import com.myhomework.javaclasses.homework3.worker.Worker;

public class Intern extends Student implements Worker {

    @Override
    public void work() {
        System.out.println("I am working as an Intern! woop woop...");
    }
}
