package com.aidar.transient_test;

import java.io.*;

/**
 * @desc 使用transient关键字不序列化某个变量
 *       注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
 *       使用transient这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化
 * @date 17-7-7
 */
public class TransientTest {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("Alexia");
        user.setPasswd("123456");
        user.setEmail("qq@qq.com");

        System.out.println("read before Serializable: ");
        System.out.println("username0: " + user.getUsername());
        System.out.println("password0: " + user.getPasswd());
        System.out.println("email0: " + user.getEmail());

        try {
            ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream("/home/upsmart/qdm_Test/user.txt"));
            os.writeObject(user); // 将User对象写进文件
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 在反序列化之前改变username的值
            User.username = "jmwang";

            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                "/home/upsmart/qdm_Test/user.txt"));
            user = (User) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable: ");
           /* 被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
            * 反序列化后类中static型变量username的值为当前JVM中对应static变量的值，这个值是JVM中的，不是反序列化得出的．
            */
            System.out.println("username1: " + user.getUsername());
            //一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
            System.out.println("password1: " + user.getPasswd());
            System.out.println("email1: " + user.getEmail());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(user.getClass().getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
