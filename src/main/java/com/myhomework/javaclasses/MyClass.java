package com.myhomework.javaclasses;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Вот тот самый класс с дз.
 */
public class MyClass {

    public static void doNothing(){

    }

    public static long doMultiplyTwo(int a){
        return 2*a;
    }

    public static void showSum(int a, int b){
        System.out.println(a+b);
    }

    public void methodWorks(){
        System.out.println("it works!");
    }

    public void showStrCountTimes(String str, int count){
        Stream.iterate(0, i -> ++i).limit(count).forEach(i -> System.out.println(str+" "));
    }

    public boolean isValueGraterThanZero(int a){
        return a > 0;
    }

    public void printArray(Object[] objects){
        Arrays.stream(objects).forEach(e -> System.out.print(e+" "));
    }

    public boolean isParity(int value){
        return value % 2 == 0;
    }

    public boolean canDevideThree(int value){
        return value % 3 == 0;
    }

    public boolean canDevideFifth(int value){
        return value % 5 == 0;
    }

    public int capacity(int value){
        return Integer.toBinaryString(value).length();
    }
}
