package com.myhomework.javaclasses;

import com.myhomework.javaclasses.homework3.Developer;
import com.myhomework.javaclasses.homework3.Employee;
import com.myhomework.javaclasses.homework3.Human;
import com.myhomework.javaclasses.homework3.Manager;
import com.myhomework.javaclasses.homework3.Tester;
import com.myhomework.javaclasses.homework3.Worker;
import com.myhomework.javaclasses.homework3.WorkerEntityProvider;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkersTests extends TestCase {

    @Before
    public void setUp() {

    }

    /**
     * Создает 300 произвольных рабочих, используя генератор.
     */
    @Test
    public void testCheckWorkersGenerator() {

        List<Class<? extends Worker>> clsTypes = new ArrayList<>();
        clsTypes.addAll(Arrays.asList(Developer.class, Employee.class, Tester.class, Manager.class));

        List<Worker> workerList = Stream
                .iterate(300, i -> i--)
                .map(e -> (Worker) WorkerEntityProvider.getEntity(clsTypes.get(new Random().nextInt(4))))
                .limit(300)
                .collect(Collectors.toList());
    }

    @Test
    public void testSleepException(){
        Worker tester = WorkerEntityProvider.getEntity(Tester.class);
        ((Human)tester).sleep();

    }
}
