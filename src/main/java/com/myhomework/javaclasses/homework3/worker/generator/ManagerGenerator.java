package com.myhomework.javaclasses.homework3.worker.generator;

import com.myhomework.javaclasses.homework3.worker.Manager;

import java.util.Random;

public class ManagerGenerator {

    private static int counter = 0;

    private ManagerGenerator() {
    }

    public static Manager getEntity() {
        counter++;
        return new Manager(
                "Manager # " + counter,
                "",
                new Random().nextInt(30) + 18
        );
    }

}
