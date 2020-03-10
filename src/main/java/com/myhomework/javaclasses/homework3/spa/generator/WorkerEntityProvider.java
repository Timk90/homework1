package com.myhomework.javaclasses.homework3.spa.generator;

import com.myhomework.javaclasses.homework3.spa.Developer;
import com.myhomework.javaclasses.homework3.spa.Employee;
import com.myhomework.javaclasses.homework3.spa.Manager;
import com.myhomework.javaclasses.homework3.spa.Tester;
import com.myhomework.javaclasses.homework3.spa.Worker;
import com.myhomework.javaclasses.homework3.spa.generator.DeveloperGenerator;
import com.myhomework.javaclasses.homework3.spa.generator.EmployeeGenerator;
import com.myhomework.javaclasses.homework3.spa.generator.ManagerGenerator;
import com.myhomework.javaclasses.homework3.spa.generator.TesterGenerator;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * Генератор рабочих (сущностей имплементируюих интерфейс {@link Worker}
 * @param <T> - ограничивающий типизированный параметр (worker и его наследники).
 */
public class WorkerEntityProvider<T extends Worker> {

    private static HashMap<Class<? extends Worker>, Supplier<? extends Worker>> providersMap = new HashMap<>();

    /**
     * Статический блок.
     * Заполнение всех возможных стратегий для генератора.
     */
    {
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
        if (providersMap.containsKey(workerClass)) {
            return (T) providersMap.get(workerClass).get();
        }
        return null;
    }
}
