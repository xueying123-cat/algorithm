package com.hello.algorithm;


/**
 * 从0,1,2,...,n这n+1个数中选择n个数，组成有序数组，找出这n个数中缺失的那个数，要求O(n)尽可能小。
 */
public class MissingNumberMain {
    public static void main(String[] args) {
        int[] a = new int[7];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 6;
        a[5] = 7;
        a[6] = 8;
        MissingNumberMain number = new MissingNumberMain();
        System.out.println("number====>" + number.num1(a));
    }

    /**
     * 顺序查找：时间复杂度O(n)
     *
     * @param a
     * @return
     */
    private int num1(int[] a) {
        //获取第一个数字
        int num = a[0];
        for (int i = 0; i < a.length; i++) {
            if (num != a[i]) {
                return num;
            }
            num++;
        }
        return 0;
    }
}
