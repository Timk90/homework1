package com.myhomework.javaclasses.homework2;

/**
 * Human like me and you...
 */
public class Human {

    /**
     * Имя.
     */
    private final String name;

    /**
     * Рост (см).
     */
    private int height;

    /**
     * Вес (кг).
     */
    private double weight;

    /**
     * Возраст (лет).
     */
    private int age;

    /**
     * Национальность.
     */
    private Nationality nationality;

    /**
     * И всякая тварь будет сосчитана и поставлена на учет.
     */
    private static int humanCounter = 0;

    /**
     * спит?
     */
    private boolean isAsleep;

    public Human(String name,
                 int height,
                 double weight,
                 int age,
                 Nationality nationality
    ) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.nationality = nationality;
        isAsleep = false;
        increment();
    }

    public Human() {
        this.name = "Unknown";
        this.age = 0;
        this.height = 0;
        this.weight = 0.0;
        this.nationality = Nationality.NONE;
        this.isAsleep = false;
    }

    private static void increment() {
        humanCounter++;
    }

    public void eat(String food) {
        if (!checkSleep()) {
            System.out.println(this.name + " съел " + food);
        }
    }

    public void walk() {
        if (!checkSleep()) {
            System.out.println(this.name + " погулял...");
        }
    }

    public void sleep() {
        String message = !isAsleep ? " лег спать" : " проснулся";
        isAsleep = !isAsleep;
        System.out.println(this.name + message);
    }

    public String getNation() {
        return this.nationality.country;
    }

    public String getName() {
        return name;
    }

    public boolean checkSleep() {
        if (isAsleep) {
            System.out.println(this.name + " спит...zzzzz....zzzzz....zzzzz....");
            return true;
        }
        return false;
    }

    public static int getHumanCounter() {
        return humanCounter;
    }

    /**
     * Национальность.
     */
    public enum Nationality {
        NONE("Unknown", 1),
        RUS("Russia", 2),
        FR("France", 3),
        ENG("England", 4),
        SP("Spain", 5),
        UN("United States", 6),
        ;

        String country;

        int number;

        Nationality(String country, int number) {
            this.country = country;
            this.number = number;
        }

        public static Nationality getByNumber(int number) {
            return Nationality.values()[number];
        }
    }
}
