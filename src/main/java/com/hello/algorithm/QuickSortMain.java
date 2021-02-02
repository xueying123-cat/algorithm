package com.hello.algorithm;

/**
 * 快速排序
 */
public class QuickSortMain {
    public static void main(String[] args) {
        int[] a = {8,5,10,4,2,1,1,6,7};
        int left = 0;
        int right = a.length - 1;
        QuickSortMain sort = new QuickSortMain();
        sort.sort(a, left, right);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
    private void sort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int sign = a[left];
        while (i != j) {
            //查找比sign小的元素位置
            while (a[j] >= sign && i < j) {
                j--;
            }
            //查找比sign大的元素位置
            while (a[i] <= sign && i < j) {
                i++;
            }
            //交换
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //相遇或者遇到（8）（10）（11）等情况，直接交换
        a[left] = a[j];
        a[j] = sign;

        //分割数组重新排序
        sort(a, left, j - 1);
        sort(a, j + 1, right);
    }

    public void quicksort(int[] a, int left, int right) {
        int i, j, t, temp;
        if (left > right)
            return;

        temp = a[left]; //temp中存的就是基准数
        i = left;
        j = right;
        while (i != j) {
            //顺序很重要，要先从右边开始找
            while (a[j] >= temp && i < j)
                j--;
            //再找右边的
            while (a[i] <= temp && i < j)
                i++;
            //交换两个数在数组中的位置
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //最终将基准数归位
        a[left] = a[i];
        a[i] = temp;

        quicksort(a, left, i - 1);//继续处理左边的，这里是一个递归的过程
        quicksort(a, i + 1, right);//继续处理右边的 ，这里是一个递归的过程
    }
}
