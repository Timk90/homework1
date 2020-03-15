package com.myhomework.javaclasses;

import com.myhomework.javaclasses.homework2.HumanProvider;
import com.myhomework.javaclasses.homework2.Spa;
import com.myhomework.javaclasses.homework3.worker.Developer;
import com.myhomework.javaclasses.homework3.worker.Employee;
import com.myhomework.javaclasses.homework3.worker.Human;
import com.myhomework.javaclasses.homework3.worker.Manager;
import com.myhomework.javaclasses.homework3.worker.Tester;
import com.myhomework.javaclasses.homework3.worker.Worker;
import com.myhomework.javaclasses.homework3.worker.exceptions.SleepException;
import com.myhomework.javaclasses.homework3.worker.generator.WorkerEntityProvider;
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

public class Homework3Tests extends TestCase {

    List<Human> humans;

    @Before
    public void setUp() {
        humans = null;
    }

    /**
     * Check all human's actions.
     */
    @Test
    public void testHumanActions() {
        com.myhomework.javaclasses.homework2.Human human = new com.myhomework.javaclasses.homework2.Human(
                "John",
                170,
                64.0,
                19,
                com.myhomework.javaclasses.homework2.Human.Nationality.RUS
        );

        assertFalse(human.checkSleep());
        assertEquals("Russia", human.getNation());
        human.eat("some food");
        human.walk();
        human.sleep();
        assertTrue(human.checkSleep());
        human.eat("food");
        human.walk();
        human.sleep();
        assertFalse(human.checkSleep());
        System.out.println(human.getNation());
        System.out.println(human.getBMI());
    }


    /**
     * Проверка запрета посещения спа центра для спящих людей.
     */
    @Test
    public void testSpaServiceForbiddenForSleepyVisitors() {
        Spa spa = new Spa();

        com.myhomework.javaclasses.homework2.Human firstHuman = HumanProvider.getEntity();

        Stream.iterate(0, i -> i++)
                .limit(100)
                .forEach(e -> spa.service(firstHuman));

        assertEquals(100, spa.getTotalVisits());
        firstHuman.sleep();

        Stream.iterate(0, i -> i++)
                .limit(100)
                .forEach(e -> spa.service(firstHuman));

        assertEquals(100, spa.getTotalVisits());

        firstHuman.sleep();
        spa.service(firstHuman);
        assertEquals(101, spa.getTotalVisits());
    }

    /**
     * Проверка Spa для нескольких людей людей.
     */
    @Test
    public void testSpaServiceForSeveralVisitors() {
        Spa spa = new Spa();

        com.myhomework.javaclasses.homework2.Human firstHuman = HumanProvider.getEntity();
        com.myhomework.javaclasses.homework2.Human secondHuman = HumanProvider.getEntity();
        com.myhomework.javaclasses.homework2.Human thirdHuman = HumanProvider.getEntity();
        com.myhomework.javaclasses.homework2.Human fourthHuman = HumanProvider.getEntity();
        com.myhomework.javaclasses.homework2.Human fifthHuman = HumanProvider.getEntity();

        spa.service(firstHuman, secondHuman, thirdHuman, fourthHuman, fifthHuman);

        assertEquals(5, spa.getTotalVisits());
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

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Homework3Tests(String testName) {
        super(testName);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}

