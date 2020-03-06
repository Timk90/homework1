package com.myhomework.javaclasses.homework1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Example of using lombok framework.
 * It is an easy way to implements all the commonly used methods like getters/setters.
 * Useful to avoid a repeatable code.
 * there are several ways to define constuctors:
 * 1) required  args  - for all the private fields,
 * 2) all args - for all the fields,
 * 3) no args - for no fields
 *
 */
@Data
@RequiredArgsConstructor
public class Brick {

    private final String name;
    private final int height;
    private final int width;
    private final int length;

    public void getTopBottomArea(){
        System.out.println(this.name+" ground area: "+this.width * this.length);
    }
    public void getSideArea(){
        System.out.println(this.name+" side area: "+this.height * this.length);
    }
    public void getFrontArea(){
        System.out.println(this.name+" front area: "+this.width * this.height);
    }
    public void getVolume(){
        System.out.println(this.name+" volume: "+this.width * this.height * this.length);
    }
    public void getAllSides(){
        System.out.println(
                this.name+" ground area: "+this.width * this.length+
                        " side area: "+this.height * this.length+
                        " front area: "+this.width * this.height
        );
    }
}
