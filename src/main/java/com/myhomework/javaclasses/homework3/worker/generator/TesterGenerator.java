package com.myhomework.javaclasses.homework3.worker.generator;

import com.myhomework.javaclasses.homework3.worker.Tester;

import java.util.Random;

public class TesterGenerator {

    private static int counter = 0;

    private TesterGenerator() {
    }

    public static Tester getEntity() {
        counter++;
        return new Tester(
                "Tester # " + counter,
                "",
                new Random().nextInt(20) + 18
        );
    }
}
