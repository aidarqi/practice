package com.aidar.geberic_test;

/**
 * @desc
 * @date 17-7-1
 */
public class Cat extends Animal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Cat();
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Cat);
        System.out.println(animal1 instanceof Animal);
        System.out.println(animal1 instanceof Cat);
    }
}
