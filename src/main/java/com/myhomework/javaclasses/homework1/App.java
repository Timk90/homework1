package com.myhomework.javaclasses.homework1;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.showStrCountTimes("Hello, world!", 10);
        myClass.printArray(new Object[]{10f, 123L, "shit", true, new MyClass(), 1 < 3});
        new Rectangle(5, 6).getArea();
        Brick brick = new Brick("First brick", 5, 10, 20);
        brick.getVolume();
        brick.getAllSides();
        System.out.println();
        Champion champion1 = new Champion("First", 10, 15, 25);
        Champion champion2 = new Champion("Second", 10, 15, 25);
        Champion.compareChampions(champion1, champion2);

        Champion buldedChampion1 = Champion.builder()
                .agility(12)
                .intelligence(10)
                .name("Unknown 1" )
                .strength(500)
                .build();

        Champion buldedChampion2 = Champion.builder()
                .agility(12)
                .intelligence(10)
                .name("Unknown 2" )
                .strength(502)
                .build();

        Champion.compareChampions(buldedChampion1, buldedChampion2);
    }

}
