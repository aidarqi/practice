package com.aidar.thinkinginjava.quote;

/**
 * @desc
 * @date 17-7-19
 */
public class Alias2 {
    int i;
    Alias2(int ii) {
        i = ii;
    }
    static void f(Alias2 handle) {
        handle.i++;
    }
    public static void main(String[] args) {
        Alias2 x = new Alias2(7);
        Alias2 y = x;
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
        System.out.println("Calling f(x)");
        f(x);
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
        System.out.println("Calling f(y)");
        f(y);
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
    }
}
