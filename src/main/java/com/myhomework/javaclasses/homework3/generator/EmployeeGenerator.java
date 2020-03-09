package com.myhomework.javaclasses.homework3.generator;

import com.myhomework.javaclasses.homework3.Employee;

import java.util.Random;

public class EmployeeGenerator {

    private static int counter = 0;

    private EmployeeGenerator() {
    }

    public static Employee getEntity() {
        counter++;
        return new Employee(
                "Employee # " + counter,
                "",
                new Random().nextInt(50) + 28
        );
    }

}
