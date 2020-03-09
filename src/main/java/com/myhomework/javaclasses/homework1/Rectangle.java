package com.myhomework.javaclasses.homework1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Прямоугольник.
 */
@Data
@RequiredArgsConstructor
public class Rectangle {

    private final int height;
    private final int width;

    /**
     * Вычислить площадь.
     */
    public void getArea() {
        System.out.println(height * width);
    }

}
