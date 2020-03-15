package com.myhomework.javaclasses;

import com.myhomework.javaclasses.homework2.Human;
import com.myhomework.javaclasses.homework2.HumanProvider;
import com.myhomework.javaclasses.homework2.Spa;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Homework2Tests extends TestCase {

    List<Human> humans;

    @Before
    public void setUp() {
        humans = null;
    }

    /**
     * Check human counting accuracy.
     */
    @Test
    public void testHumanCounting() {
        humans = new ArrayList<>();
        Stream.iterate(0, i -> i + 1)
                .limit(100)
                .map(e -> {
                    Human human = HumanProvider.getEntity();
                    humans.add(human);
                    return human;
                })
                .forEach(e -> System.out.println(e.getName() + " from " + e.getNation()));
        assertEquals(HumanProvider.getGeneratedHumanCounter(), com.myhomework.javaclasses.homework2.Human.getHumanCounter() - 1);
    }

    /**
     * Проверка количества визитов нашего спа центра.
     */
    @Test
    public void testSpaService() {
        Spa spa = new Spa();
        humans = new ArrayList<>();

        Human firstHuman = HumanProvider.getEntity();

        humans.add(firstHuman);

        Stream.iterate(1, i -> i + 1)
                .limit(100)
                .map(e -> {
                    Human human = HumanProvider.getEntity();
                    humans.add(human);
                    return human;
                })
                .forEach(spa::service);

        assertEquals(100, spa.getTotalVisits());

        Stream.iterate(0, i -> i++)
                .limit(100)
                .forEach(e -> spa.service(firstHuman));

        assertEquals(200, spa.getTotalVisits());
    }

    /**
     * Проверка Spa для нескольких людей людей.
     */
    @Test
    public void testSpaServiceForSeveralVisitors() {
        Spa spa = new Spa();

        Human firstHuman = HumanProvider.getEntity();
        Human secondHuman = HumanProvider.getEntity();
        Human thirdHuman = HumanProvider.getEntity();
        Human fourthHuman = HumanProvider.getEntity();
        Human fifthHuman = HumanProvider.getEntity();

        spa.service(firstHuman, secondHuman, thirdHuman, fourthHuman, fifthHuman);

        assertEquals(5, spa.getTotalVisits());
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
}
