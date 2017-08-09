package com.aidar.geberic_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc 数组的协变
 * @date 17-7-20
 */
public class CovariantArrays {
    public static void main(String[] args) {
        //创建了一个 cat 数组并把它赋给 Animal 数组的引用。这是有意义的，Cat 是 Animal 的子类，一个 Cat 对象也是一种 Animal 对象，所以一个 Cat 数组也是一种 Animal 的数组,这称作数组的协变
        //尽管 Cat[] 可以 “向上转型” 为 Animal[]，但数组元素的实际类型还是 Cat，我们只能向数组中放入 Cat或者 Cat的子类
        Animal[] cat = new Cat[10];
        cat[0] = new Cat();
        cat[1] = new LittleCat();
        //对于编译器来说，这是可以通过编译的，但是在运行时期，JVM 能够知道数组的实际类型是 cat[]，所以当其它对象加入数组的时候就会抛出异常
//        try {
//            cat[0] = new Animal();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            cat[0] = new Dog();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(cat.getClass());

    }
}
