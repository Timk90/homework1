package com.myhomework.javaclasses.homework3;

import com.myhomework.javaclasses.homework3.generator.DeveloperGenerator;
import com.myhomework.javaclasses.homework3.generator.EmployeeGenerator;
import com.myhomework.javaclasses.homework3.generator.ManagerGenerator;
import com.myhomework.javaclasses.homework3.generator.TesterGenerator;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * Генератор рабочих (сущностей имплементируюих интерфейс {@link Worker}
 * @param <T> - ограничивающий типизированный параметр (worker и его наследники).
 */
public class WorkerEntityProvider<T extends Worker> {

    private static HashMap<Class<? extends Worker>, Supplier<? extends Worker>> providersMap = new HashMap<>();

    /**
     * Заполнение всех возможных стратегий для генератора.
     */
    private static void fillAllStrategies() {
        providersMap.put(Developer.class, DeveloperGenerator::getEntity);
        providersMap.put(Employee.class, EmployeeGenerator::getEntity);
        providersMap.put(Manager.class, ManagerGenerator::getEntity);
        providersMap.put(Tester.class, TesterGenerator::getEntity);
    }

    /**
     * Получить сущность, если для нее нашлась стратегия.
     *
     * @param workerClass - класс наследник от {@link Worker}
     * @param <T> - конкретная реализация интерфейса, которая будет создана.
     * @return - объект наследник {@link Worker}, по указанному классу.
     */
    public static <T extends Worker> T getEntity(Class<? extends Worker> workerClass) {
        fillAllStrategies();
        if (providersMap.containsKey(workerClass)) {
            return (T) providersMap.get(workerClass).get();
        }
        return null;
    }
}
