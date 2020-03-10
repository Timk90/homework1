package com.myhomework.javaclasses;

import com.myhomework.javaclasses.homework3.spa.Developer;
import com.myhomework.javaclasses.homework3.spa.Employee;
import com.myhomework.javaclasses.homework3.spa.Human;
import com.myhomework.javaclasses.homework3.spa.Manager;
import com.myhomework.javaclasses.homework3.spa.exceptions.SleepException;
import com.myhomework.javaclasses.homework3.spa.Tester;
import com.myhomework.javaclasses.homework3.spa.Worker;
import com.myhomework.javaclasses.homework3.spa.generator.WorkerEntityProvider;
import junit.framework.TestCase;
import org.junit.Assert;
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

    /**
     * Проверка того, что метод sleep() выбрасывает исключение {@link SleepException}.
     */
    @Test
    public void testSleepException() {
        Human tester = WorkerEntityProvider.getEntity(Tester.class);
        tester.sleep();
        tester.wakeUp();
        tester.sleep();
        Assert.assertThrows("", SleepException.class, tester::sleep);
        tester.wakeUp();
        ((Worker) tester).work();
        tester.sleep();
        ((Worker) tester).work();
    }
}
