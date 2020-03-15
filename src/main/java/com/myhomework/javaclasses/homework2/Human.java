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
        this.name = name.length() > 0 ? name : "Unknown";
        this.height = height > 0 ? height : 0;
        this.weight = weight > 0 ? weight : 0;
        this.age = age > 0 ? age : 0;
        this.nationality = nationality != null ? nationality : Nationality.NONE;
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
     * <a href=https://ru.wikipedia.org/wiki/%D0%98%D0%BD%D0%B4%D0%B5%D0%BA%D1%81_%D0%BC%D0%B0%D1%81%D1%81%D1%8B_%D1%82%D0%B5%D0%BB%D0%B0>BMI</a>
     *
     * @return - BMI (body mass index)
     */
    public String getBMI() {
        return height > 0 && weight > 0 ? String.format("BMI is : %.2f", weight / Math.pow(height/100f, 2.0)) : "Incorrect heigh/weight values.";
    }

    /**
     * Человек представляется.
     */
    public void introduce(){
        System.out.println("My name is "
                +this.name+", I am from "+this.getNation()
                +" and my weight is "+this.weight
                +". I am tall "+this.height
                +". I am "+this.age+" y.o");
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

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + String.format("%.2f",weight) +
                ", age=" + age +
                ", nationality=" + nationality +
                ", isAsleep=" + isAsleep +
                '}';
    }
}
