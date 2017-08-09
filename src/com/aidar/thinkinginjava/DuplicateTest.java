package com.aidar.thinkinginjava;

/**
 * @desc
 * @date 17-5-5
 */
public class DuplicateTest {
    public static int duplicate(int[] number) {
        if (number == null || number.length < 1) {
            return -1;
        }
        // 判断输入的是否在[0, number.length-1]之间
        for (int i : number) {
            if (i < 0 || i >= number.length) {
                return -1;
            }
        }
        for (int i = 0; i < number.length; i++) {
            // 当number[i]与i不相同的时候一直交换
            while (number[i] != i) {
                // 如果i位置与number[i]位置的数字相同，说明有重复数字
                if (number[i] == number[number[i]]) {
                    return number[i];
                }
                // 如果不同就交换
                else {
                    swap(number, i, number[i]);
                }
            }
        }
        return -1;
    }
    private static void swap(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }
    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(duplicate(numbers1));
        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(duplicate(numbers2));
        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplicate(numbers3));
        int[] numbers4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 16, 19, 18, 21, 20, 23, 22, 25, 24, 27, 26, 29, 28, 31, 30, 34, 35, 32, 33, 38, 39, 36, 37, 42, 43, 40, 41, 46, 47, 44, 45, 51, 50, 49, 48, 55, 54, 53, 52, 59, 58, 57, 56, 63, 62, 61, 60, 68, 69, 70, 71, 64, 65, 66, 67, 76, 77, 78, 79, 72, 73, 74, 75, 85, 84, 87, 86, 81, 80, 83, 82, 93, 92, 95, 94, 89, 88, 91, 90, 98, 99, 96, 97};
        System.out.println(numbers4.length);
        System.out.println(duplicate(numbers4));
    }
}
