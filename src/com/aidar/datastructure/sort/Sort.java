package com.aidar.datastructure.sort;

/**
 * @desc
 * @date 17-6-13
 */
public class Sort {
    int[] a = {5,7,3,4,9,6,2,8,1,0};
    int[] b = {5,7,3,4,9,6,2,8,1,0};
    int[] c = {5,7,3,4,9,6,2,8,1,0};
    int length = 10;
    public static void main(String[] args) {
        Sort sort = new Sort();
//        sort.bubbleSort(sort.a);
//        sort.selectSort(sort.b);
        sort.insertSort(sort.c);
    }

    public void bubbleSort(int[] b){
        for(int i=0; i<length; i++){
            for(int j=i; j<length; j++){
                if(b[j]<b[i]){
                    swap(j, i, b);
                }
            }
        }
        display(b);
    }

    public void selectSort(int[] b){
        int k = 0;
        for(int i=0; i<length; i++){
            int min =a[i];
            for(int j=i; j<length; j++){
                if(b[j]<min){
                    min = b[j];
                    k = j;
                }
            }
            swap(i, k, b);
        }
        display(b);
    }

    public void insertSort(int[] b){
        int k = 0;
        int j = 0;
        for(int i=1; i<length; i++){
            k = b[i];
            j = i - 1;
            while (j >=0 && b[j]>k){
                b[j+1] = b[j];
                j--;
            }
            b[j+1] = k;
        }
        display(b);
    }

    public void swap(int m, int n, int[] a){
        int temp = 0;
        temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    public void display(int[] b){
        for(int i=0; i<length; i++){
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }

//    public void display(){
//        for(int i=0; i<length; i++){
//            System.out.print(a[i] + " ");
//        }
//        System.out.println();
//    }
}
