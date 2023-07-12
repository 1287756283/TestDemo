package Test;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

public class SortTest {

    @Test
    //冒泡排序(实例)
    public void BubbleSort1() {
        int[] arr = {1, 3, 2, 5, 4, 6, 7, 8, 9, 0};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[i] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    @Test
    //冒泡排序(自写)
    public void BubbleSort2() {
        int[] arr = {1, 3, 2, 5, 4, 6, 7, 8, 9, 0};
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //==========================================================================
    @Test
    //插入排序(实例)
    public void InsertSort1() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                System.out.println(11);
            }
        }
        //[8, 9, 7, 6, 5, 4, 3, 2, 1]
        //[8, 7, 9, 6, 5, 4, 3, 2, 1]
        //[7, 8, 9, 6, 5, 4, 3, 2, 1]
        //[7, 8, 6, 9, 5, 4, 3, 2, 1]
        //[7, 6, 8, 9, 5, 4, 3, 2, 1]
        //[6, 7, 8, 9, 5, 4, 3, 2, 1]
        //[6, 7, 8, 5, 9, 4, 3, 2, 1]
        //[6, 7, 5, 8, 9, 4, 3, 2, 1]
        //
        //
        //
        //
        //
        //


        System.out.println(Arrays.toString(arr));
    }


    @Test
    //插入排序(自写)
    public void InsertSort2() {
        int[] arr = {1, 9, 3, 5, 4, 8, 7, 6, 0};
        for (int i = 1; i < arr.length; i++) {
            //遍历的每个值
            int num = arr[i];
            int j;
            //将i赋值给j，每次遍历的值跟
            for (j = i; j > 0 && num < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
        //[1, 2, 3, 5, 4, 6, 7, 8, 9, 0]
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        System.out.println(Arrays.toString(arr));

    }
}
