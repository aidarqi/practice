package com.aidar.geberic_test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc 原始类型（raw type）就是擦除去了泛型信息，最后在字节码中的类型变量的真正类型。无论何时定义一个泛型类型，相应的原始类型都会被自动地提供。
 *       类型变量被擦除（crased），并使用其限定类型（无限定的变量用Object）替换。
 *       泛型类中的静态方法和静态变量不可以使用泛型类所声明的泛型类型参数。
 *       因为泛型类中的泛型参数的实例化是在定义对象的时候指定的，而静态变量和静态方法不需要使用对象来调用。对象都没有创建，如何确定这个泛型参数是何种类型，所以当然是错误的。
 * @date 17-7-20
 */
public class ArrayAlg {
    public static <T> T getMiddle(T... a) {
        return a[a.length/2];
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String middle = ArrayAlg.getMiddle("John", "Q.", "Pub", "qq");
        System.out.println(middle);

        //无法编译通过
//        String middle1 = ArrayAlg.getMiddle(30.14, 1000,10);
//        String middle2 = ArrayAlg.getMiddle("hello", 0);
//        String middle3 = ArrayAlg.getMiddle("hello", 0, null);
        Object middle3 = ArrayAlg.getMiddle("hello", 0, null);
        System.out.println(middle3);
        Number middle4 = ArrayAlg.<Number>getMiddle(1, 1.2,2);
        System.out.println(middle4.getClass());



        ArrayList arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add("qq");
        arrayList.add(new Date());
        System.out.println(arrayList.get(0).getClass());
        //运行时类型查询只适用于原始类型
        //        System.out.println(arrayList instanceof ArrayList<Integer>);
        System.out.println(arrayList instanceof List);

        List<?> objects = new ArrayList<String>();
//                objects.add(new Object());

        //不能用基本类型实例化参数
        //        List<Int> list = new ArrayList<>();



/*        第一种情况，可以实现与完全使用泛型参数一样的效果，第二种则完全没效果。
        因为，本来类型检查就是编译时完成的。new ArrayList()只是在内存中开辟一个存储空间，可以存储任何的类型对象。
        而真正涉及类型检查的是它的引用，因为我们是使用它引用arrayList1 来调用它的方法，比如说调用add()方法。所以arrayList1引用能完成泛型类型的检查。*/
        ArrayList<String> arrayList1=new ArrayList();//第一种 情况
//        arrayList1.add(1);
        arrayList1.add("qq");
//        arrayList1.add(new Date());

        ArrayList arrayList2=new ArrayList<String>();//第二种 情况
        arrayList2.add(1);
        arrayList2.add("qq");
        arrayList2.add(new Date());
        //返回类型是Object,Integer＆String接受报错
//        Integer s = arrayList2.get(0);
//        String s = arrayList2.get(0);
          Object s = arrayList2.get(0);
        System.out.println(arrayList2.get(0).getClass());
        System.out.println(s.getClass());


        //ArrayList<Integer>被擦除类型后，原始类型也变成了Object，所以通过反射我们就可以存储字符串了
        ArrayList<Integer> arrayList3=new ArrayList<Integer>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        for (int i=0;i<arrayList3.size();i++) {
            System.out.println(arrayList3.get(i));
            //报错：Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
            //public E get(int index){} 会根据泛型变量进行强转
//            System.out.println("类型： " +arrayList3.get(i).getClass());
        }

    }
}
