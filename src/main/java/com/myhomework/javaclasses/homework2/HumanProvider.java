package com.myhomework.javaclasses.homework2;

import java.util.Random;

/**
 * Класс для создания случайного человека.
 */
public final class HumanProvider {

    /**
     * Счетчик людей.
     */
    private static int generatedHumanCounter = 0;

    private HumanProvider() {

    }

    public static Human getEntity() {
        generatedHumanCounter++;
        return new Human(
                "Generated human " + generatedHumanCounter,
                (new Random().nextInt() + 1) * 150,
                (new Random().nextDouble() + 0.5) * 100,
                (new Random().nextInt(35) + 1) + 25,
                Human.Nationality.getByNumber(new Random().nextInt(5))
        );
    }

    public static int getGeneratedHumanCounter() {
        return generatedHumanCounter;
    }
}
