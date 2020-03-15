package com.myhomework.javaclasses;

import com.myhomework.javaclasses.homework1.MyClass;
import com.myhomework.javaclasses.homework2.Human;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class Homework1Tests
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

    @Test
    public void testMultiplixationTwo(){
        assertEquals(Integer.MAX_VALUE-1, MyClass.doMultiplyTwo(Integer.MAX_VALUE/2));
        assertEquals(0, MyClass.doMultiplyTwo(Integer.MAX_VALUE));
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
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Homework1Tests(String testName) {
        super(testName);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
