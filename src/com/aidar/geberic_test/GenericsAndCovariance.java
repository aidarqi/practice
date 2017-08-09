package com.aidar.geberic_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc 在了解了子类型边界和超类型边界之后，我们就可以知道如何向泛型类型中 “写入” ( 传递对象给方法参数) 以及如何从泛型类型中 “读取” ( 从方法中返回对象 )
 *           public class Collections {
 *               public static <T> void copy(List<? super T> dest, List<? extends T> src)
 *               {
 *                   for (int i=0; i<src.size(); i++)
 *                   dest.set(i,src.get(i));
 *               }
 *           }
 *       src 是原始数据的 List，因为要从这里面读取数据，所以用了上边界限定通配符：<? extends T>，取出的元素转型为 T。
 *       dest 是要写入的目标 List，所以用了下边界限定通配符：<? super T>，可以写入的元素类型是 T 及其子类型。
 * @date 17-7-20
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {

        //*************上边界限定通配符****************
        List<? extends Animal> list = new ArrayList<Cat>();
        //不能添加任何对象，编译没法通过
        //我们指定泛型参数为 <? extends Animal> 时，add() 方法的参数变为 ? extends Animal，编译器无法判断这个参数接受的到底是 Animal 的哪种类型，所以它不会接受任何类型
//        list.add(new Cat());
//        list.add(new Animal());
//        list.add(new Object());
        //查看 ArrayList 的源代码，可以发现 add() 接受一个泛型类型作为参数，但是 contains 和 indexOf 接受一个 Object 类型的参数
        //如果某些方法不允许类型参数是通配符时的调用，这些方法的参数应该用类型参数，比如 add(E e)
        list.contains(new Cat());
        list.add(null);
        //在这个 List 中，不管它实际的类型到底是什么，但肯定能转型为 Animal，所以编译器允许返回 Animal。
        Animal animal = list.get(0);


        List<? extends Animal> list1 = Arrays.asList(new Cat());
        //泛型参数使用了受限制的通配符，我们失去了向其中加入任何类型对象的例子，所以无法编译。
//        list.add(new Cat());
        //        list.add(new Animal());
        //        list.add(new Object());
        list1.contains(new Cat());
        list1.contains(new Animal());
        list1.indexOf(new Cat());
        //在这个 List 中，不管它实际的类型到底是什么，但肯定能转型为 Animal，所以编译器允许返回 Animal。
        Animal animal１ = list1.get(0);
        Cat cat = (Cat)list1.get(0);
    }




    //*******************下边界限定通配符*********************
    static void writeTo(List<? super Cat> cats) {
        //List<? super Cat> cats 表示某种类型的 List，这个类型是 Cat 的基类型,即这个类型肯定是 Cat 的父类型
        //我们可以知道向这个 List 添加一个 Cat 或者其子类型的对象是安全的，这些对象都可以向上转型为 Cat。但是我们不知道加入 Animal 对象是否安全，因为那样会使得这个 List 添加跟 Cat 无关的类型。
        cats.add(new Cat());
        cats.add(new LittleCat());
        //编译不能通过
//        cats.add(new Animal());
    }


    //********************无边界通配符**********************
    /*List<?> list 表示 list 是持有某种特定类型的 List，但是不知道具体是哪种类型。那么我们可以向其中添加对象吗？当然不可以，因为并不知道实际是哪种类型，所以不能添加任何类型，这是不安全的。
    而单独的 List list ，也就是没有传入泛型参数，表示这个 list 持有的元素的类型是 Object，因此可以添加任何类型的对象，只不过编译器会有警告信息。*/
    List<?> list2 = new ArrayList<>();
    List list3 = new ArrayList();
    static void getTo(List<?> lists) {
//        lists.add("1");
        lists.add(null);
        lists.get(1);
    }


}
