package com.myhomework.javaclasses.homework3.worker.generator;

import com.myhomework.javaclasses.homework3.worker.Developer;

import java.util.Random;

public class DeveloperGenerator {

    private static int counter = 0;

    private DeveloperGenerator() {
    }

    public static Developer getEntity() {
        counter++;
        return new Developer(
                "Developer # " + counter,
                "",
                new Random().nextInt(50) + 18
        );
    }
}
