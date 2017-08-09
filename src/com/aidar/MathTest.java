package com.aidar;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @desc Math类
 * @date 17-7-3
 */
public class MathTest {
    public static void main(String[] args) {

        //round()返回四舍五入后的整数(Long)
        Object object = Math.round(1.40);
        System.out.println(object + ";" + (object instanceof Double) + ";" + (object instanceof Float) + ";" + (object instanceof Long));
        System.out.println(Math.round(1.50));
        //floor()返回小于参数的最大整数(Double)
        Object object1 = Math.floor(1.40);
        System.out.println(object1 + ";" + (object1 instanceof Double) + ";" + (object1 instanceof Float));
        System.out.println(Math.floor(1.50));
        //ceil()返回大于参数的最大整数(Double)
        Object object2 = Math.ceil(1.40);
        System.out.println(object2 + ";" + (object2 instanceof Double) + ";" + (object2 instanceof Float));
        System.out.println(Math.ceil(1.50));
        //random()返回(0,1)之间的随机浮点数(Double)
        Object object3 = Math.random();
        System.out.println(object3 + ";" + (object3 instanceof Double) + ";" + (object3 instanceof Float));

    }
}
