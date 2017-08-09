package com.aidar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @desc 日期转换
 * @date 17-7-3
 */
public class DateTest {
    public static void main(String[] args) throws ParseException{
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdfFormat = sdf.format(date);
        System.out.println("date转为String类型: " + sdfFormat);
        Date date2 = sdf.parse(sdfFormat);
        System.out.println("将标准化后的String转为date: " + date2);

//        String str = "2017年7月3号10点10分";
        String str = "2017-7-3 10:10:10";
        Date date1 = sdf.parse(str);
        System.out.println("String类型转为date: " + date1);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Date date3 = calendar.getTime();
        System.out.println("将Calendar对象转换为Date对象: " + date3);
    }
}
