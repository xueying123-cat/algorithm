package com.hello.algorithm;

import java.util.HashMap;

/**
 * 山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，
 * 任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
 */
public class MaxNumberMain {

    public static void main(String[] args) {
        MaxNumberMain number = new MaxNumberMain();
        int[] a = {2, 51, 12, 95, 42, 52, 76, 77, 23, 81, 71, 41, 2, 23, 43, 4, 64, 22, 71, 96, 1, 87, 51, 91, 67, 16, 58, 11, 44, 38, 63, 14, 4, 69, 88, 49, 92, 91, 9, 15, 17, 74, 21, 91, 24, 78, 62, 50, 82, 26, 53, 18, 25, 14, 94, 79, 44, 11, 36, 38, 44, 53, 9, 34, 58, 6, 50, 82, 81, 50, 36, 1, 6, 61, 9, 47, 33, 47, 84, 41, 37, 48, 18, 18};
        System.out.println("a====>" + a.length);
       //System.out.println("a==max===>" + number.maxIndex(a));
        System.out.println("a==max===>" + a[81]);
        int[] b = {2,4,1,2,7,8,4};
        System.out.println("a==max===>" + number.maxIndex(b));
    }

    private int maxIndex(int[] a) {
        int index = a.length - 1;
        int max = a[index];
        for (int m = a.length - 1; m >= 0; --m) {
            if (max <= a[m]) {
                index = m;
                max = a[m];
            }else{
                return index;
            }
        }
        return index;
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @return
     */
    private int sort(int[] a) {
        //冒泡排序取最大值
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return a[a.length - 1];
    }

    /**
     * 理解错误，这是查找最大值
     *
     * @param a
     * @return
     */
    private int max(int[] a) {
        HashMap<String, Integer> maxMap = new HashMap<>();
        int index = 0;
        maxMap.put("max", a[index]);
        for (int i = 1; i < a.length; i++) {
            if (maxMap.get("max") < a[i]) {
                index = i;
                maxMap.put("max", a[i]);
            }
        }
        return index;
    }
}
