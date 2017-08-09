package com.aidar.datastructure.quetoandvalue;

/**
 * @desc
 * @date 17-6-30
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        String s = "a";
        Test test = new Test();
        test.change(a,s);
        test.display(a,s);
        test.change(a[0],s);
        test.display(a,s);
    }

    public void change(int[] b, String ss){
        b[0] = 4;
        ss = "b";
    }

    public void change(int b, String ss){
        b = 5;
        ss = "c";
    }

    public void display(int[] b, String ss){
        for(int bs:b){
            System.out.print(bs + " ");
        }
        System.out.println("; " + ss);
    }
}
