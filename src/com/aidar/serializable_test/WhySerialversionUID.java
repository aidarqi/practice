package com.aidar.serializable_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @desc
 * @date 17-7-12
 */
public class WhySerialversionUID {
    public static void main(String[] args) throws Exception {

        //这里是把对象序列化到文件
//        Person crab = new Person();
//        crab.setName("Mr.Crab");
//
//        ObjectOutputStream oo = new ObjectOutputStream
//            (new FileOutputStream("crab_file"));
//        oo.writeObject(crab);
//        oo.close();

//        这里是把对象序列化到文件，我们先注释掉，一会儿用
        ObjectInputStream oi = new ObjectInputStream
            (new FileInputStream("crab_file"));
        Person crab_back = (Person) oi.readObject();
        System.out.println("Hi, My name is " + crab_back.getName());
        oi.close();

    }
}
