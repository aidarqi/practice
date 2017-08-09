package com.aidar.datastructure.quetoandvalue;

/**
 * @desc Java不允许程序员选择按值传递还是按引用传递各个参数;
 *       基本类型的变量是按值传递的(byte,short,int,long,float,double,boolean,char)
 *       对象是将对象的引用(也可说对象的首地址)传递给方法,但对象引用本身也是按值传递的
 *       具体来说,就是将对象引用的副本传给方法(副本说明此时对象有两个引用)
 *       通过操作对象引用,方法可以直接操作并改变该对象
 *       但操作引用时,源对象没有改变
 * @date 17-6-14
 */
public class QuetoAndValue {
    String str = new String("hello");
    char[] ch = {'a','b','c'};
    int i = 0;

    private String nn = new String("1");
    private String[] mm = {"2","5"};

    public static void main(String[] args){

        QuetoAndValue qav = new QuetoAndValue();

//        qav.change(qav.str, qav.ch, qav.i);
//        System.out.println(qav.str + " " + qav.ch[0] +qav.ch[1] + qav.ch[2] + " " + qav.i + ";");
//
//        qav.change(qav.str, qav.ch[0], qav.i);
//        System.out.println(qav.str + " " + qav.ch[0] +qav.ch[1] + qav.ch[2] + " " + qav.i + ";");

        StringBuffer buffA = new StringBuffer("a");
        StringBuffer buffB = new StringBuffer("b");
        qav.change(buffA,buffB);
        System.out.println(buffA+","+buffB);

        qav.test(qav.nn,qav.mm);
        System.out.println(qav.nn+"  "+qav.mm[0]);
    }

    //str传来String类型引用,ch传来数组对象引用,i传来的是值
    public void change(String str, char[] ch, int i){
        str = "world";
        ch[0] = 'd';
        //值在方法中的变化不改变源
        i++;
    }

    //str传来String类型引用,ch传来数组值,i传来的是值
    public void change(String str, char ch, int i){
        str = "world";
        //传来值,不影响源结果
        ch = 'e';
        //等号左边的i是属性i，等号右边的i是局部变量（入参里的i）
        this.i = i+1;
    }

    public void change(StringBuffer x,StringBuffer y){
        x.append(y);
        System.out.println(x);
        //通过操作引用把x的首地址赋值给引用变量y,但源对象没有改变
        y=x;
        System.out.println(y);
    }

    void test(String nn,String[] mm){

        nn = new String("3");
        this.nn = "9";
        mm[0] = "4";
//        System.out.println("in test(),mm[0]: "+mm[0]);
        //赋值新的对象的引用值,方法体外不起作用
        mm = new String[]{"8","7"};
//        System.out.println("in test(),nn: "+nn);
//        System.out.println("this.nn: "+this.nn);
//        System.out.println("mm[0]: "+mm[0]);
    }
}
