package com.aidar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @desc
 * @date 17-7-3
 */
public class StringTest {
    public static void main(String[] args) throws Exception {

        //a指向String池中的”hello2”对象
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        //变量b被final修饰，因此会被当做编译器常量，所以在使用到b的地方会直接将变量b 替换为它的值,最终c指向String池中的”hello2”对象
        String c = b + 2;
        System.out.println("c = " + c);
        String c1 = b.concat("2");
        System.out.println("c1 = " + c1);
        //用+连接字符串时，实际上是在堆内容创建对象，那么e指向的是堆内存存储”abc”字符串的空间首地址
        String e = d + 2;
        System.out.println("e = " + e);
        System.out.println((a == c) + " " + a.equals(c));
        System.out.println((a == c1) + " " + a.equals(c1));
        System.out.println((a == e) + " " + a.equals(e));
        StringBuffer f = new StringBuffer();
        f.append("hello2");
        System.out.println(f);
        //equals既比较对象类型也比较值
        System.out.println(a.equals(f));
        System.out.println(a.equals(f.toString()));
        //compareto(String)是依次比较字符串的每个字符的大小
        System.out.println(a.compareTo(f.toString()));
        System.out.println(("abcdef").compareTo("zyxwvu"));
        System.out.println("********************************");
        int i = 0;
        int j =0;
        System.out.println(i==j);
        Integer k = 100;
        Integer l = 100;
        System.out.println((k == l) + " " + k.equals(l));

        Integer m = 200;
        Integer n = 200;
        System.out.println((m == n) + " " + m.equals(n));

        Calendar canlendar = new GregorianCalendar();
        System.out.println("minute:" + canlendar.get(Calendar.MINUTE));
        System.out.println("second:" + canlendar.get(Calendar.SECOND));

        //将int转为String
        String str1 = String.valueOf(m);
        String str2 = Integer.toString(i);
        String str3 = i + "";
        System.out.println(str1 + ";" + str2 + ";" + str3 + ";");
        //radix默认为10,2*10*10;设置为16时,为2*16*16
        int int1 = Integer.valueOf(str1,16);
        int int3 = Integer.valueOf(str1);
        int int2 = Integer.parseInt(str1);
        System.out.println(int1 + ";"+ int3 + ";" + int2 + ";");
    }
}
