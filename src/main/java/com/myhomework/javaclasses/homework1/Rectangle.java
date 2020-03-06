package com.myhomework.javaclasses.homework1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Rectangle {

    private final int height;
    private final int width;

    public void getArea(){
        System.out.println(height * width);
    }

}
