package com.hello.algorithm;

import java.util.HashMap;

public class BinaryChopMain {

    public static void main(String arg[]) {
        //10,2,[1,1,2,3,7,7,7,9,9,10]
        int[] a = new int[]{2, 3, 4, 4, 4, 7, 7, 8, 10, 10, 11, 12, 13, 14, 15, 15, 17, 18,
                19, 23, 24, 24, 24, 24, 25, 26, 26, 26, 27, 27, 28, 29, 29, 30, 33, 36, 38, 38, 40, 40, 41, 43, 43, 43, 44, 46, 46, 47, 51, 52, 52, 53, 54, 56, 57, 57, 57, 58, 58, 61, 61, 61, 62, 64, 64, 66, 66, 67, 67, 67, 70, 72, 74, 74, 74, 75, 75, 78, 78, 78, 79, 79, 80, 83, 83, 83, 83, 84, 84, 86, 88, 89, 89, 90, 91, 91, 92, 93, 93, 96};
        int[] b = {1};
        System.out.println("result===>" + upper_bound_(1, 1,b));
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_(int n, int v, int[] a) {
        if (v < a[0] || v > a[n - 1]) {
            return n + 1;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (v <= a[mid]) {
                //在左侧
                right = mid;
            } else {
                //在右侧
                left = mid + 1;
            }
        }
        return left + 1;
    }
}
