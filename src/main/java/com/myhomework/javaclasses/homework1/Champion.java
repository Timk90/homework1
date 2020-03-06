package com.myhomework.javaclasses.homework1;

/**
 * Чемпион.
 */
public class Champion {

    private String name = "Unknown";
    private int strength = 0;
    private int agility = 0;
    private int intelligence = 0;
    private int sum = 0;

    /**
     * Обычный способ создания чемпиона - конструтор.
     *
     * @param name         имя
     * @param agility      ловкость
     * @param intelligence интеллект
     * @param strength     сила
     */
    public Champion(
            String name,
            int agility,
            int intelligence,
            int strength
    ) {
        this.name = name;
        this.agility = agility;
        this.strength = strength;
        this.intelligence = intelligence;
        getSum();
    }

    /**
     * Подсчет общей мощности чемпиона.
     */
    private void getSum() {
        sum = strength + intelligence + agility;
    }

    /**
     * Приватный конструктор для билдера.
     */
    private Champion() {
    }

    /**
     * Инициализация билдера.
     *
     * @return билдер.
     */
    public static Builder builder() {
        return new Champion().new Builder();
    }

    /**
     * Метод сравнения двух чемпионов.
     *
     * @param champion1 первый чемпион
     * @param champion2 второй чемпион
     */
    public static void compareChampions(Champion champion1, Champion champion2) {
        if (champion1.sum == champion2.sum) {
            System.out.println("Both champions are equal" );
            return;
        }
        if (champion1.sum > champion2.sum) {
            System.out.println(champion1.name + " is champion." );
        } else {
            System.out.println(champion2.name + " is champion." );
        }
    }

    /**
     * Внутренни класс - билдер.
     * Билдеры нужны для создания сложных объектов, имеющих большое количество полей
     * и когде нецелесообразно описывать множество конструктор для всевозможных комбинаций этих полей.
     */
    public class Builder {

        public Builder name(String string) {
            Champion.this.name = string;
            return this;
        }

        public Builder agility(int agility) {
            Champion.this.agility = agility;
            return this;
        }

        public Builder strength(int strength) {
            Champion.this.strength = strength;
            return this;
        }

        public Builder intelligence(int intelligence) {
            Champion.this.intelligence = intelligence;
            return this;
        }

        public Champion build() {
            getSum();
            return Champion.this;
        }
    }
}
