package com.aidar;

/**
 * @desc
 * @date 17-7-7
 */
public class SystemAndRuntimeTest {
    public static void main(String[] args) {

        /*
         * System.arraycopy
         */
        int [] a = {1,2,9,5,8,3,4,7,6};
        int[] b = {10,11,12,13};
        //将ａ的srcPos后length长度的字符复制给ｂ的destPos１起始距离后length的字符替换
        System.arraycopy(a,1,b,1,3);
        for(int bi :b ) {
            System.out.print(bi + " ");
        }
        System.out.println();

//        //报错"ArrayStoreException",数组类型不匹配
//        char[] c ={'a', 'b', 'c'};
//        System.arraycopy(a,1,c,1,1);
//        for(int bi :c ) {
//            System.out.print(bi + " ");
//        }
//        System.out.println();
//
//        //报错"java.lang.NullPointerException",d为null
//        int[] d = null;
//        System.arraycopy(a,1,d,0,0);
//        for(int bi :d) {
//            System.out.print(bi + " ");
//        }
//        System.out.println();

        /*
         * 其它
         */
        System.out.println(System.currentTimeMillis());
        System.out.println(System.getProperties());
        String str = "aaa";
        System.out.println(System.getProperty(str));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.homes","qq"));
        System.out.println(System.console());
        System.out.println(Runtime.getRuntime());
        System.out.println(Runtime.getRuntime().totalMemory());

    }
}
