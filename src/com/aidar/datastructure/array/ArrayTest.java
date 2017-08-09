package com.aidar.datastructure.array;

/**
 * @desc
 * @date 17-6-13
 */
public class ArrayTest {
    public static void main(String[] args) {
        //int数组初始化默认为0
        int[] a = new int[10];
        System.out.println(a[1]);
        //String数组初始化默认为null
        String[] s = new String[10];
        System.out.println(s[1]);
        //long数组初始化默认为0
        long[] l = new long[10];
        System.out.println(l[1]);
        //double数组初始化默认为0.0
        double[] d = new double[10];
        System.out.println(d[1]);

        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int nElems = array.length;
        int searchKey = 7;
        int i = 0;

//        //break查询到数据后退出循环
//        System.out.println("************break查询到数据后退出循环************");
//        for(i=0; i < nElems;i++){
//            System.out.print( i + "; ");
//            if(searchKey == array[i]) {
//                break;
//            }
//        }
//        System.out.println();
////        if(nElems == i) {
////            System.out.println("该数据不存在于数组中");
////        }
////        System.out.println("找到该数据: " + array[i]);
//
//        //continue查询到数据后退出循环
//        System.out.println("************continue查询到数据后继续查询************");
//        for(i=0; i < nElems;i++){
//            System.out.print( i + "; ");
//            if(searchKey == array[i]) {
//                continue;
//            }
//        }
//        System.out.println();
//        if(nElems == i)
//            System.out.println("该数据不存在于数组中");
//        System.out.println("找到该数据: " + array[i]);

        System.out.println("***********break外层循环等于7*************");
        int j=0,k=0;
        for(j=0; j<nElems;j++){
            System.out.print(j + ": ");
            for (k=0; k<nElems; k++){
                System.out.print(k + "; ");
                if(searchKey == j){
                    System.out.print("找到7; ");
                    break;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("***********break内层循环等于7*************");
        for(j=0; j<nElems;j++){
            System.out.print(j + ": ");
            for (k=0; k<nElems; k++){
                System.out.print(k + "; ");
                if(searchKey == k){
                    System.out.print("找到7; ");
                    break;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("***********continue外层循环等于7*************");
        for(j=0; j<nElems;j++){
            System.out.print(j + ": ");
            for (k=0; k<nElems; k++){
                System.out.print(k + "; ");
                if(searchKey == j){
                    System.out.print("找到7; ");
                    continue;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("***********continue内层循环等于7*************");
        for(j=0; j<nElems;j++){
            System.out.print(j + ": ");
            for (k=0; k<nElems; k++){
                System.out.print(k + "; ");
                if(searchKey == k){
                    System.out.print("找到7; ");
                    continue;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
