package com.myhomework.javaclasses;

import lombok.Data;
import lombok.RequiredArgsConstructor;

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
