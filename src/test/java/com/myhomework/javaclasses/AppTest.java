package com.myhomework.javaclasses;

import com.myhomework.javaclasses.homework1.MyClass;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    MyClass myClass;

    @Before
    public void setUp() {
        myClass = new MyClass();
    }

    @org.junit.Test
    public void testCapacityCounts() {
        assertEquals(1, myClass.capacity(1));
        assertEquals(2, myClass.capacity(3));
        assertEquals(3, myClass.capacity(7));
        assertEquals(4, myClass.capacity(15));
        assertEquals(5, myClass.capacity(31));
        assertEquals(6, myClass.capacity(63));
        assertEquals(7, myClass.capacity(127));
    }

    @org.junit.Test
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
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
