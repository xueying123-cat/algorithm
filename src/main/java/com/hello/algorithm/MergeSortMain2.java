package com.hello.algorithm;

import java.util.Arrays;

public class MergeSortMain2 {
    public static void main(String[] args) {
        int[] a = {9, 5, 2, 7, 12, 4, 3, 1, 11};

        //拆分
        //定义下标
        int left = 0;
        int right = a.length - 1;
        int mid = (left + right) / 2;
        int[] b = new int[a.length];
        mergeSort(a, b, left, right);
        //合并
        for (int i = 0; i < b.length; i++) {
            System.out.print("  " + b[i]);
        }
    }

    public static void mergeSort(int[] a, int[] b, int left, int right) {
        if (left == right) {
            b[left] = a[left];
            return;
        }
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, b, left, mid);
            mergeSort(a, b, mid + 1, right);

            //合并
            int i = left;
            int j = mid + 1;
            int t = 0;

            while (i <= mid && j <= right) {
                if (a[i] < a[j]) {
                    b[t] = a[i];
                    t++;
                    i++;
                } else {
                    b[t] = a[j];
                    t++;
                    j++;
                }
            }

            while (i <= mid) {
                b[t++] = a[i++];
            }
            while (j <= right) {
                b[t++] = a[j++];
            }

            t = 0;
            while (left <= right) {
                a[left++] = b[t++];
            }
        }

    }
}
