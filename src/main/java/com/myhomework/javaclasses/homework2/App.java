package com.myhomework.javaclasses.homework2;

public class App {
    public static void main(String[] args) {
        Human human = HumanProvider.getEntity();
        System.out.println(human);
    }
}
