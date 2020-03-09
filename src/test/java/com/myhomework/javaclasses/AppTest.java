package com.myhomework.javaclasses;

import com.myhomework.javaclasses.homework1.MyClass;
import com.myhomework.javaclasses.homework2.Human;
import com.myhomework.javaclasses.homework2.HumanProvider;
import com.myhomework.javaclasses.homework2.Spa;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    MyClass myClass;
    List<Human> humans;

    /**
     * Set up initials settings.
     */
    @Before
    public void setUp() {
        myClass = new MyClass();
        humans = null;
    }

    /**
     * Check bits counts.
     */
    @Test
    public void testCapacityCounts() {
        assertEquals(1, myClass.capacity(1));
        assertEquals(2, myClass.capacity(3));
        assertEquals(3, myClass.capacity(7));
        assertEquals(4, myClass.capacity(15));
        assertEquals(5, myClass.capacity(31));
        assertEquals(6, myClass.capacity(63));
        assertEquals(7, myClass.capacity(127));
    }

    @Test
    public void testCheckDevideBySmth() {
        assertTrue(myClass.canDevideFifth(5));
        assertTrue(myClass.canDevideFifth(15));
        assertTrue(myClass.canDevideFifth(125));
        assertTrue(myClass.canDevideFifth(525));

        assertTrue(myClass.canDevideThree(3));
        assertTrue(myClass.canDevideThree(12));
        assertTrue(myClass.canDevideThree(333));
        assertTrue(myClass.canDevideThree(999));

        assertTrue(myClass.isParity(2));
        assertTrue(myClass.isParity(88));
        assertTrue(myClass.isParity(222));
        assertTrue(myClass.isParity(2222));

        assertFalse(myClass.canDevideThree(2));
        assertFalse(myClass.canDevideThree(44));
        assertFalse(myClass.canDevideThree(110));

        assertFalse(myClass.isParity(1));
        assertFalse(myClass.isParity(33));
        assertFalse(myClass.isParity(111));

        assertFalse(myClass.canDevideFifth(4));
        assertFalse(myClass.canDevideFifth(44));
        assertFalse(myClass.canDevideFifth(109));

    }

    /**
     * Check all human's actions.
     */
    @Test
    public void testHumanActions() {
        Human human = new Human(
                "John",
                170,
                64.0,
                19,
                Human.Nationality.RUS
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
        assertEquals(HumanProvider.getGeneratedHumanCounter(), Human.getHumanCounter()-1);
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
     * Проверка запрета посещения спа центра для спящих людей.
     */
    @Test
    public void testSpaServiceForbiddenForSleepyVisitors() {
        Spa spa = new Spa();

        Human firstHuman = HumanProvider.getEntity();

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

        Human firstHuman = HumanProvider.getEntity();
        Human secondHuman = HumanProvider.getEntity();
        Human thirdHuman = HumanProvider.getEntity();
        Human fourthHuman = HumanProvider.getEntity();
        Human fifthHuman = HumanProvider.getEntity();

        spa.service(firstHuman, secondHuman, thirdHuman, fourthHuman, fifthHuman);

        assertEquals(5, spa.getTotalVisits());
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
