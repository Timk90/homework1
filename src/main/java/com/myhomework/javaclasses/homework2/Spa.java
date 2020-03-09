package com.myhomework.javaclasses.homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Relax service for humans, who deserved...
 */
public class Spa {

    /**
     * Еда нашего центра.
     */
    private final List<String> foods = new ArrayList<>();

    /**
     * Число визитов.
     */
    int totalVisitCounter;

    /**
     * Список визитеров.
     */
    private final Map<Human, HumanData> peopleUnderService = new HashMap<>();

    public Spa() {
        foods.addAll(Arrays.asList("Apple", "Egg", "Bread", "Shit", "Nothing", "Milk"));
    }

    /**
     * Подходи, налетай свое тело расслабляй.
     *
     * @param hummy - человечище.
     */
    public void service(Human hummy) {
        if (!hummy.checkSleep()) {
            HumanData humanData;
            Optional<Map<Human, HumanData>> first = Stream.of(peopleUnderService)
                    .filter(e -> e.containsKey(hummy))
                    .findFirst();
            if(first.isPresent()){
                first.ifPresent(e -> e.get(hummy).increaseServiceCounter());
            }else{
                peopleUnderService.put(hummy, new HumanData(hummy));
            }
            humanData = peopleUnderService.get(hummy);
            System.out.println("Сегодня нас удостоил визитом Mr." + hummy.getName() + ". Welcome!");
            hummy.sleep();
            hummy.sleep();
            hummy.walk();
            hummy.eat(foods.get(new Random().nextInt(foods.size())));
            System.out.println("До новых встреч Mr." + hummy.getName() + "! Вы были у нас "+humanData.serviceCounter+" раз.");
        } else {
            System.out.println("Return after wake up");
        }
    }

    /**
     * Подходи, налетай свое тело расслабляй.
     *
     * @param hummies - человечище.
     */
    public void service(Human... hummies) {
        for(Human hummy : hummies) {
            service(hummy);
        }
    }

    /**
     * Подсчет суммарного количества визитов для всех посетителей.
     *
     * @return - общее число визитов.
     */
    public int getTotalVisits(){
        totalVisitCounter = 0;
        for (Map.Entry<Human, HumanData> entry : peopleUnderService.entrySet())
        {
            totalVisitCounter += entry.getValue().serviceCounter;
        }
        return totalVisitCounter;
    }

    /**
     * Данные по каждому визитеру.
     * Сейчас есть только количество посещений.
     *
     * Можно добаваить, что угодно, например:
     * - срок истечения абонемента
     * - ограничитель числа визитов
     * - дата покупки абонемента
     * - какие-то внутренние скидочные баллы и тп.
     */
    private final class HumanData {

        Human human;
        int serviceCounter;

        public HumanData(Human human) {
            this.human = human;
            serviceCounter = 1;
        }

        public void increaseServiceCounter() {
            serviceCounter++;
        }

        public int getServiceCounter() {
            return serviceCounter;
        }
    }
}
